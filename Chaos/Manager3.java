package Chaos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Manager3 extends JFrame{
	/*****************���²������ƻ�������**************************************************/
	
	public static void main(String[] args) {
		Manager3 m3=new Manager3();
		m3.initUI();
	}
	/**
	 * 
	 */
	public void initUI(){
		setSize(1200, 760);
		setTitle("�Ÿ���byHWJ");
		setLocation(-10,0);
		setResizable(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(3);
		
		ButtonListener bl=new ButtonListener();
		String a[]={"�Ÿ���","������","��H��","��С","�Ŵ�","�����ٶ�-","�����ٶ�+","�ݹ����-","�ݹ����+","���(��/��)"};
		for(int i=0;i<a.length;i++){
			JButton button=new JButton(a[i]);	
			
			button.addActionListener(bl);
			add(button);
		}
		setVisible(true);	
//		DrawThread dt=new DrawThread();
//		dt.sendJFrame(this);
		
		bl.setG(getGraphics());
	}
	
}
