package planeFight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;

public class Myplane {

	int x;
	int y=700;
	boolean isbroken=false;
	public Myplane(int x,int y){
		
		this.x=x;
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//×¹»úºó
	public void bang(Graphics g){
		Image img=new ImageIcon(this.getClass().getResource("bang.png")).getImage();
		g.drawImage(img, x-40, y-30, 80, 60, null);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		
		System.exit(0);
	}
	
	public void moveto(int xx,int yy){
		
		x=xx;y=yy;
		
//		int speed=10;
//		if(xx>x){
//			x+=speed;
//			if(yy>y)y+=speed;
//			else if(yy<y)y-=speed;
//		}
//		else if(xx<x){
//			x-=speed;
//			
//			if(yy>y)y+=speed;
//			else if(yy<y)y-=speed;
//		}
	}
	public void draw(Graphics g){
		
		
		Graphics2D gr=(Graphics2D)g;
		
		Image img=new ImageIcon(this.getClass().getResource("myplane.png")).getImage();

//		Image img=new ImageIcon(this.getClass().getResource("mother.png")).getImage();

//		System.out.println("x:"+x+"     y:"+y);
		gr.drawImage(img, x-75, y-50, 150, 100, null);
		
//		gr.setColor(Color.black);
//		gr.fillRect(0, 0, 600, 700);
//		
//		gr.setColor(Color.blue);
//		gr.fillRect(x-40, y-20, 80, 40);
	
//		Point points[]=new Point[9];
//		
//		points[0]=new Point(x,y-20);
		
		
		
		
	}
}
