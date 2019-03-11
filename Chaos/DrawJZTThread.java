package Chaos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

public class DrawJZTThread extends Thread{
	/*****************以下参数控制基本属性**************************************************/
	static int mode=1;//要画的图形（1是门格海绵，2是H型）
	static int t=0;//递归层数
	static int p=10;//最小方块大小放大p倍
	static int s=0;//控制速度
	static int j=0;//控制描边
    static int w=1200;//窗口大小
	static int h=760;
	 static Point p0=new Point(20,700); // 第一个坐标(最左下角)
	    //最小方块的规格
	   static int d0=10*p;
	    static int dx0=3*p;
	    static int dy0=4*p;
	  
	   
	
	//三个面的颜色
    Color color1=new Color(200,0,0);
    Color color2=new Color(130,0,0);
    Color color3=new Color(150,0,0);
    
    Manager3 m3;
//    public void sendJFrame(Manager3 mm3){
//    	System.out.println("已调用");
//    	m3=mm3;
//    }
    public static void SET(int d,int dx,int dy){
    	d0=d;dx0=dx;dy0=dy;
    }
    public static void setP0D(){
 		p0.y+=20;
 		if(p0.y>h-10){
 			p0.y=0;
 		}
 	}
    public static void setP0U(){
 		p0.y-=20;
 		if(p0.y<0){
 			p0.y=0;
 		}
 	}
    public static void setP0R(){
 		p0.x+=20;
 		if(p0.x>w-10){
 			p0.x=0;
 		}
 	}
    public static void setP0L(){
 		p0.x-=20;
 		if(p0.x<10){
 			p0.x=0;
 		}
 	}
   /****************************************/ 
    public static void setTR(){
 		t--;
 		if(t<-1){
 			t=-1;
 		}
 	}
    public static void setTI(){
 		 t++;
 	}
    /****************************************/ 
    public static void setSR(){
 		 s++;
 	}
    public static void setSI(){
 		 s--;
 		if( s<0){
 			 s=0;
 		}
 	}
    /****************************************/ 
    public static void setPR(){
 		 p--;
 		if( p<1){
 			 p=1;
 		}
 	}
    public static void setPI(){
 		 p++;
 	}
    /****************************************/ 
    public static void setMode(int m){
 		mode=m;
 	}
    /****************************************/ 
    public static void setD(){
    	j=1-j;
    }
    /****************************************/ 
 	public Graphics2D g;
 	public void setG(Graphics g){
 		this.g=(Graphics2D)g;
 	}
 	/****************************************/ 
	public void Clean(){
//		m3.repaint(0, 0, m3.getWidth(), m3.getHeight());
		System.out.println("Clear");
		Point p1=new Point(0,0);
		Point p2=new Point(0,h);
		Point p3=new Point(w,h);
		Point p4=new Point(w,0);
		Polygon pon1=new Polygon();
		pon1.addPoint(p1.x, p1.y);
		pon1.addPoint(p2.x, p2.y);
		pon1.addPoint(p3.x, p3.y);
		pon1.addPoint(p4.x, p4.y);
		g.setColor(new Color(225,225,225));
		g.fillPolygon(pon1);
	}
 	
	public void run(){
		System.out.println("run");
		Clean();
		int d1=d0 ;
		int dx1=dx0 ;
	    int dy1=dy0 ;
	    if(mode==1||mode==2){
	    	for(int i=0;i<t;i++){
	    		d1*=3;dx1*=3;dy1*=3;
	    	}
	    }
	    else if(mode==3){
	    	for(int i=0;i<t;i++){
		    	d1*=2;dx1*=2;dy1*=2;
		    }
	    }
		
		DrawDigui(g,p0,d1,dx1,dy1);
		
	}

	public void DrawDigui(Graphics2D pr,Point p,int d,int dx,int dy){
		System.out.println("DrawDigui");
		//根据mode调用不同形状函数
		if(mode==1||mode==2)
		{	
			Point points[]=new Point[20];
			if(t==-1){
					Draw(pr,p0,d0,dx0,dy0);
			}
			else{
				if(mode==1)		points=GetPointsMG(p,d,dx,dy);
				else if(mode==2)	points=GetPointsH(p,d,dx,dy);
				if(d==d0){
					for(int i=0;i<points.length;i++){
						Draw(pr,points[i],d0,dx0,dy0);
					}
				}
				else if(d>d0){
					for(int i=0;i<points.length;i++){
						DrawDigui(pr,points[i],d/3,dx/3,dy/3);
					}
				}
			}
		}
		else if(mode==3)
		{
			Point points[]=new Point[5];
			if(t==-1){
				DrawJZT(pr,p0,d0,dx0,dy0);
			}
			else{
				points=GetPointsJZT(p,d,dx,dy);
				if(d==d0){
					for(int i=0;i<points.length;i++){
						DrawJZT(pr,points[i],d0,dx0,dy0);
					}
				}
				else if(d>d0){
					for(int i=0;i<points.length;i++){
						DrawDigui(pr,points[i],d/2,dx/2,dy/2);
						}
				}
			}
		}
		
	}
	/*******根据一个点和边长等得到另外4个点,按画的顺序返回金字塔的5个点**********************/
	public static Point[] GetPointsJZT(Point p,int d,int dx,int dy){
		Point points[] =new Point[5];
		points[0]=new Point(p.x+dx,p.y-dy);
		points[1]=new Point(p.x+dx+d,p.y-dy);
		points[2]=p;
		points[3]=new Point(p.x+d,p.y);
		points[4]=new Point(p.x+d/2,p.y-d);
		
		return points;
	}
	
