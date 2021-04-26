package dataframe_project;

import java.util.ArrayList;

public class Colonne<E> {
	private ArrayList<E> contenu;
	private String label = "";
	
	public Colonne() {
		this.contenu = new ArrayList<E>();
	}
	
	public Colonne(ArrayList<E> contenu) {
		this.contenu = contenu;
	}
	public Colonne(E... contenu) {
		this.contenu = new ArrayList<E>();
		for(E elem : contenu) {
			this.contenu.add(elem);
		}
	}
	public Colonne(ArrayList<E> contenu, String label) {
		this.contenu = contenu;
		this.label = label;
	}
	
	public void add(E element) {
		this.contenu.add(element);
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String toString() {
		String res = "[";
		for(E element : this.contenu) {
			res+=element.toString()+",";
		}
		return res+"]";
	}
	
	public String AffichagePremiereLigne(int nombre_de_ligne) {
		String res = "[label: "+this.label+"data: [";
	    for(int i=0; (i<nombre_de_ligne) && (i<this.size()); i++) {
	    	res+= this.contenu.get(i).toString()+",";
	    }
	    return res+"]]";
	}
	
	public String AffichageDerniereLigne(int nombre_de_ligne) {
		String res = "[label: "+this.label+"data: [";
	    for(int i= Math.max(0, this.size()-nombre_de_ligne); i<this.size(); i++) {
	    	res+= this.contenu.get(i).toString()+",";
	    }
	    return res+"]]";
	}
	
	public int size() {
		return this.contenu.size();
	}
}

