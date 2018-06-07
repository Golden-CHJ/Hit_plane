import java.awt.image.BufferedImage;

public class Biu //子弹
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
	//子弹速度
	b_y-=4;
}
}
