package dataframe_project;

import java.util.ArrayList;

public class Dataframe {	
	private ArrayList<String> 	labels; 	//titres des colonnes
	private ArrayList<Object> contenus; 	//contenus des colonnes
	
	
	//constructeur parametre simple
	public Dataframe(Object...contenu) {
		//creation des arraylist
		this.contenus = new ArrayList<Object>();
		this.labels = new ArrayList<String>();
		//remplissage
		for(Object o : contenu) {
			this.contenus.add(o);
			this.labels.add(o.getClass().getName()); //label de la colonne définis par le nom de classe
		}
	}
	
	//return nombre de colonne
	public int getSize() {
		return this.contenus.size();
	}
}
