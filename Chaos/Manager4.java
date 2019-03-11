package Chaos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager4 extends JPanel{

	public static void main(String[] args) {
		Manager4 m4=new Manager4();
		m4.initUI();
	}
	ButtonListener bl=new ButtonListener();
	Graphics gr;
	public void initUI()
	{
		JFrame frame=new JFrame();
		frame.setTitle("����byHWJ");
		frame.setLocation(200, 10);
		frame.setSize(1000,750);
		frame.setResizable(false);
		 BorderLayout bol = new BorderLayout();
		 frame.setLayout(bol);
		//�����
		this.setBackground(frame.getBackground());
		this.setPreferredSize(new Dimension(750,750));
		frame.add(this,  BorderLayout.CENTER);
		//�����
		JPanel eastPanel=new JPanel();
		eastPanel.setPreferredSize(new Dimension(250,750));
		eastPanel.setBackground(Color.lightGray);
		frame.add(eastPanel,BorderLayout.EAST);
		
		String a[]={"�Ÿ���","������ ","��H��","��С","�Ŵ�","����","����","����","����","�����ٶ�-","�����ٶ�+","�ݹ����-","�ݹ����+","���(��/��)"};
		for(int i=0;i<a.length;i++){
			JButton button=new JButton(a[i]);
			if(i<3||i==a.length-1)
				button.setPreferredSize(new Dimension(205, 60));
			else
				button.setPreferredSize(new Dimension(100, 60));
			button.addActionListener(bl);
			eastPanel.add(button);
		}
		
		frame.setVisible(true);
		gr=this.getGraphics();//��û���
		bl.setG(gr);
	}
}
