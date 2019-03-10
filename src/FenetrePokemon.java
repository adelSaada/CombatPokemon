import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePokemon extends JFrame {

	private static int compteurNbrAtqAmi = 1;
	private static int compteurNbrAtqEnnemi = 1;
	
	boolean mort = false;
	
	private static final int MAX=34;

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
		contenerPvEnnemi.setBackground(Color.WHITE);
		contenerPvAmi.setBackground(Color.WHITE);
		boutonRetour.setBackground(Color.WHITE);
		barreDeMenu.setBackground(Color.WHITE);
		blocAdversaire.setBackground(Color.WHITE);
		blocAmi.setBackground(Color.WHITE);
		contener.setBackground(Color.WHITE);
		
		/* mettre en forme la barre de menu (bordure + taille préférée) */
		barreDeMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		barreDeMenu.setPreferredSize(new Dimension(WIDTH,100));
		
		/* action Boutons Menu */
		contenerMenu.getBoutonFightMenu().addActionListener(this::actionMenuFight);
		contenerMenu.getBoutonRunMenu().addActionListener(this::actionMenuRun);
		contenerMenu.getBoutonPkmMenu().addActionListener(this::actionMenuPkm);
		boutonRetour.addActionListener(this::actionBoutonRetour);
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

		
		/* Ajout des composants dans les composants mères associés) */
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
				texteMenu.setForeground(Color.BLACK);
				texteMenu.setText(contenerPvAmi.getNomPk()+ " lance attaque "+ e.getActionCommand());
				blocAdversaire.setImagePk("images/evoli2Blessure.png");
				
				if(e.getActionCommand().equalsIgnoreCase("fatal-foudre")) {
					compteurNbrAtqEnnemi += 10;
				}
				else if(e.getActionCommand().equalsIgnoreCase("rugissement")) {
					texteMenu.setText("Evoli est moins rapide");
				}
				else {
					compteurNbrAtqEnnemi ++;					
				}
				attaque(compteurNbrAtqEnnemi,contenerPvEnnemi);
				barreDeMenu.revalidate();
				barreDeMenu.repaint();	
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				//texteMenu.setText("C'est très efficace ...");
				
				blocAdversaire.setImagePk("images/evoli2.png");
				barreDeMenu.revalidate();
				barreDeMenu.repaint();	
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				barreDeMenu.removeAll();
				
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
			attaque(compteurNbrAtqEnnemi,contenerPvEnnemi);
		}
		else {
			texteMenu.setText(contenerPvEnnemi.getNomPk()+ " lance Vive-Attaque");			
			compteurNbrAtqAmi += 2;
			blocAmi.setImagePk("images/pikachuBackBlessure.png");
			attaque(compteurNbrAtqAmi, contenerPvAmi);
		}
		barreDeMenu.revalidate();
		barreDeMenu.repaint();	

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		barreDeMenu.removeAll();
		blocAmi.setImagePk("images/pikachuBack.png");

		texteMenu.setText("Que doit faire Pikachu ?");
		barreDeMenu.add(texteMenu);
		barreDeMenu.add(contenerMenu);
		barreDeMenu.revalidate();
		barreDeMenu.repaint();
	}
	
	private void actionMenuRun(ActionEvent e) {

		barreDeMenu.removeAll();
		barreDeMenu.add(texteMenu);
		texteMenu.setText("Vous prenez la fuite!");
		contener.remove(blocAmi);
		barreDeMenu.revalidate();
		barreDeMenu.repaint();

	}
	
	
	private void attaque(int nombreAttaque,FenetrePv contenerPv) {
		
		switch(nombreAttaque) {
		
		case 1 :
			contenerPv.setImgPv("images/pv100.png");	
			break;
		case 2 :
			contenerPv.setImgPv("images/pv98.png");	
			break;
		case 3 :
			contenerPv.setImgPv("images/pv96.png");	
			break;
		case 4 :
			contenerPv.setImgPv("images/pv92.png");	
			break;
		case 5 :
			contenerPv.setImgPv("images/pv90.png");	
			break;
		case 6 :
			contenerPv.setImgPv("images/pv88.png");
			break;
		case 7 :
			contenerPv.setImgPv("images/pv85.png");
			break;
		case 8 :
			contenerPv.setImgPv("images/pv80.png");	
			break;
		case 9 :
			contenerPv.setImgPv("images/pv75.png");	
			break;
		case 10 :
			contenerPv.setImgPv("images/pv70.png");	
			break;
		case 11 :
			contenerPv.setImgPv("images/pv65.png");	
			break;
			
		case 12 :
			contenerPv.setImgPv("images/pv63.png");	
			break;
		case 13 :
			contenerPv.setImgPv("images/pv60.png");	
			break;
		case 14 :
			contenerPv.setImgPv("images/pv55.png");	
			break;
		case 15 :
			contenerPv.setImgPv("images/pv50.png");	
			break;
		case 16 :
			contenerPv.setImgPv("images/pv45.png");	
			break;
		case 17 :
			contenerPv.setImgPv("images/pv40.png");
			break;
		case 18 :
			contenerPv.setImgPv("images/pv35.png");
			break;
		case 19 :
			contenerPv.setImgPv("images/pv30.png");	
			break;
		case 20 :
			contenerPv.setImgPv("images/pv25.png");	
			break;
		case 21 :
			contenerPv.setImgPv("images/pv20.png");
			break;
		case 22 :
			contenerPv.setImgPv("images/pv18.png");
			break;
		case 23 :
			contenerPv.setImgPv("images/pv16.png");	
			break;
		case 24 :
			contenerPv.setImgPv("images/pv13.png");
			break;
		case 25 :
			contenerPv.setImgPv("images/pv10.png");	
			break;		
		case 26 :
			contenerPv.setImgPv("images/pv9.png");	
			break;
		case 27 :
			contenerPv.setImgPv("images/pv8.png");	
			break;
		case 28 :
			contenerPv.setImgPv("images/pv7.png");	
			break;
		case 29 :
			contenerPv.setImgPv("images/pv6.png");	
			break;
		case 30 :
			contenerPv.setImgPv("images/pv5.png");	
			break;
		case 31 :
			contenerPv.setImgPv("images/pv4.png");
			break;
		case 32 :
			contenerPv.setImgPv("images/pv3.png");
			break;
		case 33 :
			contenerPv.setImgPv("images/pv2.png");	
			break;
		case 34 :
			contenerPv.setImgPv("images/pv0.png");	
		default :
			mort = true;
			blocAdversaire.removeAll();
			texteMenu.setText(contenerPv.getNomPk()+" est KO ! ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!contenerPv.getNomPk().equals(contenerPvAmi.getNomPk())) {
				contenerPvAmi.setLevel(""+(Integer.parseInt(contenerPvAmi.getLevel())+1));
				texteMenu.setText(contenerPvAmi.getNomPk()+" monte au Niv "+ contenerPvAmi.getLevel());
			}


		}
		contenerPv.revalidate();
		contenerPv.repaint();	
	}
	
	
	private void changerPkm(String nouvLvl, String nouvNom,String nouvImg) {
		contenerPvAmi.setAffichageLevel(nouvLvl);
		contenerPvAmi.setNomPk(nouvNom);
		blocAmi = new BlocPokemon(contenerPvAmi,nouvImg,false);
	}
	


}