package dataframe_project;

import java.util.ArrayList;

public class Colonne<E> {
	private ArrayList<E> contenu;
	private String label = "";
	
	/**
	 * colonne vide sans label
	 */
	public Colonne() {
		this.contenu = new ArrayList<E>();
	}
	
	/**
	 * constructeur a partir d'arraylist sans label
	 * @param contenu arraylist d'element de la colonne
	 */
	public Colonne(ArrayList<E> contenu) {
		this.contenu = contenu;
	}
	
	/**
	 * Constructeur a partir d'elements
	 * @param contenu elements a mettre dans la colonne
	 */
	public Colonne(E... contenu) {
		this.contenu = new ArrayList<E>();
		for(E elem : contenu) {
			this.contenu.add(elem);
		}
	}
	
	/**
	 * Constructeur avec label
	 * @param contenu Arraylist des valeurs
	 * @param label nom de la colonne
	 */
	public Colonne(ArrayList<E> contenu, String label) {
		this.contenu = contenu;
		this.label = label;
	}
	
	/**
	 * ajoute un element à la colonne
	 * @param element element a ajouté
	 */
	public void add(E element) {
		this.contenu.add(element);
	}
	
	
	/**
	 * Definit le label de la colonne
	 * @param label a mettre en place
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * 
	 * @return String value de la colonne
	 */
	public String toString() {
		String res = "[";
		for(E element : this.contenu) {
			res+=element.toString()+",";
		}
		return res+"]";
	}
	
	/**
	 * 
	 * @param nb nombre de ligne a afficher
	 * @return string value des nb premières lignes
	 */
	public String AffichagePremiereLigne(int nombre_de_ligne) {
		String res = "[label: "+this.label+"data: [";
	    for(int i=0; (i<nombre_de_ligne) && (i<this.size()); i++) {
	    	res+= this.contenu.get(i).toString()+",";
	    }
	    return res+"]]";
	}
	
	/**
	 * 
	 * @param nb nombre de ligne a afficher
	 * @return string value des nb derniere lignes
	 */
	public String AffichageDerniereLigne(int nb) {
		String res = "[label: "+this.label+"data: [";
	    for(int i= Math.max(0, this.size()-nb); i<this.size(); i++) {
	    	res+= this.contenu.get(i).toString()+",";
	    }
	    return res+"]]";
	}
	
	/**
	 * 
	 * @return nombre d'lement dans la collone
	 */
	public int size() {
		return this.contenu.size();
	}

	/*
	 * Partie outils Stats
	 */
	
	/**
	 * 
	 * @return maximum the colums (by length if string) return null if type max isn't supported
	 */
	public E max() {
		E max = this.contenu.get(0);
		try {
			for (E e: this.contenu) {
				if ((Integer)e > ((Integer) max)) max = e;
			}
			return max;
		} catch (Exception e) {
			try {
				for (E f: this.contenu) {
					if (f.toString().length() > max.toString().length()) max = f;
				}
				return max;
			} catch (Exception e2) {
				return null;
			}
			
		}
	}
	
	/**
	 * 
	 * @return minimum the colums (by length if string) return null if type max isn't supported
	 */
	public E min() {
		E max = this.contenu.get(0);
		try {
			for (E e: this.contenu) {
				if ((Integer)e < ((Integer) max)) max = e;
			}
			return max;
		} catch (Exception e) {
			try {
				for (E f: this.contenu) {
					if (f.toString().length() < max.toString().length()) max = f;
				}
				return max;
			} catch (Exception e2) {
				return null;
			}
			
		}
	}

}

