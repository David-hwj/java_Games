package Chaos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Manager extends JFrame {
	
    int x = 80, y =500; // 第一个坐标(最左下角)
    
    int d=20;//斜边
    int dx=16;
    int dy=12;
    //三个面的颜色
    Color color1=new Color(200,0,0);
    Color color2=new Color(130,0,0);
    Color color3=new Color(150,0,0);
    
//根据一个点确定的每一条线存入一个2维数组 
//    int Array[][]={          
//    		{x,y-d,x,y},
//    		{x,y,x+d,y},
//    		{x+d,y,x+d,y-d},
//    		{x,y-d,x+d,y-d},
//    		{x,y-d,x+dx,y-d-dy},
//    		{x+d,y-d,x+d+dx,y-d-dy},
//    		{x+d,y,x+d+dx,y-dy},
//    		{x+d+dx,y-d-dy,x+d+dx,y-dy},
//    		{x+d+dx,y-d-dy,x+dx,y-d-dy}
//    };
  
	
	public static void main(String[] args) {
		Manager jframe = new Manager();
		jframe.initUI();
	}
	/*************窗口******************************************/
	public void initUI() {
		setSize(1000, 600);
		setTitle("门格海绵byHWJ");
		setLocation(0, 100);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(3);
	}
	/**************重写paint*********************************************/
	public void paint (Graphics g){
//		super.paint(g);
		Graphics2D gr=(Graphics2D)g;
		DrawOneByOne(gr,x,y, d, dx, dy);
	}
	/**************用空心海绵画一个空心海绵**********************************************/
	public void DrawOneByOne(Graphics2D gr,int x,int y,int d,int dx,int dy){
		DrawBottomB(gr,x,y,d,dx,dy );
		DrawMidB(gr,x,y,d,dx ,dy );
		DrawTopB(gr,x,y,d,dx ,dy );
	}
	/**************用空心海绵画三层******************************************/
	public void DrawBottomB(Graphics2D g,int x,int y,int d,int dx,int dy){
		
		DrawOne(g,		x+dx*2*3,		y-dy *2*3,		d ,dx ,dy );/*7*/
		DrawOne(g,		x+dx*3 ,		y-dy *3,		d ,dx ,dy );/*4*/
		DrawOne(g,		x+dx *2*3+d*3 ,	y-dy*2*3 ,		d ,dx ,dy );/*8*/	
		DrawOne(g,		x,			y,			d ,dx ,dy );/*1*/
//	    DrawOne(g,		x+dx+d,		y-dy,		d,dx,dy);/*5*/
		DrawOne(g,		x+dx*3 *2+d*3*2,	y-dy*3*2,		d ,dx ,dy );/*9*/
		DrawOne(g,		x+d *3,		y,			d ,dx ,dy );/*2*/
		DrawOne(g,		x+dx *3+d*3 *2,	y-dy*3 ,		d ,dx ,dy );/*6*/
		DrawOne(g,		x+d *3*2,		y,			d ,dx ,dy );/*3*/	
	}
	public void DrawMidB(Graphics2D g,int x,int y,int d,int dx,int dy){
		
		DrawOne(g,		x+dx *3*2,		y-dy *3*2-d*3 ,		d ,dx ,dy );/*7*/
//		DrawOne(g,		x+dx,		y-dy-d,		d,dx,dy);/*4*/
//		DrawOne(g,		x+dx*2+d,	y-dy*2-d,		d,dx,dy);/*8*/	
		DrawOne(g,		x,			y-d *3,			d ,dx ,dy );/*1*/
//   	DrawOne(g,		x+dx+d,		y-dy-d,		d,dx,dy);/*5*/
		DrawOne(g,		x+dx *2*3+d*3 *2,	y-dy *3*2-d*3 ,		d ,dx ,dy );/*9*/
//		DrawOne(g,		x+d,		y-d,			d,dx,dy);/*2*/
//		DrawOne(g,		x+dx+d*2,	y-dy-d,		d,dx,dy);/*6*/
		DrawOne(g,		x+d *3*2,		y-d *3,			d ,dx ,dy );/*3*/	
	}
	public void DrawTopB(Graphics2D g,int x,int y,int d,int dx,int dy){
		
		DrawOne(g,		x+dx *3*2,		y-dy *3*2-d*3 *2,		d ,dx ,dy );/*7*/
		DrawOne(g,		x+dx*3 ,		y-dy*3 -d*2*3 ,		d ,dx ,dy );/*4*/
		DrawOne(g,		x+dx*3 *2+d*3 ,	y-dy *3*2-d*3 *2,		d ,dx ,dy );/*8*/	
		DrawOne(g,		x,			y-d*2*3 ,			d ,dx ,dy );/*1*/
//	    DrawOne(g,		x+dx+d,		y-dy-d*2,		d,dx,dy);/*5*/
		DrawOne(g,		x+dx *3*2+d *3*2,	y-dy*3 *2-d*3 *2,		d ,dx ,dy );/*9*/
		DrawOne(g,		x+d*3 ,		y-d*2*3 ,			d ,dx ,dy );/*2*/
		DrawOne(g,		x+dx*3 +d*3 *2,	y-dy*3 -d*2*3 ,		d ,dx ,dy );/*6*/
		DrawOne(g,		x+d *3*2,		y-d*2*3 ,			d ,dx ,dy );/*3*/	
	}
	
	/**************用实心立方体画一个空心海绵**********************************************/
	public void DrawOne(Graphics2D gr,int x,int y,int d,int dx,int dy){
		DrawBottom(gr,x,y,d,dx,dy);
		DrawMid(gr,x,y,d,dx,dy);
		DrawTop(gr,x,y,d,dx,dy);
	}
	
	/**************用实心立方体画三层******************************************/
	public void DrawBottom(Graphics2D g,int x,int y,int d,int dx,int dy){
		Draw(g,		x+dx*2,		y-dy*2,		d,dx,dy);/*7*/
		Draw(g,		x+dx,		y-dy,		d,dx,dy);/*4*/
		Draw(g,		x+dx*2+d,	y-dy*2,		d,dx,dy);/*8*/	
		Draw(g,		x,			y,			d,dx,dy);/*1*/
//	    Draw(g,		x+dx+d,		y-dy,		d,dx,dy);/*5*/
		Draw(g,		x+dx*2+d*2,	y-dy*2,		d,dx,dy);/*9*/
		Draw(g,		x+d,		y,			d,dx,dy);/*2*/
		Draw(g,		x+dx+d*2,	y-dy,		d,dx,dy);/*6*/
		Draw(g,		x+d*2,		y,			d,dx,dy);/*3*/	
	}
	public void DrawMid(Graphics2D g,int x,int y,int d,int dx,int dy){
		Draw(g,		x+dx*2,		y-dy*2-d,		d,dx,dy);/*7*/
//		Draw(g,		x+dx,		y-dy-d,		d,dx,dy);/*4*/
//		Draw(g,		x+dx*2+d,	y-dy*2-d,		d,dx,dy);/*8*/	
		Draw(g,		x,			y-d,			d,dx,dy);/*1*/
//   	Draw(g,		x+dx+d,		y-dy-d,		d,dx,dy);/*5*/
		Draw(g,		x+dx*2+d*2,	y-dy*2-d,		d,dx,dy);/*9*/
//		Draw(g,		x+d,		y-d,			d,dx,dy);/*2*/
//		Draw(g,		x+dx+d*2,	y-dy-d,		d,dx,dy);/*6*/
		Draw(g,		x+d*2,		y-d,			d,dx,dy);/*3*/	
	}
	public void DrawTop(Graphics2D g,int x,int y,int d,int dx,int dy){
		Draw(g,		x+dx*2,		y-dy*2-d*2,		d,dx,dy);/*7*/
		Draw(g,		x+dx,		y-dy-d*2,		d,dx,dy);/*4*/
		Draw(g,		x+dx*2+d,	y-dy*2-d*2,		d,dx,dy);/*8*/	
		Draw(g,		x,			y-d*2,			d,dx,dy);/*1*/
//	    Draw(g,		x+dx+d,		y-dy-d*2,		d,dx,dy);/*5*/
		Draw(g,		x+dx*2+d*2,	y-dy*2-d*2,		d,dx,dy);/*9*/
		Draw(g,		x+d,		y-d*2,			d,dx,dy);/*2*/
		Draw(g,		x+dx+d*2,	y-dy-d*2,		d,dx,dy);/*6*/
		Draw(g,		x+d*2,		y-d*2,			d,dx,dy);/*3*/	
	}
	
	/**************画一个立方体***************************************************/
	
	public void Draw(Graphics2D g,int x,int y,int d,int dx,int dy){
		int Array[][]={          
	    		{x,y-d,x,y},
	    		{x,y,x+d,y},
	    		{x+d,y,x+d,y-d},
	    		{x,y-d,x+d,y-d},
	    		{x,y-d,x+dx,y-d-dy},
	    		{x+d,y-d,x+d+dx,y-d-dy},
	    		{x+d,y,x+d+dx,y-dy},
	    		{x+d+dx,y-d-dy,x+d+dx,y-dy},
	    		{x+d+dx,y-d-dy,x+dx,y-d-dy}
	    };
		Graphics2D gr=g;
		gr.setColor(Color.black);
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
//		for(int i=0;i<9;i++){
//				gr.drawLine(Array[i][0], Array[i][1], Array[i][2], Array[i][3]);
//		}
		//填充第一个面
		Polygon pon1=new Polygon();
		pon1.addPoint(Array[0][0], Array[0][1]);
		pon1.addPoint(Array[0][2], Array[0][3]);
		pon1.addPoint(Array[2][0], Array[2][1]);
		pon1.addPoint(Array[2][2], Array[2][3]);
		gr.setColor(color1);
		gr.fillPolygon(pon1);
		//填充第二个面
		Polygon pon2=new Polygon();
		pon2.addPoint(Array[3][0], Array[3][1]);				
		pon2.addPoint(Array[3][2], Array[3][3]);
		pon2.addPoint(Array[8][0], Array[8][1]);
		pon2.addPoint(Array[8][2], Array[8][3]);
		gr.setColor(color2);
		gr.fillPolygon(pon2);
		//填充第三个面
		Polygon pon3=new Polygon();
		pon3.addPoint(Array[2][0], Array[2][1]);
		pon3.addPoint(Array[2][2], Array[2][3]);
		pon3.addPoint(Array[7][0], Array[7][1]);
		pon3.addPoint(Array[7][2], Array[7][3]);
		gr.setColor(color3);
		gr.fillPolygon(pon3);	
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
