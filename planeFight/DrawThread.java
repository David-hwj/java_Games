package planeFight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class DrawThread extends Thread {
	Myplane myplane;
	ArrayList<Enemyplane> enemyplane;
	ArrayList<MyBullet> mybullet;
	Graphics g;

	public DrawThread(Graphics g, Myplane myplane, ArrayList<Enemyplane> enemyplane, ArrayList<MyBullet> mybullet) {
		this.g = g;
		this.myplane = myplane;
		this.enemyplane = enemyplane;
		this.mybullet = mybullet;
	}

	public void run() {

		while (true) {

			clear();

			// System.out.println("���ػ����");
			BufferedImage bi = new BufferedImage(600, 700, BufferedImage.TYPE_INT_RGB);
			Graphics gr = bi.getGraphics();
			
			Image img=new ImageIcon(this.getClass().getResource("background3.jpg")).getImage();
			gr.drawImage(img, 0, 0, 600, 700, null);
//			gr.setColor(Color.WHITE);
//			gr.fillRect(0, 0, 600, 700);
			if (myplane.isbroken == false)
				myplane.draw(gr);
			else
				myplane.bang(gr);// ׹����
			for (int i = 0; i < enemyplane.size(); i++) {
				// û�б����еĵл��Ż�
				if (enemyplane.get(i).isbroken == true)
					enemyplane.get(i).bang(gr);
				else
					try {
						enemyplane.get(i).draw(gr);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				enemyplane.get(i).move();
			}
			for (int i = 0; i < mybullet.size(); i++) {
				// û�л��е��ӵ��Ż�
				if (mybullet.get(i).isbroken == false)
					mybullet.get(i).draw(gr);
				mybullet.get(i).move();
			}

			g.drawImage(bi, 0, 0, null);

			// ÿ50���뻭һ��
			try {
				Thread.sleep(50);
			} catch (Exception e) {}
			
		}

	}

	/**
	 * �������ķɻ��ͷɳ�ȥ�˵�
	 */
	public void clear() {
		// ����ӵ��ͷɻ�
		int i = 0;
		while (i < enemyplane.size()) {
			for (i = 0; i < enemyplane.size(); i++) {
				if (enemyplane.get(i).isbroken == true) {
					enemyplane.remove(i);
					break;
				}
			}
		}
		i = 0;
		while (i < mybullet.size()) {
			for (i = 0; i < mybullet.size(); i++) {
				if (mybullet.get(i).isbroken == true) {

					mybullet.remove(i);
					break;
				}
			}
		}
		// ��ǳ���ķɻ����ӵ�

		for (i = 0; i < enemyplane.size(); i++) {
			if (enemyplane.get(i).y > 750) {
				enemyplane.get(i).isbroken = true;
				// enemyplane.remove(i);
				break;
			}
		}

		i = 0;

		for (i = 0; i < mybullet.size(); i++) {
			if (mybullet.get(i).y < 0) {
				mybullet.get(i).isbroken = true;
				// mybullet.remove(i);
				break;
			}
		}

		// �����ײ�ķɻ�

		for (i = 0; i < enemyplane.size(); i++) {
			int xe = enemyplane.get(i).x;
			int ye = enemyplane.get(i).y;
			for (int j = 0; j < mybullet.size(); j++) {
				int xb = mybullet.get(j).x;// ��ʱ�ᱨ��ָ��
				int yb = mybullet.get(j).y;
				if (Math.abs(xe - xb) < 50 && Math.abs(ye - yb) < 50) {
					enemyplane.get(i).isbroken = true;
					mybullet.get(j).isbroken = true;
				}
			}
			int xm = myplane.x;
			int ym = myplane.y;
			if (Math.abs(xe - xm) < 80 && Math.abs(ye - ym) < 40) {
				myplane.isbroken = true;
			}
		}

	}

}
