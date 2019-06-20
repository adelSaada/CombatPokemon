import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePokemon extends JFrame {

	private static int compteurNbrAtqAmi = 1;
	private static int compteurNbrAtqEnnemi = 1;
	
	boolean mort = false;
	
	private static final int MAX=34;
	
	private List<String> listeImagePv = Arrays.asList("pv100","pv98","pv96","pv92","pv90","pv88","pv85",
			"pv80","pv75","pv70","pv65","pv63","pv60","pv55","pv50","pv45","pv40","pv35","pv30","pv25",
			"pv20","pv18","pv16","pv13","pv10","pv9","pv8","pv7","pv6","pv5","pv4","pv3","pv2","pv0");

	private Set<EtiquettePokemon> listeEtiqPkm = new HashSet<>();
	
	private FenetrePv contenerPvEnnemi = new FenetrePv("5","EVOLI");
	private FenetrePv contenerPvAmi = new FenetrePv("5","PIKACHU");
	
	/* Contener de liste Etiquette Pokemon */
	private JPanel contenuEtiquette = new JPanel(new GridLayout(6,1));
	
	/* les etiquettes Pokémons */
	private EtiquettePokemon etiquettePk1 = new EtiquettePokemon(contenerPvAmi,"images/pikachu2.gif");
	private EtiquettePokemon etiquettePk2 = new EtiquettePokemon(contenerPvEnnemi,"images/evoli.png");
	
	private JPanel contener = new JPanel();
	
	private JPanel barreDeMenu = new JPanel(); 	/* panel barre de menu */
	private menuPrincipal contenerMenu = new menuPrincipal(); /* menu selection attaquer/pokemon/objet/fuir */
	private MenuAttaque contenerAttaque = new MenuAttaque(); /* menu selection attaque (choix de 4 attaques max) */
	
	private JLabel texteMenu = new JLabel("Que doit faire Pikachu ?");

	private BlocPokemon blocAdversaire = new BlocPokemon(contenerPvEnnemi,"images/evoli2.png",true);
	private BlocPokemon blocAmi = new BlocPokemon(contenerPvAmi,"images/pikachuBack.png",false);
	
	private JButton boutonRetour = new JButton("Retour");
	

	public FenetrePokemon() throws IOException {
		
		this.setTitle("Pokémon Java");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		contener.setLayout(new BoxLayout(contener,BoxLayout.Y_AXIS));
		/* remettre les composants en blancs */
		boutonRetour.setBackground(Color.WHITE);
		barreDeMenu.setBackground(Color.WHITE);
		
		/* mettre en forme la barre de menu (bordure + taille préférée) */
		barreDeMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		barreDeMenu.setPreferredSize(new Dimension(WIDTH,100));	
		
		/* actions Boutons Menu Combat */
		contenerMenu.getBoutonFightMenu().addActionListener(this::actionMenuFight);
		contenerMenu.getBoutonRunMenu().addActionListener(this::actionMenuRun);
		contenerMenu.getBoutonPkmMenu().addActionListener(this::actionMenuPkm);
		boutonRetour.addActionListener(this::actionBoutonRetour);
		/* actions Boutons Attaques */
		contenerAttaque.getBoutonAttaque1().addActionListener(this::actionBoutonAttaque);
		contenerAttaque.getBoutonAttaque2().addActionListener(this::actionBoutonAttaque);
		contenerAttaque.getBoutonAttaque3().addActionListener(this::actionBoutonAttaque);
		contenerAttaque.getBoutonAttaque4().addActionListener(this::actionBoutonAttaque);
		/* remplissage de la liste d'étiquette Pokémon */
	  	listeEtiqPkm.add(etiquettePk1);
	  	listeEtiqPkm.add(etiquettePk2);
	  	for(EtiquettePokemon etiquette : listeEtiqPkm) {
	  		contenuEtiquette.add(etiquette);
	  	}
		/* Ajout des composants dans les composants mères associés */
		barreDeMenu.add(texteMenu);
		barreDeMenu.add(contenerMenu);
		contener.add(blocAdversaire);
		contener.add(blocAmi);
		contener.add(barreDeMenu);
		this.setBackground(Color.WHITE);
		this.getContentPane().add(contener);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*-------------------------Méthodes---------------------------------------------*/
	
	private void actionMenuFight(ActionEvent e) {
		
		new Thread() {
		      public void run() {
		    	  barreDeMenu.removeAll();
		    	  barreDeMenu.add(contenerAttaque);
		    	  barreDeMenu.add(boutonRetour);
		    	  barreDeMenu.revalidate();
		    	  barreDeMenu.repaint();
		      }
		}.start();
	}
	
	private void actionMenuPkm(ActionEvent e) {
		new Thread() {
		      public void run() {
		    	  contener.removeAll();		    	  
		    	  // actualisation des étiquettes
		    	  contenuEtiquette.removeAll();
		    	  
		  	  	  for(EtiquettePokemon etiquette : listeEtiqPkm) {
		  	  		  etiquette = new EtiquettePokemon(etiquette.getFenetrePv(),etiquette.getAdresseIcone());
		  	  		  contenuEtiquette.add(etiquette);
		  	  	  }
		    	  contener.add(contenuEtiquette);
		    	  contener.add(boutonRetour);

		    	  contener.revalidate();
		    	  contener.repaint();
		      }
		}.start();		
		
	}

	
	
	private void actionBoutonRetour(ActionEvent e) {
		new Thread() {
		      public void run() {
		    	  barreDeMenu.removeAll();
		    	  contener.removeAll();
		    	  barreDeMenu.add(texteMenu);
		    	  barreDeMenu.add(contenerMenu);
		    	  
		  		  contener.add(blocAdversaire);
				  contener.add(blocAmi);
				  contener.add(barreDeMenu);
				  contener.add(boutonRetour);
				  
				  contener.revalidate();
				  contener.repaint();
		      }
		}.start();		
		
	}
	
	private void actionBoutonAttaque(ActionEvent e) {
		
		new Thread() {
			public void run() {
				barreDeMenu.removeAll();
				barreDeMenu.add(texteMenu);
				texteMenu.setText(contenerPvAmi.getNomPk()+ " lance attaque "+ e.getActionCommand());
				blocAdversaire.setImagePk("images/evoli2Blessure.png");
				
				if(e.getActionCommand().equalsIgnoreCase("fatal-foudre")) {
					compteurNbrAtqEnnemi += 7;
				}
				else if(e.getActionCommand().equalsIgnoreCase("rugissement")) {
					texteMenu.setText("Evoli est moins rapide");
				}
				else {
					compteurNbrAtqEnnemi ++;					
				}
				changementPv(compteurNbrAtqEnnemi,contenerPvEnnemi);
				barreDeMenu.revalidate();
				barreDeMenu.repaint();	
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}				
				blocAdversaire.setImagePk("images/evoli2.png");
				barreDeMenu.revalidate();
				barreDeMenu.repaint();	
						
				if(! mort) {
					attaqueAdverse();					
				}
				texteMenu.setText("Que doit faire Pikachu ?");
				barreDeMenu.add(texteMenu);
				barreDeMenu.add(contenerMenu);
				barreDeMenu.revalidate();
				barreDeMenu.repaint();
		    }
		}.start();	
		
	}
	
	private void attaqueAdverse() {
		barreDeMenu.removeAll();
		barreDeMenu.add(texteMenu);
		texteMenu.setForeground(Color.BLACK);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(compteurNbrAtqEnnemi == 8 || compteurNbrAtqEnnemi == 30) {
			texteMenu.setText(contenerPvEnnemi.getNomPk()+ " se régènere");
			compteurNbrAtqEnnemi = 1;
			changementPv(compteurNbrAtqEnnemi,contenerPvEnnemi);
		}
		else {
			texteMenu.setText(contenerPvEnnemi.getNomPk()+ " lance Vive-Attaque");			
			compteurNbrAtqAmi += 2;
			blocAmi.setImagePk("images/pikachuBackBlessure.png");
			changementPv(compteurNbrAtqAmi, contenerPvAmi);
		}
		barreDeMenu.revalidate();
		barreDeMenu.repaint();	

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	private void actionMenuRun(ActionEvent e) {
		barreDeMenu.removeAll();
		barreDeMenu.add(texteMenu);
		texteMenu.setText("Vous prenez la fuite!");
		contener.remove(blocAmi);
		barreDeMenu.revalidate();
		barreDeMenu.repaint();
	}
	
	
	private void changementPv(int nombreAttaque,FenetrePv contenerPv) {	
		try {
			contenerPv.setImgPv("images/"+listeImagePv.get(nombreAttaque)+".png");
		} catch(IndexOutOfBoundsException e ) {
			if(nombreAttaque > FenetrePokemon.MAX) {
				contenerPv.setImgPv("images/"+listeImagePv.get(listeImagePv.size()-1)+".png");
				mort = true;
				blocAdversaire.removeAll();
				texteMenu.setText(contenerPv.getNomPk()+" est KO ! ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				if(!contenerPv.getNomPk().equals(contenerPvAmi.getNomPk())) {
					contenerPvAmi.setLevel(""+(Integer.parseInt(contenerPvAmi.getLevel())+1));
					texteMenu.setText(contenerPvAmi.getNomPk()+" monte au Niv "+ contenerPvAmi.getLevel());
				}				
			}
		} finally {
			contenerPv.revalidate();
			contenerPv.repaint();			
		}

	}
	
	
	private void changerPkm(String nouvLvl, String nouvNom,String nouvImg) {
		contenerPvAmi.setAffichageLevel(nouvLvl);
		contenerPvAmi.setNomPk(nouvNom);
		blocAmi = new BlocPokemon(contenerPvAmi,nouvImg,false);
	}
	


}