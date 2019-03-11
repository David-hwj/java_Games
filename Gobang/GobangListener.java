package Gobang;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GobangListener extends MouseAdapter implements ActionListener{
	int mode=2;//2Ϊ���˶�ս1Ϊ�˻���ս
	int x0=0,y0=0,xp,yp;
	Color color1=Color.black;
	Color color2=Color.WHITE;
	static int Current=1;//��ǰ��ң�Ĭ�Ϻ����У��������Ǻڣ�ż���ǰף�
	public void sendCurrent(int C){
		Current=C;
	}
	Graphics2D g;

	
	public void sendGraphics(Graphics g){
		this.g=(Graphics2D)g;
		this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	/*******************����ǰ�ť****************************************************/
	public void actionPerformed(ActionEvent e)
	{ 
		 if(e.getActionCommand().equals("��ʼ��һ��")){
			 Restart();
		 }
		 else if(e.getActionCommand().equals("����")){
			 int n=1;
			 if(mode==1)n++;
			 for(int k=0;k<n;k++)
			 {
				 if(Current>1){
					 Current--;
					 for(int i=0;i<Board.length;i++)
					 {
						 for(int j=0;j<Board[i].length;j++)
						 {
							 if(Board[i][j]==Current){
								 xp=i;yp=j;
							 }
						 }
					 }
				 Board[xp][yp]=0;
				 gm.paint(g); 
				 } 
			 }
			 
		 }
		 else if(e.getActionCommand().equals("����")){
			 JFrame jf=new JFrame();
			 if(Current%2==1){
				 JOptionPane.showMessageDialog(jf, "��������");
				 Restart();
			 }
			 else {
				 JOptionPane.showMessageDialog(jf, "��������");
				 Restart();
			 }
		 }
		 else if(e.getActionCommand().equals("�˳�")){
			 System.exit(0);
		 }
		 else if(e.getActionCommand().equals("���˶�ս")){
//			 System.out.println("���˶�ս");
			 mode=2;
		 }
		 else if(e.getActionCommand().equals("�˻���ս")){
//			 System.out.println("�˻���ս");
			 mode=1;
		 }
	}
	/*****************���������*******************************************************/
	 public void mouseClicked(MouseEvent e) 
	 {
		 Correct(e.getX(),e.getY());//��������
		 if(x0!=0&&y0!=0&&Board[xp][yp]==0){//��������
			 if(Current%2==1){//�º���
				 g.setColor(color1);
				  Put(g,x0,y0);
//				 Board[xp][yp]=Current;
				 g.setColor(color2);
			 }
			 else{//�°���
				 g.setColor(color2);	
				 Put(g,x0,y0);
//				 Board[xp][yp]=Current;
				 g.setColor(color1);
			 }
			 if(Judger()==1){//��ǰ���ʤ
				 JFrame jf=new JFrame();
				 if(Current%2==1){
					 JOptionPane.showMessageDialog(jf, "����ʤ");
					 Restart();
				 }
				 else {
					 JOptionPane.showMessageDialog(jf, "����ʤ");
					 Restart();
				 }
			 }
			 else{
				 Current++;//�����
				 if(mode==1){//������˻�ģʽ�������һ��
					 RobotQZ r=new RobotQZ();
					 Point p=r.Think(Board,Current);
					 xp=p.x;yp=p.y;
					 Put(g,Match[p.x][p.y].x,Match[p.x][p.y].y);
//					 Board[p.x][p.y]=Current;
					 if(Judger()==1){//��ǰ���ʤ
						 JFrame jf=new JFrame();
						 if(Current%2==1){
							 JOptionPane.showMessageDialog(jf, "����ʤ");
							 Restart();
						 }
						 else {
							 JOptionPane.showMessageDialog(jf, "����ʤ");
							 Restart();
						 }
					 }
					 else{
						 Current++;//��������ûӮ
					 } 
				 }
			 } 
			 
		 }
		 x0=0;y0=0;//�����0
	 }
	 /********�ؿ�һ��*****************************************************/
	 GobangMain gm;
	 public void sendGobangMain(GobangMain gmm){
		 gm=gmm;
	 }
	 public void Restart()
	 {
		 for(int i=0;i<Board.length;i++){
				for(int j=0;j<Board[i].length;j++){
					Board[i][j]=0;//����Ϊ�գ�δ����
				}
		 }
		 Current=1;
		 gm.paint(g);
	 }
	 /********�ж���Ӯ����Ӯ��*****************************************************/
	 public int Judger()
	 {
			int count = 1;
			//��ֱ
			for (int i = 1; i < 5; i++)
			{
				if(xp-i>=0&&Board[xp-i][yp]%2==Current%2&&Board[xp-i][yp]!=0)count++;
				else break;
			}
			for (int i = 1; i < 5; i++)
			{
				if(xp+i<=20&&Board[xp+i][yp]%2==Current%2&&Board[xp+i][yp]!=0)count++;
				else break;
			}
			if (count == 5) return 1;
			//ˮƽ
			count = 1;
			for (int i = 1; i < 5; i++)
			{
				if(yp-i>=0&&Board[xp][yp-i]%2==Current%2&&Board[xp][yp-i]!=0)count++;
				else break;
			}
			for (int i = 1; i < 5; i++)
			{
				if(yp+i<=20&&Board[xp][yp+i]%2==Current%2&&Board[xp][yp+i]!=0)count++;
				else break;
			}
			if (count == 5) return 1;
			//���ϵ�����
			count = 1;
			for (int i = 1; i < 5; i++)//����
			{
				if(xp-i>=0&&yp-i>=0&&Board[xp-i][yp-i]%2==Current%2&&Board[xp-i][yp-i]!=0)count++;
				else break;
			}
			for (int i = 1; i < 5; i++)//����
			{
				if(xp+i<=20&&yp+i<=20&&Board[xp+i][yp+i]%2==Current%2&&Board[xp+i][yp+i]!=0)count++;
				else break;
			}
			if (count == 5) return 1;
			//���ϵ�����
			count = 1;
			for (int i = 1; i < 5; i++)//����
			{
				if(xp-i>=0&&yp+i<=20&&Board[xp-i][yp+i]%2==Current%2&&Board[xp-i][yp+i]!=0)count++;
				else break;
			}
			for (int i = 1; i < 5; i++)//����
			{
				if(xp+i<=20&&yp-i>=0&&Board[xp+i][yp-i]%2==Current%2&&Board[xp+i][yp-i]!=0)count++;
				else break;
			}
			if (count == 5)  return 1;
			
	 return 0;
	 }
	 
	 
	 /********����*****************************************************/
	 public void Put(Graphics2D g,int x,int y){//����(x,y)Ϊ���������
		 g.fillOval(x-15, y-15, 30, 30);
		 Board[xp][yp]=Current;
	 }
	 
	 /********��������*****************************************************/
	 int Board[][]=new int[15][15];//��¼�������0δ���ӣ�1���ӣ�2����
	 Point Match[][]=new Point[15][15];//����Ļ���������������Ӧ����
	 public void sendMatch(Point[][] M){
		 Match=M;
	 }
	 public void sendBoard(int[][] B){
		 Board=B;
	 }
	 private void Correct(int x,int y)//����Χ10�����ص��� �������Ե���������Ϊ�����̶�Ӧ
	                                  //��Ļ���귵�ص�x0,y0,���̷��ص�xp,yp
	 {
		 int  p=10;//��������
		 int xx=x,yy=y;
		 for(int i=0;i<p;i++)//����������x
		 {
			 xx=x-i;
			 for(int j=0;j<Board.length;j++)
			 {
				 if(Match[j][0].x==xx){
					 x0=xx;xp=j;break;
				 }
			 }
		 }
		 for(int i=1;i<p;i++)//��������x
		 {
			 xx=x+i;
			 for(int j=0;j<Board.length;j++)
			 {
				 if(Match[j][0].x==xx){
					 x0=xx;xp=j;break;
				 }
			 }
		 }
		 for(int i=0;i<p;i++)//����������y
		 {
			 yy=y-i;
			 for(int j=0;j<Board.length;j++)
			 {
				 if(Match[0][j].y==yy){
					 y0=yy;yp=j;break;
				 }
			 }
		 } 
		 for(int i=1;i<p;i++)//����������y
		 {
			 yy=y+i;
			 for(int j=0;j<Board.length;j++)
			 {
				 if(Match[0][j].y==yy){
					 y0=yy;yp=j;break;
				 }
			 }
		 } 
	 }	 
}