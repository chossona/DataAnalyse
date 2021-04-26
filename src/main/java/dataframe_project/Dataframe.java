package dataframe_project;

import java.util.ArrayList;

public class Dataframe {
	private ArrayList<Colonne> contenus;
	
	public Dataframe() {
		this.contenus = new ArrayList<Colonne>();
	}
	//constructeur parametre simple
	//each Object in contenu must be an array like int[], float[],etc..
	public Dataframe(ArrayList<Colonne> dataframe) {
		this.contenus = dataframe;
	}
	
	public Dataframe(Colonne...dataframe) {
		this.contenus = new ArrayList<Colonne>();
		for(Colonne c : dataframe) {
			this.contenus.add(c);
		}
	}
	
	//return nombre de colonne
	public int getSize() {
		return this.contenus.size();
	}
	
	public void addColonne(Colonne colonne) {
		this.contenus.add(colonne);
	}
	
	
	//Methode d'affichage//////////////////////////////////////
	
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
