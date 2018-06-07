import java.awt.image.BufferedImage;

public class Plane {
int life;
int p_width;
int p_height;
int p_x=200;
int p_y=50;
BufferedImage image;
public Plane() {
	// TODO Auto-generated constructor stub
	life=3;
	image=Game.plane;
	p_width = image.getWidth();
	p_height = image.getHeight();
}
public void move(int x,int y) {
	this.p_x=x;
	this.p_y=y;
}

}
