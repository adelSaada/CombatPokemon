import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Personnage extends JPanel {

	private int posX = 0;
	private int posY = 0;
	
	public Personnage() {
		this.setBackground(Color.white);		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image ashImg;
		try {
			ashImg = ImageIO.read(new File("images/ashHaut.png"));
			g.drawImage(ashImg,posX,posY, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JFrame maFenetre = new JFrame();
		Personnage pers = new Personnage();
		maFenetre.add(pers);
		maFenetre.setVisible(true);
		maFenetre.setBackground(Color.white);
		
		pers.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
			    int key = e.getKeyCode();

			    if (key == KeyEvent.VK_LEFT) {
			        pers.setPosX(pers.getPosX()+20);
			 
			    }

			    if (key == KeyEvent.VK_RIGHT) {
			        pers.setPosX(pers.getPosX()+20);
			    }

			    if (key == KeyEvent.VK_UP) {
			        pers.setPosX(pers.getPosX()+20);
			    }

			    if (key == KeyEvent.VK_DOWN) {
			        pers.setPosX(pers.getPosX()+20);
			    }
			}
		});
		
		while(true) {
			pers.repaint();
		}
		
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	
	
}
