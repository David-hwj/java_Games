package Chaos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Manager3 extends JFrame{
	/*****************以下参数控制基本属性**************************************************/
	
	public static void main(String[] args) {
		Manager3 m3=new Manager3();
		m3.initUI();
	}
	/**
	 * 
	 */
	public void initUI(){
		setSize(1200, 760);
		setTitle("门格海绵byHWJ");
		setLocation(-10,0);
		setResizable(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(3);
		
		ButtonListener bl=new ButtonListener();
		String a[]={"门格海绵","金字塔","大H形","缩小","放大","绘制速度-","绘制速度+","递归次数-","递归次数+","描边(是/否)"};
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
