import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EtiquettePokemon extends JPanel {

	private JPanel contenerEtiquette = new JPanel();
	
	private JLabel iconePk;
	private JLabel nomPk;
	
	/* Contener des lvl */
	private JPanel contenerLvl = new JPanel();
	private JLabel texteLvl ;
	private JLabel level ;
	
	/* Contener des PV */
	private JPanel contenerPv = new JPanel();
	private JLabel texteHp;
	private JLabel imgPv;
	
	/* contener PV + nom */
	private JPanel contenerNomPv = new JPanel();
	
	private JButton choixPkm = new JButton("selection");
	
	/* recupération FenetrePv */
	private FenetrePv recupFenetrePv;
	private String adresseIcone;
	
	public EtiquettePokemon() {
	}
	
	public EtiquettePokemon(FenetrePv fenetrePv, String adresseIconePk) {
		
		recupFenetrePv = fenetrePv;
		adresseIcone = adresseIconePk;
		
		this.setPreferredSize(new Dimension(500,50));
		texteLvl = new JLabel(fenetrePv.getTexteLvl());
		texteLvl.setBackground(Color.WHITE);
		level = new JLabel(fenetrePv.getLevel());
		level.setBackground(Color.WHITE);
		texteHp = new JLabel(fenetrePv.getTexteHp());
		texteHp.setBackground(Color.WHITE);
		imgPv = new JLabel(fenetrePv.getImgPv());
		imgPv.setBackground(Color.WHITE);
		nomPk = new JLabel(fenetrePv.getNomPk());
		nomPk.setBackground(Color.WHITE);
		
		iconePk = new JLabel(new ImageIcon(adresseIconePk));

		contenerPv.add(texteHp);
		contenerPv.add(imgPv);
		contenerPv.setBackground(Color.WHITE);
		
		contenerNomPv = new JPanel();
		contenerNomPv.setBackground(Color.WHITE);
		
		contenerNomPv.add(nomPk);
		contenerNomPv.add(contenerPv);
		
		contenerLvl.add(texteLvl);
		contenerLvl.add(level);
		contenerLvl.setBackground(Color.WHITE);
		
		constructeurEtiquette(iconePk,contenerNomPv,contenerLvl);
		
	}
	
	public void constructeurEtiquette(JLabel iconePk,JPanel contenerNomPv,JPanel contenerLvl) {
		
		contenerEtiquette.add(iconePk);
		contenerEtiquette.add(contenerNomPv);
		contenerEtiquette.add(contenerLvl);
		contenerEtiquette.add(choixPkm);
		
		choixPkm.setBackground(Color.WHITE);
		
		contenerEtiquette.setBackground(Color.white);
		
		add(contenerEtiquette);

	}
	
	public JButton getBoutonChoixPkm() {
		return choixPkm;
	}
	

	public JLabel getIconePk() {
		return iconePk;
	}

	public JPanel getContenerLvl() {
		return contenerLvl;
	}

	public JPanel getContenerNomPv() {
		return contenerNomPv;
	}
	
	

	public FenetrePv getFenetrePv() {
		return this.recupFenetrePv;
	}

	public String getAdresseIcone() {
		return this.adresseIcone;
	}

}
