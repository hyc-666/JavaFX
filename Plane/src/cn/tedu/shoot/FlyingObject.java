package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.Graphics;

public abstract class  FlyingObject {
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	/** 给小敌机，大敌机，小蜜蜂提供的*/
	FlyingObject(int width,int height){
		this.width=width;
		this.height=height;
		Random rand=new Random();
		x=rand.nextInt(World.WIDTH-this.width);
		y=	this.height;
	}
	/** 给英雄机，天空，子弹提供的*/
	FlyingObject(int width,int height,int x,int y){
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
	}
		public static BufferedImage loadImage(String fileName) {
				try {
						BufferedImage img =ImageIO.read(FlyingObject.class.getResource(fileName));
						return img;
				}catch(Exception e) {
						e.printStackTrace();
						throw new RuntimeException();
				}
		}
	
	/** 飞行物移动 */
	public abstract void step();
	
	
	public abstract BufferedImage getImage();
	
	public boolean isLife() {
		return state==LIFE;
	}
	public boolean isDead() {
		return state==DEAD;
	}
	public boolean isRemove() {
		return state==REMOVE;
	}
	public void paintObject(Graphics g) {
			g.drawImage(getImage(),x,y,null);
	}
	public boolean outOfBounds() {
		return this.y>=World.HEIGHT;
	}
	public boolean hit(FlyingObject other) {
			int x1 = this.x-other.width;
			int x2 = this.x+this.width;
			int y1 = this.y-other.height;
			int y2 = this.y+this.height;
			int x =	other.x;
			int y =	other.y;
			
			return x>=x1 &&x<=x2
					&& 
					y>=y1&&y<=y2;
	}
	public void goDead() {
			state = DEAD;
	}
}
