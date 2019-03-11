package planeFight;

import java.util.ArrayList;

public class CreateEnemyplaneThread extends Thread{

	 ArrayList<Enemyplane> enemyplane;
	
	public CreateEnemyplaneThread(ArrayList<Enemyplane> enemyplane){
		this.enemyplane=enemyplane;
		
	}
	
	public void run(){
		while(true){
			int r=(int)(Math.random()*600);
		Enemyplane plane=new Enemyplane(r,0);
		enemyplane.add(plane);
		
		//√ø100∫¡√Î
		try{
			Thread.sleep(400);
		}catch(Exception e){}
		}
	}
	
	
}