	/*******根据一个点和边长等得到另外10个点,按画的顺序返回字母H的11个点**********************/
	public static Point[] GetPointsH(Point p,int d,int dx,int dy){
		Point points[] =new Point[11];
		int px=(int)p.getX();int py=(int)p.getY();
		//第一层二个点
							 
			 
		points[0]=new Point(px+dx,py-dy);			 
		points[1]=new Point(px+dx+d*2,py-dy);	 
		
		//第二层七个点
															 
		points[2]=new Point(px+dx*2,py-dy*2-d);				 
		points[3]=new Point(px+dx*2+d*2,py-dy*2-d);		
		
		points[4]=new Point(px+dx,py-dy-d);	
		points[5]=new Point(px+dx+d,py-dy-d);	
		points[6]=new Point(px+dx+d*2,py-dy-d);	 
		
		points[7]=new Point(px,py-d);					 
		points[8]=new Point(px+d*2,py-d);
		//第三层二个点
		points[9]=new Point(px+dx,py-dy-d*2);				 
		points[10]=new Point(px+dx+d*2,py-dy-d*2);		 
		
		return points;
	}
	/*******根据一个点和边长等得到另外19个点,按画的顺序返回门格海绵的20个点**************************/
	
	public static Point[] GetPointsMG(Point p,int d,int dx,int dy){
		Point points[] =new Point[20];
		Point tmp=new Point();
		int px=(int)p.getX();int py=(int)p.getY();
		//第一层八个点
							 
		points[0]=new Point(px+dx*2,py-dy*2);		 
		points[1]=new Point(px+dx*2+d,py-dy*2);		 
		points[2]=new Point(px+dx*2+d*2,py-dy*2);		 
		points[3]=new Point(px+dx,py-dy);	 
		points[4]=new Point(px+dx+d*2,py-dy);	 
		points[5]=new Point(px,py);	  
		points[6]=new Point(px+d,py);	 	 
		points[7]=new Point(px+d*2,py);	
		//第二层四个点
						tmp.x=px+dx*2;		 
		points[8]=new Point(px+dx*2,py-dy*2-d);	 
		points[9]=new Point(px+dx*2+d*2,py-dy*2-d);	 
		points[10]=new Point(px,py-d);	 
		points[11]=new Point(px+d*2,py-d);
		//第三层八个点
							 
		points[12]=new Point(px+dx*2,py-dy*2-d*2);		 
		points[13]=new Point(px+dx*2+d,py-dy*2-d*2);		 
		points[14]=new Point(px+dx*2+d*2,py-dy*2-d*2);		 
		points[15]=new Point(px+dx,py-dy-d*2);		 
		points[16]=new Point(px+dx+d*2,py-dy-d*2);		 
		points[17]=new Point(px,py-d*2);		 
		points[18]=new Point(px+d,py-d*2);		 
		points[19]=new Point(px+d*2,py-d*2);
		
		return points;
	}
	
	/*************画出一个最小四面体**************************************************/
	public void DrawJZT(Graphics2D g,Point p,int d,int dx,int dy){
		try{
			Thread.sleep(100);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("DrawJZT");
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
		//填充第二个面
				Polygon pon2=new Polygon();
				pon2.addPoint(point1.x,point1.y);
				pon2.addPoint(point4.x,point4.y);
				pon2.addPoint(point3.x,point3.y);
				
				gr.setColor(color2);
				gr.fillPolygon(pon2);
		
	}
	/*************画出一个最小小方块**************************************************/
	public void Draw(Graphics2D g,Point p,int d,int dx,int dy){
		int x=p.x;
		int y=p.y;
//		System.out.println(count+" : ");
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
		
		if(j==1){
			gr.setColor(Color.black);
			gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			for(int i=0;i<9;i++){
					gr.drawLine(Array[i][0], Array[i][1], Array[i][2], Array[i][3]);
			}
		}
		
		try {
			Thread.sleep(s*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
