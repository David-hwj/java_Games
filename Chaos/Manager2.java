package Chaos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Manager2 extends JFrame {
	private static final long serialVersionUID = 8544917802241337439L;
	/*****************���²������ƻ�������**************************************************/
	int mode=1;//Ҫ����ͼ�Σ�1���Ÿ��࣬2��H�ͣ�
	int t=0;//�ݹ����
	int p=2;//��С�����С�Ŵ�p��
	int s=0;//�����ٶ�
	int w=1200;//���ڴ�С
	int h=760;
	 Point p0=new Point(80,750); // ��һ������(�����½�)
	    //��С����Ĺ��
	    int d0=5*p;
	    int dx0=4*p;
	    int dy0=3*p;
	  //��󷽿�Ĺ��
	    int d1=d0 ;
	    int dx1=dx0 ;
	    int dy1=dy0 ;
	    
	    //���������ɫ
	    Color color1=new Color(200,0,0);
	    Color color2=new Color(130,0,0);
	    Color color3=new Color(150,0,0);
	
	/*************��дpaint �������л滭************************************************/
	public void paint(Graphics g){
//		super.paint(g);
		for(int i=0;i<t;i++){
	    	d1*=3;dx1*=3;dy1*=3;
	    }
		DrawDigui((Graphics2D)g,p0,d1,dx1,dy1);
	}
	
	/*************�ݹ黭ͼ************************************************/
	public void DrawDigui(Graphics2D pr,Point p,int d,int dx,int dy){
		Point points[]=new Point[20];
		//����mode���ò�ͬ��״����
		if(mode==1)points=GetPointsMG(p,d,dx,dy);
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
	/*******����һ����ͱ߳��ȵõ�����10����,������˳�򷵻���ĸH��11����**********************/
	public static Point[] GetPointsH(Point p,int d,int dx,int dy){
		Point points[] =new Point[11];
		Point tmp=new Point();
		int px=(int)p.getX();int py=(int)p.getY();
		//��һ�������
							 
			 
		points[0]=new Point(px+dx,py-dy);			 
		points[1]=new Point(px+dx+d*2,py-dy);	 
		
		//�ڶ����߸���
															 
		points[2]=new Point(px+dx*2,py-dy*2-d);				 
		points[3]=new Point(px+dx*2+d*2,py-dy*2-d);		
		
		points[4]=new Point(px+dx,py-dy-d);	
		points[5]=new Point(px+dx+d,py-dy-d);	
		points[6]=new Point(px+dx+d*2,py-dy-d);	 
		
		points[7]=new Point(px,py-d);					 
		points[8]=new Point(px+d*2,py-d);
		//�����������
		points[9]=new Point(px+dx,py-dy-d*2);				 
		points[10]=new Point(px+dx+d*2,py-dy-d*2);		 
		
		return points;
	}
	/*******����һ����ͱ߳��ȵõ�����19����,������˳�򷵻��Ÿ����20����**************************/
	
	public static Point[] GetPointsMG(Point p,int d,int dx,int dy){
		Point points[] =new Point[20];
		Point tmp=new Point();
		int px=(int)p.getX();int py=(int)p.getY();
		//��һ��˸���
							tmp.x=px+dx*2;		tmp.y=py-dy*2;	
		points[0]=new Point(px+dx*2,py-dy*2);		tmp.x=px+dx*2+d;		tmp.y=py-dy*2;
		points[1]=new Point(px+dx*2+d,py-dy*2);		tmp.x=px+dx*2+d*2;		tmp.y=py-dy*2;
		points[2]=new Point(px+dx*2+d*2,py-dy*2);		tmp.x=px+dx;		tmp.y=py-dy;
		points[3]=new Point(px+dx,py-dy);	tmp.x=px+dx+d*2;		tmp.y=py-dy;
		points[4]=new Point(px+dx+d*2,py-dy);	tmp.x=px;		tmp.y=py;
		points[5]=new Point(px,py);	tmp.x=px+d;		tmp.y=py;
		points[6]=new Point(px+d,py);	tmp.x=px+d*2;		tmp.y=py;
		points[7]=new Point(px+d*2,py);	
		//�ڶ����ĸ���
						tmp.x=px+dx*2;		tmp.y=py-dy*2-d;
		points[8]=new Point(px+dx*2,py-dy*2-d);	tmp.x=px+dx*2+d*2;		tmp.y=py-dy*2-d;
		points[9]=new Point(px+dx*2+d*2,py-dy*2-d);	tmp.x=px;		tmp.y=py-d;
		points[10]=new Point(px,py-d);	tmp.x=px+d*2;		tmp.y=py-d;
		points[11]=new Point(px+d*2,py-d);
		//������˸���
							tmp.x=px+dx*2;		tmp.y=py-dy*2-d*2;	
		points[12]=new Point(px+dx*2,py-dy*2-d*2);		tmp.x=px+dx*2+d;		tmp.y=py-dy*2-d*2;
		points[13]=new Point(px+dx*2+d,py-dy*2-d*2);		tmp.x=px+dx*2+d*2;		tmp.y=py-dy*2-d*2;
		points[14]=new Point(px+dx*2+d*2,py-dy*2-d*2);		tmp.x=px+dx;		tmp.y=py-dy-d*2;
		points[15]=new Point(px+dx,py-dy-d*2);		tmp.x=px+dx+d*2;		tmp.y=py-dy-d*2;
		points[16]=new Point(px+dx+d*2,py-dy-d*2);		tmp.x=px;		tmp.y=py-d*2;
		points[17]=new Point(px,py-d*2);		tmp.x=px+d;		tmp.y=py-d*2;
		points[18]=new Point(px+d,py-d*2);		tmp.x=px+d*2;		tmp.y=py-d*2;
		points[19]=new Point(px+d*2,py-d*2);
		
		return points;
	}
	
	/*************����һ����СС����**************************************************/
	public void Draw(Graphics2D g,Point p,int d,int dx,int dy){
		int x=(int)p.getX();
		int y=(int)p.getY();
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
		gr.setColor(Color.black);
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i=0;i<9;i++){
				gr.drawLine(Array[i][0], Array[i][1], Array[i][2], Array[i][3]);
		}
		//����һ����
		Polygon pon1=new Polygon();
		pon1.addPoint(Array[0][0], Array[0][1]);
		pon1.addPoint(Array[0][2], Array[0][3]);
		pon1.addPoint(Array[2][0], Array[2][1]);
		pon1.addPoint(Array[2][2], Array[2][3]);
		gr.setColor(color1);
		gr.fillPolygon(pon1);
		//���ڶ�����
		Polygon pon2=new Polygon();
		pon2.addPoint(Array[3][0], Array[3][1]);				
		pon2.addPoint(Array[3][2], Array[3][3]);
		pon2.addPoint(Array[8][0], Array[8][1]);
		pon2.addPoint(Array[8][2], Array[8][3]);
		gr.setColor(color2);
		gr.fillPolygon(pon2);
		//����������
		Polygon pon3=new Polygon();
		pon3.addPoint(Array[2][0], Array[2][1]);
		pon3.addPoint(Array[2][2], Array[2][3]);
		pon3.addPoint(Array[7][0], Array[7][1]);
		pon3.addPoint(Array[7][2], Array[7][3]);
		gr.setColor(color3);
		gr.fillPolygon(pon3);	
		try {
			Thread.sleep(s*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Manager2 m=new Manager2();
		m.initUI();
	}
	public void initUI(){
		setSize(w, h);
		setTitle("�Ÿ���byHWJ");
		setLocation(-10,0);
		setResizable(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(3);
//		ButtonThread bt=new ButtonThread(this);
//		bt.start();
		String a[]={"�Ÿ���","��H��","��С","�Ŵ�","�����ٶ�-","�����ٶ�+","�ݹ����-","�ݹ����+"};
		for(int i=0;i<a.length;i++){
			JButton button=new JButton(a[i]);
			ButtonListener bl=new ButtonListener();
			button.addActionListener(bl);
			add(button);
		}
		setVisible(true);
	}
}
