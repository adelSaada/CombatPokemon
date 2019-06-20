import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPokemon extends JPanel {

	
	JButton btnPokedex =new JButton("POKÈDEX");
	JButton btnPokemon = new JButton("POKÈMON");
	JButton btnItem =new JButton("ITEM");
	JButton btnAsh = new JButton("ASH");
	JButton btnSave =new JButton("SAVE");
	JButton btnOption = new JButton("OPTION");
	JButton btnExit =new JButton("EXIT");

	public MenuPokemon() {

		setBackground(Color.white);
		setLayout(new GridLayout(7,1));
		
		/* couleur des boutons en blancs */
		btnPokedex.setBackground(Color.white);
		btnPokemon.setBackground(Color.white);
		btnItem.setBackground(Color.white);
		btnAsh.setBackground(Color.white);
		btnSave.setBackground(Color.white);
		btnOption.setBackground(Color.white);
		btnExit.setBackground(Color.white);

		add(btnPokedex);
		add(btnPokemon);
		add(btnItem);
		add(btnAsh);
		add(btnSave);
		add(btnOption);
		add(btnExit);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(0,300));
	
	}
	
	
	// test
	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().add(new MenuPokemon());
		fenetre.pack();	
	}


	public JButton getBtnPokedex() {
		return btnPokedex;
	}


	public JButton getBtnPokemon() {
		return btnPokemon;
	}


	public JButton getBtnItem() {
		return btnItem;
	}


	public JButton getBtnAsh() {
		return btnAsh;
	}


	public JButton getBtnSave() {
		return btnSave;
	}


	public JButton getBtnOption() {
		return btnOption;
	}


	public JButton getBtnExit() {
		return btnExit;
	}
	
	

	
}


