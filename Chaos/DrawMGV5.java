package Chaos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JFrame;

public class DrawMGV5 extends JFrame{
	/*****************************************************************/
public void initUI(){
this.setSize(600,800);
this.setVisible(true);
this.setTitle("门格海绵--分形系列@蓝杰");
this.setDefaultCloseOperation(3);
}
/*****************************************************************/
public void paint(Graphics g){
super.paint(g);
int x=400,y=300,d=120,dx=80,dy=60;
Point p0=new Point(x,y);//起点
drawButtonLevel(g,p0,d,dx,dy);//画底层

drawMidLevel(g,p0,d,dx,dy);//画中层
drawTopLevel(g,p0,d,dx,dy);//画顶层
for(int i=0;i<pn.length;i++){
Point ptem=pn[i];
if(ptem!=null){
drawButtonLevel(g,ptem,d/3,dx/3,dy/3);//画底层
drawMidLevel(g,ptem,d/3,dx/3,dy/3);//画中层
drawTopLevel(g,ptem,d/3,dx/3,dy/3);//画顶层
}
}
} 
/*****************************************************************/
//保存下一次的
Point[] pn=new Point[20];//起点
/*****************************************************************/
private void drawMidLevel(Graphics g,Point p0,int d,int dx,int dy){
Point[] ps1=getPointByP0(p0,d,dx,dy);//根据起点得到另外6个点
Point[] ps2=getPointByP0(ps1[3],d,dx,dy);//这个点放到最后画
Point[] ps3=getPointByP0(ps2[5],d,dx,dy);//这个不需要画出来
Point[] ps4=getPointByP0(ps3[5],d,dx,dy); 
draw(g,ps4[0],ps4[1],ps4[2],ps4[3],ps4[4],ps4[5],ps4[6]);
Point[] ps5=getPointByP0(ps4[1],d,dx,dy);//这个不需要画出来
Point[] ps6=getPointByP0(ps5[1],d,dx,dy);//这个不需要画出来
draw(g,ps6[0],ps6[1],ps6[2],ps6[3],ps6[4],ps6[5],ps6[6]);
Point[] ps7=getPointByP0(ps2[1],d,dx,dy);//这个不需要画出来
Point[] ps8=getPointByP0(ps7[1],d,dx,dy);//这个不需要画出来
draw(g,ps8[0],ps8[1],ps8[2],ps8[3],ps8[4],ps8[5],ps8[6]);
draw(g,ps2[0],ps2[1],ps2[2],ps2[3],ps2[4],ps2[5],ps2[6]); }
/*****************************************************************/
private void drawTopLevel(Graphics g,Point p0,int d,int dx,int
dy){
Point[] ps1=getPointByP0(p0,d,dx,dy);//根据起点得到另外6个点
Point[] ps2=getPointByP0(ps1[5],d,dx,dy);//根据起点得到另外6个点
 
Point[] ps3=getPointByP0(ps2[5],d,dx,dy);//根据起点得到另外6个点
Point[] ps4=getPointByP0(ps3[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps5=getPointByP0(ps4[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps7=getPointByP0(ps1[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps8=getPointByP0(ps7[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps9=getPointByP0(ps8[5],d,dx,dy);//根据起点得到另外6个点
//画出第一个个立方体
draw(g,ps5[0],ps5[1],ps5[2],ps5[3],ps5[4],ps5[5],ps5[6]);

draw(g,ps4[0],ps4[1],ps4[2],ps4[3],ps4[4],ps4[5],ps4[6]);
draw(g,ps9[0],ps9[1],ps9[2],ps9[3],ps9[4],ps9[5],ps9[6]);
draw(g,ps8[0],ps8[1],ps8[2],ps8[3],ps8[4],ps8[5],ps8[6]);
draw(g,ps7[0],ps7[1],ps7[2],ps7[3],ps7[4],ps7[5],ps7[6]); 
draw(g,ps3[0],ps3[1],ps3[2],ps3[3],ps3[4],ps3[5],ps3[6]);
draw(g,ps2[0],ps2[1],ps2[2],ps2[3],ps2[4],ps2[5],ps2[6]);
draw(g,ps1[0],ps1[1],ps1[2],ps1[3],ps1[4],ps1[5],ps1[6]); } 
/*****************************************************************/
private void drawButtonLevel(Graphics g,Point p0,int d,int dx,int
dy){
Point[] ps1=getPointByP0(p0,d,dx,dy);//根据起点得到另外6个点
 ps1=getPointByP0(ps1[3],d,dx,dy);//根据起点得到另外6个点
ps1=getPointByP0(ps1[3],d,dx,dy);//根据起点得到另外6个点
Point[] ps2=getPointByP0(ps1[5],d,dx,dy);//根据起点得到另外6个点
Point[] ps3=getPointByP0(ps2[5],d,dx,dy);//根据起点得到另外6个点
Point[] ps4=getPointByP0(ps3[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps5=getPointByP0(ps4[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps7=getPointByP0(ps1[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps8=getPointByP0(ps7[1],d,dx,dy);//根据起点得到另外6个点
Point[] ps9=getPointByP0(ps8[5],d,dx,dy);//根据起点得到另外6个点
draw(g,ps5[0],ps5[1],ps5[2],ps5[3],ps5[4],ps5[5],ps5[6]);
draw(g,ps4[0],ps4[1],ps4[2],ps4[3],ps4[4],ps4[5],ps4[6]);
draw(g,ps9[0],ps9[1],ps9[2],ps9[3],ps9[4],ps9[5],ps9[6]);
draw(g,ps8[0],ps8[1],ps8[2],ps8[3],ps8[4],ps8[5],ps8[6]);
draw(g,ps7[0],ps7[1],ps7[2],ps7[3],ps7[4],ps7[5],ps7[6]); 
draw(g,ps3[0],ps3[1],ps3[2],ps3[3],ps3[4],ps3[5],ps3[6]);
draw(g,ps2[0],ps2[1],ps2[2],ps2[3],ps2[4],ps2[5],ps2[6]);
draw(g,ps1[0],ps1[1],ps1[2],ps1[3],ps1[4],ps1[5],ps1[6]); 
}
/*****************************************************************/
//根据0号点，得到另外几个点的坐标
private Point[] getPointByP0(Point p0,int d,int dx,int dy){ 
Point p1=new Point(p0.x-d,p0.y);
Point p2=new Point(p0.x-d,p0.y+d);
Point p3=new Point(p0.x,p0.y+d);
Point p4=new Point(p3.x+dx,p3.y-dy);
Point p5=new Point(p0.x+dx,p0.y-dy);
Point p6=new Point(p0.x-(d-dx),p0.y-dy);

 Point[] ps=new Point[7];
 ps[0]=p0;
 ps[1]=p1;
 ps[2]=p2;
 ps[3]=p3;
 ps[4]=p4;
 ps[5]=p5;
 ps[6]=p6;
 return ps;
}
/*****************************************************************/
int count=0;//递归次数
//给定6个点，画出一个正方体
private void draw(Graphics gg,Point p0,Point p1,Point p2,
Point p3,Point p4,Point p5,Point p6){ 
if(count<20){
pn[count]=p0;
}
count++;
//int cc1=new java.util.Random().nextInt(255);
//int cc2=new java.util.Random().nextInt(255);
//int cc3=new java.util.Random().nextInt(255);
Graphics2D g=(Graphics2D)gg;
Polygon ponlygon3=new Polygon(); 
ponlygon3.addPoint(p0.x,p0.y);
ponlygon3.addPoint(p3.x,p3.y);
ponlygon3.addPoint(p4.x,p4.y);
ponlygon3.addPoint(p5.x,p5.y);
g.setColor(new Color(100,0,0));
g.fillPolygon(ponlygon3);
Polygon ponlygon1=new Polygon(); 
ponlygon1.addPoint(p0.x,p0.y);
ponlygon1.addPoint(p1.x,p1.y);
ponlygon1.addPoint(p2.x,p2.y);
ponlygon1.addPoint(p3.x,p3.y);
g.setColor(new Color(150,0,0));
g.fillPolygon(ponlygon1);
Polygon ponlygon2=new Polygon(); 
ponlygon2.addPoint(p0.x,p0.y);
ponlygon2.addPoint(p5.x,p5.y);

ponlygon2.addPoint(p6.x,p6.y);
ponlygon2.addPoint(p1.x,p1.y);
g.setColor(new Color(255,0,0));
g.fillPolygon(ponlygon2);
try {
	Thread.sleep(10);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/*****************************************************************/
public static void main(String[] args) {
DrawMGV5 d3=new DrawMGV5();
d3.initUI(); 
}
}