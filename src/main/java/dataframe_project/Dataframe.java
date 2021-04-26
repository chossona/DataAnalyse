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
	
	public String toString() {
		String res = "[";
		for (Colonne c : contenus) {
			res+=c.toString();
		}
		return res+"]";
	}
	
}
