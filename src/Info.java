import java.awt.Graphics;

import javax.swing.JPanel;

public class Info extends JPanel{
static int score;
static int time;
static int life;
public  Info() {
	// TODO Auto-generated constructor stub
	score=0;
	time=60;
	life=3;
	
	setSize(500,200);
}
public void paint(Graphics g) {
	//g.drawImage(background, 0, 0, null); // ������ͼ
	//paintHero(g); // ��Ӣ�ۻ�
	//paintBullets(g); // ���ӵ�
	//paintFlyingObjects(g); // ��������
	//P_score(g); // ������
	//paintState(g); // ����Ϸ״̬
}
}
