package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/** 小蜜蜂 */
public class Bee extends FlyingObject implements Award{
	private  static BufferedImage[] images;
	static {
		images=new BufferedImage[5];
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	private int xSpeed; //x坐标移动速度
	private int ySpeed; //y坐标移动速度
	private int awardType; //奖励类型
	
	Bee(){
		super(60,50);
		Random rand=new Random();
		xSpeed=1;
		ySpeed=2;
		awardType=rand.nextInt(2);
	}
	public void step() {
		y+=ySpeed;
		x+=xSpeed;
		if(x<=0||x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
	}
	int index=1;
	public BufferedImage getImage() {
			if(isLife()) {
				return images[0];
			}else if(isDead()) {
					BufferedImage img = images[index++];
					if(index==images.length) {
						state = REMOVE;
					}
					return img;
					
					/*																index=1
					 * 10ms img=images[1],index++		index=2,返回images[1]
					 * 判断index是否等于images的位数，不成立	
					 * 20ms img=images[2],index++		index=3,返回images[2]
					 * 判断index是否等于images的位数，不成立	
					 * 30ms img=images[3],index++		index=4,返回images[3]
					 * 判断index是否等于images的位数，不成立	
					 * 40ms img=images[4],index++		index=5,返回images[4]
					 * 判断index是否等于images的位数，成立。将状态修改为REMOVE，返回null	
					 * 
					 */
					
					
					
					
			}
			return null;
	}
	public int getAwardType() {
		return awardType;
	}
}


















