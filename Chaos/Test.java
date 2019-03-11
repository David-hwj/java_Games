package Chaos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JFrame;

public class Test extends JFrame{

	Color color1=new Color(200,0,0);
    Color color2=new Color(130,0,0);
    Color color3=new Color(150,0,0);
    Graphics g;
    Point p0=new Point(20,560);
    int d0=100;
    int dx0=30;
    int dy0=40;
	public static void main(String[] args) {
		Test ttt=new Test();
		ttt.initUI();
		
	}
public void initUI(){
	setSize(800,600);
	setResizable(false);
	setVisible(true);
	g=this.getGraphics();
	DrawJZT((Graphics2D)g,p0,d0,dx0,dy0);
}
	
//public void paint(Graphics g){
//	super.paint(g);
//	DrawJZT((Graphics2D)g,p0,d0,dx0,dy0);
//}
	
	public void DrawJZT(Graphics2D g,Point p,int d,int dx,int dy){

		try{
			Thread.sleep(100);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int x=p.x;
		int y=p.y;
		Point point1=new Point(x+d/2,y-d);
		Point point2=p;
		Point point3=new Point(x+d,y);
		Point point4=new Point(x+d+dx,y-dy);
		Graphics2D gr=g;
		
//		if(j==1){
//			gr.setColor(Color.black);
//			gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//					RenderingHints.VALUE_ANTIALIAS_ON);
//			for(int i=0;i<9;i++){
//					gr.drawLine(Array[i][0], Array[i][1], Array[i][2], Array[i][3]);
//			}
//		}
		//填充第一个面
				Polygon pon1=new Polygon();
				pon1.addPoint(point1.x,point1.y);
				pon1.addPoint(point2.x,point2.y);
				pon1.addPoint(point3.x,point3.y);
				
				gr.setColor(color1);
				gr.fillPolygon(pon1);
				System.out.println("aaaaaaaaaaaaaaaaa"+point1.x+ "  "+point1.y);
				System.out.println("aaaaaaaaaaaaaaaaa"+point2.x+ "  "+point2.y);
				System.out.println("aaaaaaaaaaaaaaaaa"+point3.x+ "  "+point3.y);
				
				
				
		//填充第二个面
				Polygon pon2=new Polygon();
				pon2.addPoint(point1.x,point1.y);
				pon2.addPoint(point4.x,point4.y);
				pon2.addPoint(point3.x,point3.y);
				
				gr.setColor(color2);
				gr.fillPolygon(pon2);
		
	}
	
	
}
