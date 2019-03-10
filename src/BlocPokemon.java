import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlocPokemon extends JPanel {

	private JPanel bloc = new JPanel(); 

	private JLabel imagePk = new JLabel(new ImageIcon("images/evoli2.png"));

	/**
	 * 
	 * @param contenerPv
	 * @param adresseImage
	 * @param ordreAjout (true si on veut positionnement Pkmn Ennemi, false pour Pkmn Ami)
	 */
	public BlocPokemon(FenetrePv contenerPv, String adresseImage, boolean ordreAjout) {
		
		imagePk = new JLabel(new ImageIcon(adresseImage));
		
		bloc.setLayout(new BorderLayout());
		bloc.setBackground(Color.WHITE);
		if(ordreAjout) {
			bloc.add(contenerPv, BorderLayout.WEST);
			bloc.add(imagePk, BorderLayout.EAST);
		}
		else {
			bloc.add(imagePk,BorderLayout.WEST);		
			bloc.add(contenerPv,BorderLayout.EAST);
		}
		
		setBackground(Color.WHITE);
		add(bloc);
	}


	public JLabel getImagePk() {
		return imagePk;
	}


	public void setImagePk(String imagePk) {
		this.imagePk.setIcon(new ImageIcon(imagePk));
	}



	
	
}
