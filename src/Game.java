import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Game extends JPanel {
	 
	/*****�̺�� 2018.6.7*****/
	 /***�����Ͷ�ʱ��***/
	 final long end=6000;
	 long sub=end;
	 int G_score = 0; // �÷�
	 Timer timer; // ��ʱ��
	 //
	static Plane plane1;
	static Biu []biu1= {};
	static emery []emery1= {};
	 /**/
	 public static BufferedImage background;
	 public static BufferedImage plane;
	 public static BufferedImage biu;
	 public static BufferedImage emery;
	
	 static { 
			try {
				background = ImageIO.read(Game.class
						.getResource("background.jpg"));
				plane = ImageIO.read(Game.class
						.getResource("plane.png"));
				biu = ImageIO.read(Game.class.getResource("biu.png"));
				emery = ImageIO
						.read(Game.class.getResource("emery.png"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	 }
	public Game() {
		 plane1=new Plane();
		
	}
	/*����*/
	public void P_score(Graphics g) {
		int x = 310; // x����
		int y = 25; // y����
		Font font = new Font("����", Font.BOLD, 20); 
		g.setColor(new Color(0xFFF));
		g.setFont(font); // ��������
		g.drawString("����:" + G_score, x, y); 
		y=y+20; // y������20
		g.drawString("ʣ��ʱ��:" + sub/10, x, y);
		g.drawString("��������Ʒ����������Ļ���",x,y+20); 
		//update(g);
	}
	/*player*/
	public void  P_plane(Graphics g) {
		g.drawImage(plane1.image, plane1.p_x,  plane1.p_y, null);
	}
	/*biu*/
	
	public void P_biu(Graphics g) 
		{
		for (int i = 0; i <biu1.length; i++) {
			Biu f = biu1[i];
			g.drawImage(biu1[i].image,biu1[i].b_x,biu1[i].b_y,
					null);
		}
			
		}
	
	/*emery*/
	public void P_emery(Graphics g) {
		for (int i = 0; i < emery1.length; i++) {
			emery f = emery1[i];
			g.drawImage(f.image, f.e_x, f.e_y, null);
		}
	}
	/*���ɷ�����*/
	int index=0;
	public void emeryCome() {
		index++;
		if (index % 30 == 0) { 
			emery obj = new emery(); 
			emery1 = Arrays.copyOf(emery1, emery1.length + 1);
			emery1[emery1.length - 1] = obj;
			/*zidan*/
			
		}
	}
	public void move() {
		for (int i = 0; i < emery1.length; i++) { // ��������һ��
			emery f = emery1[i];
			f.Emove();
		}
		for (int i = 0; i < biu1.length; i++) { // ��������һ��
			Biu f = biu1[i];
			f.moveBiu();
		}
	}
	/*�Ƿ����*/
	/*public boolean biuOut() {
		if(biu1.b_y>VALUE.HEITH) {
			biu1.b_y=45;
			return true;
		}
		else {
			return false;
		}
	}*/
	
	/*����*/
	public void P_hit() {
		for (int i = 0; i < biu1.length; i++) { // ���������ӵ�
			Biu b = biu1[i];
			hit(b);
		}
	}
	public void hit(Biu biu2) {
		int index=-1;
		
		for (int i = 0; i < emery1.length; i++) {
			emery obj = emery1[i];
			if (obj.beHit(biu2)) { // �ж��Ƿ����
				index = i; 
				
				break;
				
			}
		}
		if(index!=-1)
		{
			

		emery temp = emery1[index]; 
		emery1[index] = emery1[emery1.length - 1];
		emery1[emery1.length - 1] = temp;

		emery1 = Arrays.copyOf(emery1, emery1.length - 1);
		G_score+=100;
		System.out.println("����"+G_score);
		}
		
	}
	/**��*/
	public void paint(Graphics g) {
		
		g.drawImage(background, 0, 0, null); 
        P_plane(g); 
		P_biu(g); // ���ӵ�
		P_emery(g);
		P_score(g); 
	
	}
	/*����**/
	public void start() {
    /* KeyListener keyListener=new KeyListener() {
    	 
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("shang");
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("shang");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("shang");
				switch(e.getKeyCode())  
				
		        {  
		            case KeyEvent.VK_UP:
		            	System.out.println("shang");
		            	plane1.p_y++;
		            	repaint();
		            	break;
		            case KeyEvent.VK_DOWN:
		            	plane1.p_y--;
		            	repaint();
		            	break;
		            case KeyEvent.VK_LEFT:
		            	plane1.p_x--;
		            	repaint();
		            	break;
		            case KeyEvent.VK_RIGHT:
		            	plane1.p_x++;
		            	repaint();
		            	break;
			}
			
			}
		};*/
		
		MouseAdapter mouseAdapter=new MouseAdapter() {
			public void mouseMoved(MouseEvent e) { // ����ƶ�
				
					
				
			}
			public void mouseClicked(MouseEvent e) { // ����ƶ�
				
				int shootIndex = 0; // �������

					shootIndex++;
					
						Biu[] bs = new Biu[1];
						bs[0] = new Biu(plane1.p_x+plane1.p_width/2,plane1.p_y-20);  
						
						biu1 = Arrays.copyOf(biu1, biu1.length + bs.length); // ����
						System.arraycopy(bs, 0, biu1, biu1.length - bs.length,
								bs.length); // ׷������
					
				
				
			}
		};
		
		
		
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);
		 timer=new Timer();
		 timer.schedule(new TimerTask() {
			 
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				 if(sub<0)
				 {
					 
				    return;
				 }
				 sub--;
				 	//System.out.println("tick"+sub);
				 
				 	emeryCome();
				 	//shootAction();
					move();
				 	P_hit();
				 	repaint();
				 } 
			
		},0,10);
		
		 
	}
	
	//main
	public static void main(String arg0[]) {
		JFrame frame = new JFrame("Thunder Plane v1.0");
		Game game = new Game(); // ������
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("shang");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("shang");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
                 switch(e.getKeyCode())  
				
		        {  
		            case KeyEvent.VK_UP:
		            	System.out.println("shang");
		            	plane1.p_y-=10;
		            	game.repaint();
		            	break;
		            case KeyEvent.VK_DOWN:
		            	plane1.p_y+=10;
		            	game.repaint();
		            	break;
		            case KeyEvent.VK_LEFT:
		            	plane1.p_x-=10;
		            	game.repaint();
		            	break;
		            case KeyEvent.VK_RIGHT:
		            	plane1.p_x+=10;
		            	game.repaint();
		            	break;
			}
			
			}
		});
		
	
		frame.add(game);
		
		 // �������ӵ�JFrame��
		frame.setSize(VALUE.WIDTH, VALUE.HEITH); // ���ô�С
		frame.setAlwaysOnTop(true); // ��������������
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ĭ�Ϲرղ���
		
		frame.setVisible(true); // �������paint
		
		game.start();
		
		
	}
}
	