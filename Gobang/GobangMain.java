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
		frame.setTitle("������byHWJ");
		frame.setLocation(300, 100);
		frame.setSize(750,600);
		frame.setResizable(false);
		BorderLayout bl = new BorderLayout();
		frame.setLayout(bl);
		//�����
//		this.setBackground(Color.lightGray);
		this.setBackground(new Color(110,200,200));
		this.setPreferredSize(new Dimension(600,600));
		this.addMouseListener(gl);
		frame.add(this,  BorderLayout.CENTER);
		//�����
		JPanel eastPanel=new JPanel();
		eastPanel.setPreferredSize(new Dimension(150,600));
		eastPanel.setBackground(frame.getBackground());
		frame.add(eastPanel,BorderLayout.EAST);
		
		String Array[]={"��ʼ��һ��","����","����","�˳�","��սģʽ��","�˻���ս","���˶�ս","����Ϊ�������£�"};
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
				button.setSelected(true);// ����ѡ��һ����ѡ��ť
			}
		}
		
		frame.setVisible(true);
		gr=this.getGraphics();//��û���
		gl.sendGraphics(gr);
//		for(int i=0;i<20;i++){
//			555+=d;535+=d;//�õ������������
//		}
		for(int i=0;i<Board.length;i++)
		{
			//��ʼ��������������
			for(int j=0;j<Board[i].length;j++)
			{
				Board[i][j]=0;//����Ϊ�գ�δ����
				Match[i][j]=new Point(xl+d*i,yl+d*j);//����Ļ���������������Ӧ����
			}
		}
		gl.sendMatch(Match);
		gl.sendBoard(Board);
		gl.sendGobangMain(this);
		gl.sendCurrent(Current);
	}
	/***************************************************************************/
	//��дJPanel��paint����
	int xl=55,yl=55;//�������Ͻ�
	int d=35;//���   
	static int Board[][]=new int[15][15];//��¼�������0δ���ӣ�1���ӣ�2����
	static Point Match[][]=new Point[15][15];//����Ļ���������������Ӧ����
	static int Current=1;//��ǰ��ң�Ĭ�Ϻ����У��������Ǻڣ�ż���ǰף�
	public void paint(Graphics g){
		super.paint(g);
		
		gr=(Graphics2D)g;
		((Graphics2D) gr).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i=0;i<Board.length;i++)
		{//������
			g.drawString(String.valueOf(i), xl+d*i-5 , yl-30 );
			g.drawLine(xl+d*i, yl, xl+d*i, yl+(Board.length-1)*d);//����
			
			g.drawString(String.valueOf(i), xl-35 , xl+d*i+5 );
			g.drawLine(xl, yl+d*i,xl+ (Board.length-1)*d, yl+d*i );//����
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
	 public void Put(Graphics2D g,int x,int y){//����(x,y)Ϊ���������
		 g.fillOval(x-15, y-15, 30, 30);
	 }
}
