package planeFight;

import java.util.ArrayList;

public class CreateBulletThread extends Thread{
	static int x;
	static int y;
	  ArrayList<MyBullet> mybullet;
	Myplane myplane;
	public CreateBulletThread(Myplane myplane,ArrayList<MyBullet> mybullet){
		this.mybullet=mybullet;
		this.myplane=myplane;
	}
	public void run(){
		while(true){
			x=myplane.getX();
			y=myplane.getY();
			
			MyBullet bullet=new MyBullet(x,y);
			mybullet.add(bullet);
			
			//√ø100∫¡√Î
			try{
				Thread.sleep(200);
			}catch(Exception e){}
			}
		
		
	}
	
	
}
