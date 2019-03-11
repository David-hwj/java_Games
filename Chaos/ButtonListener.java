package Chaos;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	String str ="门格海绵";
	Graphics g;
	
	public void setG(Graphics g){
		this.g=g;
	}
	
	   public void actionPerformed(ActionEvent e){
		   str=e.getActionCommand();
		   if(str.equals("门格海绵")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(1);
			   dt.start();
//			   System.out.println("线程开始");
		   }
		   else if(str.equals("金字塔 ")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(3);
			   dt.start();
		   }
		   else if(str.equals("大H形")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(2);
			   dt.start();
		   }
		  
		   else if(str.equals("缩小")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setPR();
			   dt.start();
		   }
		   else if(str.equals("放大")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setPI();
			   dt.start();
		   }
		   else if(str.equals("左移")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0L();
			   dt.start();
		   }
		   else if(str.equals("右移")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0R();
			   dt.start();
		   }
		   else if(str.equals("上移")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0U();
			   dt.start();
		   }
		   else if(str.equals("下移")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0D();
			   dt.start();
		   }
		   else if(str.equals("绘制速度-")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setSR();
			   dt.start();
		   }
		   else if(str.equals("绘制速度+")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setSI();
			   dt.start();
		   }
		   else if(str.equals("递归次数-")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setTR();
			   dt.start();
		   }
		   else if(str.equals("递归次数+")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setTI();
			   dt.start();
		   }
		   else if(str.equals("描边(是/否)")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setD();
			   dt.start();
		   }
		   
	   }
	
}
