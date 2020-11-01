package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** С�л� */
public class Airplane extends FlyingObject implements Enemy{
	private  static BufferedImage[] images;
	static {
			images = new BufferedImage[5];
			for(int i=0;i<images.length;i++) {
					images[i] = loadImage("airplane"+i+".png");
			}
	}
	private int speed; //�ƶ��ٶ�
	
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
					 * 10ms img=images[1],index++		index=2,����images[1]
					 * �ж�index�Ƿ����images��λ����������	
					 * 20ms img=images[2],index++		index=3,����images[2]
					 * �ж�index�Ƿ����images��λ����������	
					 * 30ms img=images[3],index++		index=4,����images[3]
					 * �ж�index�Ƿ����images��λ����������	
					 * 40ms img=images[4],index++		index=5,����images[4]
					 * �ж�index�Ƿ����images��λ������������״̬�޸�ΪREMOVE������null	
					 * 
					 */
					
					
					
					
			}
			return null;
	}
	
	public int getScore() {
			return 1;
	}
}















