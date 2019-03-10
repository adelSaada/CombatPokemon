import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class menuPrincipal extends JPanel {

	
	/* Le contener des boutons du Menu Général */
	private JPanel contenerBtnMenu = new JPanel(new GridLayout(2,2));

	
	/* Les boutons constituant le menu */
	
	private JButton boutonFightMenu = new JButton(new ImageIcon("fightMenu.gif"));
	private JButton boutonBagMenu = new JButton(new ImageIcon("bagMenu.gif"));
	private JButton boutonPkmMenu = new JButton(new ImageIcon("pokemonMenu.gif"));
	private JButton boutonRunMenu = new JButton(new ImageIcon("runMenu.png"));
	
	
	public menuPrincipal() {
		
		/* préférence des tailles des boutons Menu */
		boutonFightMenu.setPreferredSize(new Dimension(115,42));
		boutonBagMenu.setPreferredSize(new Dimension(115,42));
		boutonPkmMenu.setPreferredSize(new Dimension(115,42));
		boutonRunMenu.setPreferredSize(new Dimension(115,42));
		
		/* ajout des boutons sur le contener Menu */
		contenerBtnMenu.add(boutonFightMenu);
		contenerBtnMenu.add(boutonBagMenu);
		contenerBtnMenu.add(boutonPkmMenu);
		contenerBtnMenu.add(boutonRunMenu);
		
		add(contenerBtnMenu);
	}

	public JButton getBoutonFightMenu() {
		return boutonFightMenu;
	}

	public JButton getBoutonBagMenu() {
		return boutonBagMenu;
	}

	public JButton getBoutonPkmMenu() {
		return boutonPkmMenu;
	}

	public JButton getBoutonRunMenu() {
		return boutonRunMenu;
	}
	
	
}
