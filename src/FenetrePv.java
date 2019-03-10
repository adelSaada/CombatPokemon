import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FenetrePv extends JPanel {




	private JPanel blocLabelPv = new JPanel();
	
	private JLabel nomPk = new JLabel("PIKACHU");

	
	/* Contener des lvl */
	private JPanel contenerLvl = new JPanel();
	private JLabel texteLvl = new JLabel(new ImageIcon("imageLvl.png"));
	private JLabel level = new JLabel("5");
	
	/* Contener des PV */
	private JPanel contenerPv = new JPanel();
	private JLabel texteHp = new JLabel(new ImageIcon("imageHp.png"));
	private JLabel imagePv = new JLabel(new ImageIcon("pv100.png"), SwingConstants.LEFT);

	
	public FenetrePv() {
	
	}
	
	public FenetrePv(String lvl,String nom) {
		contenerPv.setBackground(Color.WHITE);
		contenerPv.add(texteHp);
		contenerPv.add(imagePv);

		
		/* Ajout des contener concernant les Levels */
		contenerLvl.add(texteLvl);
		contenerLvl.add(level);
		contenerLvl.setBackground(Color.WHITE);
		level.setFont(new Font("Impact", Font.PLAIN, 20));
		level.setText(lvl);
		
		blocLabelPv.setLayout(new BoxLayout(blocLabelPv,BoxLayout.Y_AXIS));
		blocLabelPv.add(nomPk);
		blocLabelPv.add(contenerLvl);
		blocLabelPv.add(contenerPv);
		blocLabelPv.setBackground(Color.WHITE);
		
		nomPk.setText(nom);
		nomPk.setFont(new Font("Impact", Font.PLAIN, 20));
		nomPk.setAlignmentX(CENTER_ALIGNMENT);
		
		
		add(blocLabelPv);
	}
	
	public void setAffichageLevel(String lvl) {
		this.level.setText(lvl);
	}
	
	
	public String getNomPk() {
		return this.nomPk.getText();
	}
	
	public void setNomPk(String pk) {
		nomPk.setText(pk);
	}
	
	
	public void setImgPv(String img) {
		this.imagePv.setIcon(new ImageIcon(img));
	}
	
	public Icon getImgPv() {
		return this.imagePv.getIcon();
	}

	public Icon getTexteLvl() {
		return texteLvl.getIcon();
	}

	public String getLevel() {
		return level.getText();
	}
	
	
	public void setLevel(String level) {
		this.level.setText(level);
	}

	public Icon getTexteHp() {
		return texteHp.getIcon();
	}


	
	
}
