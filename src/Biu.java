import java.awt.image.BufferedImage;

public class Biu //�ӵ�
{
	int b_x;
	int b_y;
	BufferedImage image;
public Biu(int x,int y) {
	// TODO Auto-generated constructor stub
	b_x=x;
	b_y=y;
	image=Game.biu;
	
}
public void moveBiu() {
	//�ӵ��ٶ�
	b_y-=4;
}
}
