package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/** 子弹 */
public class Bullet extends FlyingObject{
	private  static BufferedImage image;
	static {
			image = loadImage("bullet.png");
	}
	private	 int speed; //移动速度
	
	Bullet(int x,int y){
			super(8,14,x,y);
			speed=3;
	}
	public void step() {
		y-=speed;
	}
	
	public BufferedImage getImage() {
		if(isLife()) {
				return image;
		}else if(isDead()) {
				state = REMOVE;
		}return null;
	}
	public boolean outOfBounds() {
		return this.y<=-this.height;
	}
	
}
 











