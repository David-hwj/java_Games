package planeFight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * 
 * @author 黄卫江
 *
 */
public class MyBullet {

	int x;
	int y;
	Myplane myplane;
	ArrayList<MyBullet> mybullet ;
	boolean isbroken=false;
	
	public MyBullet(int x,int y ){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * 子弹移动
	 * @param xx
	 * @param yy
	 */
	public void move(){
		y-=20;
	}
	
	/**
	 * 画出子弹
	 * @param g
	 */
	public void draw(Graphics g){
		Graphics2D gr=(Graphics2D)g;
		
		Image img=new ImageIcon(this.getClass().getResource("mybullet.jpg")).getImage();
//		Image img=new ImageIcon(this.getClass().getResource("knife.png")).getImage();

		//gr.drawImage(img, x-2, y-50, 5, 20, null);
		gr.drawImage(img, x-2, y-50, 40, 100, null);

//		gr.setColor(Color.CYAN);
//		gr.fillOval(x-5, y-80, 10, 30);
	}
	
	
}
