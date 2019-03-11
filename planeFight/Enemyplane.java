package planeFight;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Enemyplane {

	int x=300;
	int y=50;
	boolean isbroken=false;
	public Enemyplane(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void move(){
		y+=2;
	}
	public void draw(Graphics g) throws IOException{
		
		//Image img=new ImageIcon(this.getClass().getResource("enemyplane.png")).getImage();
		File f=new File("C:\\HelloWorld\\Code\\Java\\HWJ\\src\\planeFight\\huangting1.jpg");
		
		Image img=ImageIO.read(f);

		//g.drawImage(img, x-40, y-30, 80, 60, null);
		g.drawImage(img, x-40, y-30, 60, 60, null);
		
//		gr.setColor(Color.blue);
//		gr.fillRect(x-40, y-20, 80, 40);
	}
	public void bang(Graphics g){
		Image img=new ImageIcon(this.getClass().getResource("bang.png")).getImage();
		g.drawImage(img, x-40, y-30, 80, 60, null);
		
	}
}
