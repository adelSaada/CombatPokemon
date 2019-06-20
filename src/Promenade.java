import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Promenade extends JPanel {
	
	ImageIcon icoFond;
	Image imgFond;
	
	ImageIcon icoPerso;
	Image imgPerso;
	
	private int xFond1;

	
	public Promenade() {
		icoFond = new ImageIcon("images/safari.png");
		this.imgFond = this.icoFond.getImage();
		
		icoPerso = new ImageIcon("images/ashDroite.png");
		this.imgPerso = this.icoPerso.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
	}
	
	/* GETTERS */
	public int getxFond1() {return xFond1;}

	/* SETTERS*/
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		// image de fond
		g2.drawImage(this.imgFond, -50, this.getxFond1(), null); // fond 1
		g2.drawImage(this.imgPerso, 30, 30, null); // perso

		
	}
	
	
	public static void main(String[] args) {
		// création de la fenetre de l'application
		JFrame fenetre = new JFrame("Jeu style Mario");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(300, 300);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		// instanciation de l'objet scene
		Promenade promenade = new Promenade();
		
		fenetre.setContentPane(promenade);
		fenetre.setVisible(true);
	}

}
