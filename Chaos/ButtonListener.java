package Chaos;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	String str ="�Ÿ���";
	Graphics g;
	
	public void setG(Graphics g){
		this.g=g;
	}
	
	   public void actionPerformed(ActionEvent e){
		   str=e.getActionCommand();
		   if(str.equals("�Ÿ���")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(1);
			   dt.start();
//			   System.out.println("�߳̿�ʼ");
		   }
		   else if(str.equals("������ ")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(3);
			   dt.start();
		   }
		   else if(str.equals("��H��")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setMode(2);
			   dt.start();
		   }
		  
		   else if(str.equals("��С")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setPR();
			   dt.start();
		   }
		   else if(str.equals("�Ŵ�")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setPI();
			   dt.start();
		   }
		   else if(str.equals("����")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0L();
			   dt.start();
		   }
		   else if(str.equals("����")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0R();
			   dt.start();
		   }
		   else if(str.equals("����")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0U();
			   dt.start();
		   }
		   else if(str.equals("����")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setP0D();
			   dt.start();
		   }
		   else if(str.equals("�����ٶ�-")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setSR();
			   dt.start();
		   }
		   else if(str.equals("�����ٶ�+")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setSI();
			   dt.start();
		   }
		   else if(str.equals("�ݹ����-")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setTR();
			   dt.start();
		   }
		   else if(str.equals("�ݹ����+")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setTI();
			   dt.start();
		   }
		   else if(str.equals("���(��/��)")){
			   DrawThread dt=new DrawThread();
			   dt.setG(g);
			   dt.setD();
			   dt.start();
		   }
		   
	   }
	
}
