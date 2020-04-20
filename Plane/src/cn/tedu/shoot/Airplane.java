package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** 小敌机 */
public class Airplane extends FlyingObject implements Enemy{
	private  static BufferedImage[] images;
	static {
			images = new BufferedImage[5];
			for(int i=0;i<images.length;i++) {
					images[i] = loadImage("airplane"+i+".png");
			}
	}
	private int speed; //移动速度
	
	Airplane(){
			super(49,36);
			speed=2;
	}
	public void step() {
		y+=speed;
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
	
	public int getScore() {
			return 1;
	}
}
















