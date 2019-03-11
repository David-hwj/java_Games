package planeFight;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Manager extends JFrame {

	Graphics g;
	ArrayList<Enemyplane> enemyplane = new ArrayList();
	ArrayList<MyBullet> mybullet = new ArrayList();
	Myplane myplane = new Myplane(300, 650);

	@SuppressWarnings("deprecation")
	public void init() throws MalformedURLException {

		
		this.setSize(600, 700);
		this.setLocation(350, 30);
		this.setTitle("�ɻ���սbyHWJ");
		this.setResizable(false);
		// this.getContentPane().setBackground(Color.WHITE);

		// ������������������
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

//				System.out.println("Manager   x:" + x + "     y:" + y);
				myplane.moveto(x, y);
			}

		});

		this.setVisible(true);
		g = this.getGraphics();
		//�ӱ���ͼƬ
		Image img=new ImageIcon(this.getClass().getResource("background3.jpg")).getImage();
		g.drawImage(img, 0, 0, 600, 700, null);
//���ֲ���
		
		File file1 = new File("src\\music.wav.wav");
		AudioClip sound1= Applet.newAudioClip(file1.toURL());		
		sound1.play();
		
	
		
		
		
		CreateBulletThread cb = new CreateBulletThread(myplane, mybullet);
		cb.start();
		CreateEnemyplaneThread ce = new CreateEnemyplaneThread(enemyplane);
		ce.start();
		DrawThread dt = new DrawThread(g, myplane, enemyplane, mybullet);
		dt.start();

	}

	public static void main(String[] args) throws MalformedURLException {
		Manager manager = new Manager();
		manager.init();
	}

}
