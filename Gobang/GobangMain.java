package Gobang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GobangMain extends JPanel{

	public Graphics gr;
	GobangListener gl=new GobangListener();
	public static void main(String[] args) 
	{
		GobangMain gm=new GobangMain();	
		gm.initUI();
	}
	/*****************************************************************/
	public void initUI()
	{
		
		
		
		JFrame frame=new JFrame();
		frame.setTitle("五子棋byHWJ");
		frame.setLocation(300, 100);
		frame.setSize(750,600);
		frame.setResizable(false);
		BorderLayout bl = new BorderLayout();
		frame.setLayout(bl);
		//左面板
//		this.setBackground(Color.lightGray);
		this.setBackground(new Color(110,200,200));
		this.setPreferredSize(new Dimension(600,600));
		this.addMouseListener(gl);
		frame.add(this,  BorderLayout.CENTER);
		//右面板
		JPanel eastPanel=new JPanel();
		eastPanel.setPreferredSize(new Dimension(150,600));
		eastPanel.setBackground(frame.getBackground());
		frame.add(eastPanel,BorderLayout.EAST);
		
		String Array[]={"开始新一局","悔棋","认输","退出","对战模式：","人机对战","人人对战","（均为黑子先下）"};
		ButtonGroup bg=new ButtonGroup();
		
		for(int i=0;i<Array.length;i++)
		{
			if(i<4){
				JButton button=new JButton(Array[i]);
				button.setPreferredSize(new Dimension(140,60));
				button.addActionListener(gl);;
				eastPanel.add(button);
			}
			else if(i==4){
				JLabel label =new JLabel(Array[i]);
				label.setPreferredSize(new Dimension(140,60));
				eastPanel.add(label);
			}
			else if(i==7){
				JLabel label =new JLabel(Array[i]);
				label.setPreferredSize(new Dimension(140,60));
				eastPanel.add(label);
			}
			else{
				JRadioButton button = new JRadioButton(Array[i]);
				button.setPreferredSize(new Dimension(100, 60));
				button.setOpaque(true);
				button.addActionListener(gl);
				eastPanel.add(button);
				
				bg.add(button);
				button.setSelected(true);// 设置选中一个单选按钮
			}
		}
		
		frame.setVisible(true);
		gr=this.getGraphics();//获得画笔
		gl.sendGraphics(gr);
//		for(int i=0;i<20;i++){
//			555+=d;535+=d;//得到棋盘最大坐标
//		}
		for(int i=0;i<Board.length;i++)
		{
			//初始化两个棋盘数组
			for(int j=0;j<Board[i].length;j++)
			{
				Board[i][j]=0;//棋盘为空，未下子
				Match[i][j]=new Point(xl+d*i,yl+d*j);//将屏幕坐标与棋盘坐标对应起来
			}
		}
		gl.sendMatch(Match);
		gl.sendBoard(Board);
		gl.sendGobangMain(this);
		gl.sendCurrent(Current);
	}
	/***************************************************************************/
	//重写JPanel的paint方法
	int xl=55,yl=55;//棋盘左上角
	int d=35;//间隔   
	static int Board[][]=new int[15][15];//记录下子情况0未下子，1黑子，2白子
	static Point Match[][]=new Point[15][15];//将屏幕坐标与棋盘坐标对应起来
	static int Current=1;//当前玩家（默认黑先行）（奇数是黑，偶数是白）
	public void paint(Graphics g){
		super.paint(g);
		
		gr=(Graphics2D)g;
		((Graphics2D) gr).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i=0;i<Board.length;i++)
		{//画棋盘
			g.drawString(String.valueOf(i), xl+d*i-5 , yl-30 );
			g.drawLine(xl+d*i, yl, xl+d*i, yl+(Board.length-1)*d);//竖线
			
			g.drawString(String.valueOf(i), xl-35 , xl+d*i+5 );
			g.drawLine(xl, yl+d*i,xl+ (Board.length-1)*d, yl+d*i );//横线
		}
		gr.setColor(Color.black);
		gr.fillOval(Match[3][3].x-4,Match[3][3].y-4, 8, 8);
		gr.fillOval(Match[3][11].x-4,Match[3][11].y-4, 8, 8);
		gr.fillOval(Match[11][3].x-4,Match[11][3].y-4, 8, 8);
		gr.fillOval(Match[11][11].x-4,Match[11][11].y-4, 8, 8);
		for(int i=0;i<Board.length;i++){
			for(int j=0;j<Board[i].length;j++){
				if(Board[i][j]%2==1){
					gr.setColor(Color.black);
					Put((Graphics2D)gr,Match[i][j].x, Match[i][j].y);
				}else if(Board[i][j]%2==0&&Board[i][j]!=0){
					gr.setColor(Color.WHITE);
					Put((Graphics2D)gr,Match[i][j].x, Match[i][j].y);
				}
			}	
		}
		
	}
	 public void Put(Graphics2D g,int x,int y){//下子(x,y)为点击的坐标
		 g.fillOval(x-15, y-15, 30, 30);
	 }
}
