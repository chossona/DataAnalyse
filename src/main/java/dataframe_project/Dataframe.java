package dataframe_project;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dataframe {
	private ArrayList<Colonne> contenus;
	
	/**
	 * constructeur dataframe vide
	 */
	public Dataframe() {
		this.contenus = new ArrayList<Colonne>();
	}
	
	/**
	 * Constructeur a partir d'une seul colone
	 * @param dataframe
	 */
	public Dataframe(ArrayList<Colonne> dataframe) {
		this.contenus = dataframe;
	}
	
	/**
	 * Constructeur a partir de colonnes
	 * @param dataframe
	 */
	public Dataframe(Colonne...dataframe) {
		this.contenus = new ArrayList<Colonne>();
		for(Colonne c : dataframe) {
			this.contenus.add(c);
		}
	}
	
	/**
	 *  * constructeur a partir d'un fichier csv avec separateur definis a ','
	 * les labels doivent prealablement etre enleve du csv, il ne doit y avoir que des valeurs
	 * @param filepath
	 */
	public Dataframe(String filepath) {
		this.contenus = new ArrayList<Colonne>();
		String[] tableau_mot;
		String ligne ="";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filepath));
			Boolean creerDataframe = true;
			while ((ligne = br.readLine()) != null){
				tableau_mot = ligne.split(","); //chaque champs est separe par une virgule
				if(creerDataframe) {
					//si permiere ligne on met en place le dataframe (on creer chaque colonne
					for(int i = 0; i< tableau_mot.length; i++) {
						this.contenus.add(new Colonne<String>());
					}
					creerDataframe = false;
				}
				
				for(int i = 0; i< tableau_mot.length; i++) {
					this.contenus.get(i).add(tableau_mot[i]);
				}	
			} 
		} catch (FileNotFoundException e) {
			System.out.println("Fichier inexistant");
			this.contenus = new ArrayList<Colonne>();
		} catch (IOException e) {
			e.printStackTrace();
			this.contenus = new ArrayList<Colonne>();
		} 
	}
	
	/**
	 * constructeur a partir d'un fichier csv avec separateur donne en argument
	 * les labels doivent pr�alablement etre enleve du csv, il ne doit y avoir que des valeurs
	 * @param filepath
	 * @param separateur
	 */
	public Dataframe(String filepath, String separateur) {
			this.contenus = new ArrayList<Colonne>();
			String[] tableau_mot;
			String ligne ="";
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(filepath));
				Boolean creerDataframe = true;
				while ((ligne = br.readLine()) != null){
					tableau_mot = ligne.split(separateur); //chaque champs est separe par une virgule
					if(creerDataframe) {
						//si permiere ligne on met en place le dataframe (on creer chaque colonne
						for(int i = 0; i< tableau_mot.length; i++) {
							this.contenus.add(new Colonne<String>());
						}
						creerDataframe = false;
					}
					
					for(int i = 0; i< tableau_mot.length; i++) {
						this.contenus.get(i).add(tableau_mot[i]);
					}	
				} 
			} catch (FileNotFoundException e) {
				System.out.println("Fichier inexistant");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	
	/**
	 * aille du dataframe en nombre de colonnes
	 * @return
	 */
	public int getSize() {
		return this.contenus.size();
	}
	
	/**
	 * ajoute une colonne au dataframe
	 * @param colonne ajouter
	 */
	public void addColonne(Colonne colonne) {
		this.contenus.add(colonne);
	}
	
	public String toString() {
		String res = "[";
		for (Colonne c : contenus) {
			res+=c.toString();
		}
		return res+"]";
	}
	
	/**
	 * affiche l'integralite du dataframe
	 */
	public void Afficher() {
		System.out.println(this.toString());
	}
	
	/**
	 * Affiche les premiere ligne du dataframe
	 * @param nombre_de_ligne nombre de ligne a afficher
	 */
	public void AfficherPremieresLignes(int nombre_de_ligne) {
		for(Colonne c : this.contenus) {
			System.out.println(c.AffichagePremiereLigne(nombre_de_ligne)+"\n");
		}
	}
	
	/**
	 * Affiche les derniere ligne du dataframe
	 * @param nombre_de_ligne nombre de ligne a afficher
	 */
	//methode d'affichage derniere ligne
		public void AfficherDernieresLignes(int nombre_de_ligne) {
			for(Colonne c : this.contenus) {
				System.out.println(c.AffichageDerniereLigne(nombre_de_ligne)+"\n");
			}
		}
}
