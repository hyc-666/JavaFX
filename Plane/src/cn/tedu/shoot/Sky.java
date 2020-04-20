package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** ��� */
public class Sky extends FlyingObject {
		private  static BufferedImage image;
		static {
			image = loadImage("background.png");
		}
	
	
		private int speed; //�ƶ��ٶ�
		private int y1; //��2��ͼƬ��y����
		Sky(){
			super(World.WIDTH,World.HEIGHT,0,0);
				speed=1;
				y1=-World.HEIGHT;
		}
		public void step() {
				y+=speed;
				y1+=speed;
				if(y>=World.HEIGHT) {
					y=-World.HEIGHT;
				}
				if(y1>=World.HEIGHT) {
					y1=-World.HEIGHT;
				}
		}
	
		public BufferedImage getImage() {
			return image;
		}
		public void paintObject(Graphics g) {
			g.drawImage(getImage(),x,y,null);
			g.drawImage(getImage(),x,y1,null);
	}
		
}















