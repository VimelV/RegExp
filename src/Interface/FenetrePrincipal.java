package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Controleur.AjoutCouleur;
import Controleur.ControleurPrincipal;
/**
 * Permet l'affichage de l'interface utilisateur
 * @author Benjamin
 *
 */
public class FenetrePrincipal extends JFrame {
	private JMenuBar barreDeMenu=new JMenuBar();
	private JMenu aide=new JMenu("Aide");
	private JMenuItem boutonAPropos=new JMenuItem("A Propos");
	private JFrame cetteFenetre;
	private JLabel texte;
	private JTextField champDeSaisie;
	private ControleurPrincipal monControleur;
	private String biloute ="";
	/**
	 * Affiche la fenetre principale de l'application
	 * @param controleurPrincipal Le controleurPrincipal de l'application
	 * 
	 */
	public FenetrePrincipal(ControleurPrincipal controleurPrincipal){
		super("RegExp");
		cetteFenetre=this;
		monControleur=controleurPrincipal;
		this.setSize(new Dimension(500,400));
		this.setLayout(new BorderLayout());
		
		
		this.add(barreDeMenu,BorderLayout.NORTH);
		barreDeMenu.add(aide);
		aide.add(boutonAPropos);
		
		boutonAPropos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				A_propos fenetreApropos = new A_propos(cetteFenetre, "A Propos");
				
			}
		});
		
		biloute = AjoutCouleur.ajouterCouleur(monControleur.getTexteAfficher(), monControleur.getRegExp(),"green");
		//texte=new JLabel(monControleur.getTexteAfficher());
		texte=new JLabel(biloute);
		JPanel panMilieu=new JPanel();
		this.add(panMilieu,BorderLayout.CENTER);
		panMilieu.setLayout(new FlowLayout());
		panMilieu.add(texte);
		
		
		
		JPanel panSud=new JPanel();
		champDeSaisie=new JTextField();
		champDeSaisie.setPreferredSize(new Dimension(200,30));
		panSud.add(champDeSaisie);
		JButton BoutonDeValidation=new JButton("Valider");
		panSud.add(BoutonDeValidation);
		System.out.println(biloute);
		BoutonDeValidation.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("debut  " +biloute);
				biloute = AjoutCouleur.ajouterCouleur(biloute, champDeSaisie.getText(),"red");
			//texte.setText(AjoutCouleur.ajouterCouleur(monControleur.getTexteAfficher(), champDeSaisie.getText(),"red"));
				texte.setText(biloute);
			//System.out.println(AjoutCouleur.ajouterCouleur(monControleur.getTexteAfficher(), champDeSaisie.getText(),"red"));
				System.out.println("fin  "+biloute);
			//ccc	
			}
		});
		
		champDeSaisie.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.err.println("ok");
				
			}
			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		this.add(panSud,BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

}
