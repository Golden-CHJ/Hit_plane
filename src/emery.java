import java.awt.image.BufferedImage;
import java.util.Random;





public class emery {

	int e_x;
	int e_y;
	int e_w;
	int e_h;
	
	BufferedImage image;
	public emery() {
		// TODO Auto-generated constructor stub
		this.image=Game.emery;
		e_w=image.getWidth();
		e_h=image.getHeight();
		e_y = -e_h;          
		Random rand = new Random();
		e_x = rand.nextInt(VALUE.WIDTH - e_w);
	}
	public void Emove() {
		e_y+=2;
	}
	public boolean beHit(Biu biu){
		int x = biu.b_x;  //子弹横坐标
		int y = biu.b_y;  //子弹纵坐标
		return this.e_x<x && x<this.e_x+e_w && this.e_y<y && y<this.e_y+e_h;
	}
}

