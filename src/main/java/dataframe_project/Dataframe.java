package dataframe_project;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dataframe {
	private ArrayList<Colonne> contenus;
	
	public Dataframe() {
		this.contenus = new ArrayList<Colonne>();
	}
	
	//constructeur parametre simple
	public Dataframe(ArrayList<Colonne> dataframe) {
		this.contenus = dataframe;
	}
	
	//constructeur prenant plusieurs colonne en parametre
	public Dataframe(Colonne...dataframe) {
		this.contenus = new ArrayList<Colonne>();
		for(Colonne c : dataframe) {
			this.contenus.add(c);
		}
	}
	
	//constructeur depuis fichier csv avec separateur etablis à "," 
	public Dataframe(String filepath) {
		this.contenus = new ArrayList<Colonne>();
		String[] tableau_mot;
		String ligne ="";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filepath));
			Boolean creerDataframe = true;
			while ((ligne = br.readLine()) != null){
				tableau_mot = ligne.split(","); //chaque champs est séparé par une virgule
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
	
	//constructeur depuis fichier csv avec separateur etablis à "," 
	public Dataframe(String filepath, String separateur) {
			this.contenus = new ArrayList<Colonne>();
			String[] tableau_mot;
			String ligne ="";
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(filepath));
				Boolean creerDataframe = true;
				while ((ligne = br.readLine()) != null){
					tableau_mot = ligne.split(separateur); //chaque champs est séparé par une virgule
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
	
	//return nombre de colonne
	public int getSize() {
		return this.contenus.size();
	}
	
	//ajouter une colonne
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
	
	//methode d'affichage total
	public void Afficher() {
		System.out.println(this.toString());
	}
	
	//methode d'affichage premiere ligne
	public void AfficherPremieresLignes(int nombre_de_ligne) {
		for(Colonne c : this.contenus) {
			System.out.println(c.AffichagePremiereLigne(nombre_de_ligne)+"\n");
		}
	}
	
	//methode d'affichage derniere ligne
		public void AfficherDernieresLignes(int nombre_de_ligne) {
			for(Colonne c : this.contenus) {
				System.out.println(c.AffichageDerniereLigne(nombre_de_ligne)+"\n");
			}
		}
}
