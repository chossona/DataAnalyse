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
	 * Constructeur a partir d'un fichier csv.
	 * Le label est le premier mot, les suivants sont le contenu
	 * @param filepath
	 */
	public Dataframe(String filepath) {
		parseInit(filepath, ",");
	}
	
	/**
	 * Constructeur a partir d'un fichier separated value avec separateur donne en argument.
	 * Le label est le premier mot, les suivants sont le contenu
	 * @param filepath
	 * @param separateur
	 */
	public Dataframe(String filepath, String separateur) {
		parseInit(filepath, separateur);
	}
	
	private void parseInit(String filepath, String separator) {
		this.contenus = new ArrayList<Colonne>();
		String[] tableau_mot;
		String ligne ="";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((ligne = br.readLine()) != null){
				tableau_mot = ligne.split(separator); //chaque champs est separe par une virgule
				String label = tableau_mot[0];
				Colonne<String> colonne = new Colonne<String>();
				colonne.setLabel(label);
				this.contenus.add(colonne);
				//Ajout de chaque mot, on commence a l'indice 1
				for(int i = 1; i< tableau_mot.length; i++) {
					colonne.add(tableau_mot[i]);
				}	
			} 
		} catch (FileNotFoundException e) {
			System.out.println("Fichier inexistant");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creer un dataframe etant un sous groupe du dataframe
	 * @param labelDebut Label de debut inclus
	 * @param labelFin Label de fin inclus
	 * @return
	 */
	public Dataframe loc(String labelDebut, String labelFin) {
		Dataframe df = new Dataframe();
		int i=0;
		while( i<contenus.size() && contenus.get(i).getLabel() != labelDebut ) i++;
		while( i<contenus.size() && contenus.get(i).getLabel() != labelFin) {
			df.addColonne(contenus.get(i));
			i++;
		}
		if( i<contenus.size()) {
			df.addColonne(contenus.get(i));
		}
		return df;
	}
	

	/**
	 * Creer un dataframe etant un sous groupe du dataframe
	 * @param label Label a selectionner
	 * @return
	 */
	public Dataframe loc(String label) {
		Dataframe df = new Dataframe();
		int i=0;
		while( i<contenus.size() && contenus.get(i).getLabel() != label ) i++;
		if( i<contenus.size()) {
			df.addColonne(contenus.get(i));
		}
		return df;
	}

	/**
	 * Creer un dataframe etant un sous groupe du dataframe
	 * @param indexDebut Index de debut inclus
	 * @param indexFin Index de fin inclus
	 * @return
	 */
	public Dataframe iloc(int indexDebut, int indexFin) {
		Dataframe copyDf = new Dataframe();
		if(indexDebut>0 && indexFin<this.contenus.size()) {
			for (int i=0; i<contenus.size(); i++) {
				Colonne colonne = contenus.get(i);
				Colonne copyC = new Colonne();
				copyC.setLabel(colonne.getLabel());
				for(int j = indexDebut; j<indexFin; j++) {
					copyC.add(colonne.getElement(j));
				}
				copyDf.addColonne(copyC);
			}
		}
		return copyDf;
	}
	
	/**
	 * Creer un dataframe etant un sous groupe du dataframe
	 * @param index Index a selectionner
	 * @return
	 */
	public Dataframe iloc(int index) {
		Dataframe copyDf = new Dataframe();
		if(index>0 && index<this.contenus.size()) {
			for (int i=0; i<contenus.size(); i++) {
				Colonne colonne = contenus.get(i);
				Colonne copyC = new Colonne();
				copyC.setLabel(colonne.getLabel());
				copyC.add(colonne.getElement(index));
				copyDf.addColonne(copyC);
			}
		}
		return copyDf;
	}
	
	/**
	 * taille du dataframe en nombre de colonnes
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
		String res = "[ ";
		for (Colonne c : contenus) {
			res+=c.toString() + " ";
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
