import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuAttaque extends JPanel {

	/* Les boutons constituant les attaques */
	private JButton boutonAttaque1 = new JButton();
	private JButton boutonAttaque2 = new JButton();
	private JButton boutonAttaque3 = new JButton();
	private JButton boutonAttaque4 = new JButton();
	
	/* le contener des boutons Menu des attaques (fights) */
	private JPanel contenerBtnAttaques = new JPanel(new GridLayout(2,2));
	
	public MenuAttaque() {
		
		/* ajout des boutons attaques sur le contener */
		contenerBtnAttaques.add(boutonAttaque1);
		contenerBtnAttaques.add(boutonAttaque2);
		contenerBtnAttaques.add(boutonAttaque3);
		contenerBtnAttaques.add(boutonAttaque4);
		
		boutonAttaque1.setText("Fatal-Foudre");
  	  	boutonAttaque2.setText("Rugissement");
  	  	boutonAttaque3.setText("Griffe");
  	  	boutonAttaque4.setText("Eclair");
  	  	
  	  	
		/* préférence des tailles des boutons Menu Fights */
		
		boutonAttaque1.setPreferredSize(new Dimension(114,41));
		boutonAttaque2.setPreferredSize(new Dimension(114,41));
		boutonAttaque3.setPreferredSize(new Dimension(114,41));
		boutonAttaque4.setPreferredSize(new Dimension(114,41));
		
		/* couleur des boutons Menu Fights */
		
		boutonAttaque1.setBackground(Color.WHITE);
		boutonAttaque2.setBackground(Color.WHITE);
		boutonAttaque3.setBackground(Color.WHITE);
		boutonAttaque4.setBackground(Color.WHITE);
		
		
  	  	add(contenerBtnAttaques);
  	  	
	}


	public JButton getBoutonAttaque1() {
		return boutonAttaque1;
	}


	public JButton getBoutonAttaque2() {
		return boutonAttaque2;
	}


	public JButton getBoutonAttaque3() {
		return boutonAttaque3;
	}



	public JButton getBoutonAttaque4() {
		return boutonAttaque4;
	}
	
	
	public void setNomAttaque1(String text) {
		boutonAttaque1.setText(text);
	}
	public void setNomAttaque2(String text) {
		boutonAttaque2.setText(text);
	}
	public void setNomAttaque3(String text) {
		boutonAttaque3.setText(text);
	}
	public void setNomAttaque4(String text) {
		boutonAttaque4.setText(text);
	}


	
	
}
