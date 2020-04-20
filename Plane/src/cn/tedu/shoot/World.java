package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 整个游戏世界 */
public class World extends JPanel{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;
	
	public static final int START =0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;
	
	private static BufferedImage start;
	private static BufferedImage pause;
	private static BufferedImage gameover;
	static {
		start = FlyingObject.loadImage("start.png");
		pause = FlyingObject.loadImage("pause.png");
		gameover = FlyingObject.loadImage("gameover.png");
	}
	
	private Sky sky = new Sky();//天空
	private Hero hero = new Hero();//英雄机
	private FlyingObject[] enemies = {} ;//敌人（小敌机，大敌机，小蜜蜂）
	private Bullet[] bullets = {};
	
	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type<5) {
			return new Bee();
		}else if(type<13) {
			return new Airplane();
		}else {
			return new BigAirplane();
		}
	}
	
	int enterIndex =0;
	public void enterAction() {
		enterIndex++;
		if(enterIndex%40==0) {
				FlyingObject obj = nextOne();
				enemies = Arrays.copyOf(enemies,enemies.length+1);
				enemies[enemies.length-1] = obj;
		}
	}
	
	int shootIndex = 0;
	public void shootAction(){
		shootIndex++;
		if(shootIndex%20==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);
			
		}
	}
	public void steepAction() {
			sky.step();
			hero.step();
			for(int i=0;i<enemies.length;i++) {
				enemies[i].step();
			}
			for(int i=0;i<bullets.length;i++) {
				bullets[i].step();
			}
	}
	public void outOfBountsAction() {
		int index = 0;
		FlyingObject[] enemyLives=new FlyingObject[enemies.length];
		for (int i=0;i<enemies.length;i++) {
			FlyingObject f = enemies[i];
			if(!f.outOfBounds()&& !f.isRemove()) {
				enemyLives[index] = f ;
				index++;
			}
		}
		enemies = Arrays.copyOf(enemyLives, index);
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length]; 
				for(int i=0;i<bullets.length;i++) {
					Bullet b = bullets[i];
					if(!b.outOfBounds()&& !b.isRemove()) {
						bulletLives[index]=b;
						index++;
					}
				}bullets = Arrays.copyOf(bulletLives, index);
				//System.out.println(enemies.length+","+bullets.length);
		}
		int score = 0;
		public void bulletBangAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			for(int j=0;j<enemies.length;j++) {
				FlyingObject f = enemies[j];
				if(b.isLife() && f.isLife() &&f.hit(b)) {
					b.goDead();
					f.goDead();
					
									
					if(f instanceof Enemy) {
						Enemy e  =(Enemy)f;
						score += e.getScore();
					}
					if(f instanceof Award) {
						Award a =(Award)f;
						int type = a.getAwardType();
						switch(type) {
						case Award.DOUBLE_FIRE:
							hero.addDoubleFire();
							break;
						case Award.LIFE:
							hero.addLife();
							break;
						
						}
					}
				}
			}
		}
	}	
		
		public void heroBangAction() {
				for(int i=0;i<enemies.length;i++) {
						FlyingObject f = enemies[i];
						if(hero.isLife() && f.isLife() && f.hit(hero)) {
								f.goDead();
								hero.subtractLife();
								hero.clearDoubleFire();
						}
				}
		}
		
		public void checkGameOverAction() {
			if(hero.getLife()<=0) {
				state=GAME_OVER;
			}
		}
		
	public void action(JFrame frame) { 
		MouseAdapter l = new MouseAdapter() {
			//换成单独开线程实时获取鼠标位置
				public void mouseMoved(MouseEvent e) {
					if(state==RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
					}
				}
				public void mouseClicked(MouseEvent e) {
					switch(state) {
					case START:
						state=RUNNING;
						break;
					case GAME_OVER:
						score = 0;
						sky = new Sky();
						hero = new Hero();
						enemies = new FlyingObject[0];
						bullets = new Bullet[0];
						state=START;
						break;
					}
				}
				public void mouseExited(MouseEvent e) {
					if(state==RUNNING) {
						state=PAUSE;
					}
				}
				public void mouseEntered(MouseEvent e) {
					if(state==PAUSE) {
						state=RUNNING;
					}
				}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);		
		
//		new Thread(){
//			public void run() {
//				while(true){
//					try{
//						if(state==RUNNING) {
//							//获取的是全局的鼠标位置,需要变成窗口内的鼠标位置
//							int x = (int)frame.getMousePosition().getX() -8;
//							int y = (int)frame.getMousePosition().getY() -31;
//							hero.moveTo(x, y,true);
//						}
//					}catch(Exception e){}
//				}
//			}
//		}.start();
		
		Timer timer = new Timer();
		int intervel = 10;
		timer.schedule(new TimerTask() {
			public void run() {
				if(state==RUNNING) {
					enterAction();
					shootAction();
					steepAction();
					outOfBountsAction();
					bulletBangAction();
					heroBangAction();
					checkGameOverAction();
				}	
				repaint();
			}
		},intervel,intervel);
			}
	public void paint(Graphics g) {
		sky.paintObject(g);
		hero.paintObject(g);
		for(int i=0;i<enemies.length;i++) {
				enemies[i].paintObject(g);
		}
		for(int i=0;i<bullets.length;i++) {
				bullets[i].paintObject(g);
		}
		g.drawString("SCORE:"+score,10,25);
		g.drawString("LIFE:"+hero.getLife(),10,45);
		g.drawString("DOUBLE_FIRE:"+hero.getDoubleFire(), 10,35);
		switch(state) {
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
		break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");
		World world = new World();
		frame.add(world);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		
		world.action(frame);
	}
	}















