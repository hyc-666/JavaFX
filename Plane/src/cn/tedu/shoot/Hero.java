package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/** 英雄机 */
public class Hero extends FlyingObject {
	private  static BufferedImage[] images;
	static {
		images = new BufferedImage[3];
		images[0] = loadImage("hero0.png");
		images[1] = loadImage("hero1.png");
		images[2] = loadImage("hero2.png");
	}
	private int life;   //命
	private int doubleFire; //火力值
	public int getDoubleFire() {
		return doubleFire;
	}
	
	Hero(){
		super(97,124,140,400);
			life=300;
			doubleFire=0;
			t1.start();
	}
	boolean ismove = true;
	/** 英雄机随着鼠标移动 x/y:鼠标的x坐标和y坐标 */
	void moveTo(int x,int y) {
		this.x= x-width/2;
		this.y= y-height/2;
		ismove = true;
		stop = true;
	}
	Thread t1 = new Thread(){
		public void run(){
			System.out.println("线程启动");
			while(true){
				try {
					Thread.sleep(50);
					if(!ismove){
						shutdown();
					}
					ismove = false;
				} catch (Exception e) {
				}
			}
		}
	};
	boolean stop =true;
	public void shutdown(){
			if(stop){
				stop = false;
				System.out.println("停止移动了");
			}
	}
	public void step() {
		
	}
	int index=0;//下标
	public BufferedImage getImage() {
		 	if(isLife()) {
		 		if(stop){
		 			return images[index++%2];
		 		}else
		 			return images[2];
		 	}
		 	return null;
	}
	/*
	 * 10ms 返回index[0] 因为0取余2得0，所以返回0，index++
	 * 20ms 返回index[1] 因为1取余2得1，所以返回1，index++
	 * 30ms 返回index[0] 因为2取余2得0，所以返回0，index++
	 * 40ms 返回index[1] 因为3取余2得1，所以返回1，index++
	 * 50ms 返回index[0] 因为4取余2的0，所以返回0，index++
	 */
		public Bullet[] shoot() {
		 	int xStep = this.width/4;
		 	int yStep = 20;
			if(doubleFire>0) {
		 			Bullet[] bs = new Bullet[2];
		 			bs[0] = new Bullet(this.x+1*xStep,this.y-yStep);
		 			bs[1] = new Bullet(this.x+3*xStep,this.y-yStep);
		 			doubleFire-=2;
		 			return bs;
		 	}else {
		 			Bullet[] bs = new Bullet[1];
		 			bs[0] = new Bullet(this.x+2*xStep,this.y-yStep);
		 			return bs;
		 	}
		 }
	
		
		public void addLife() {
			life++;
		}
		public int getLife() {
				return life;
		}
		public void subtractLife() {
			life--;
		}
		public void addDoubleFire() {
			doubleFire+=40;
		}
		public void clearDoubleFire() {
			doubleFire = 0;
		}
}

















