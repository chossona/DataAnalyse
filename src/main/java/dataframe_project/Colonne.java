package dataframe_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colonne<E> {
	private List<E> contenu;
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
	public Colonne(List<E> contenu) {
		this.contenu = contenu;
	}
	
	/**
	 * Constructeur avec label
	 * @param contenu Arraylist des valeurs
	 * @param label nom de la colonne
	 */
	public Colonne(String label, List<E> contenu) {
		this.label = label;
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
	 * ajoute un element a la colonne
	 * @param element element a ajoute
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
	 * Recupere le label de la colonne
	 * @return label de la colonne
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Recupere l'élement à un index particulier
	 * @param index
	 * @return
	 */
	public E getElement(int index) {
		return this.contenu.get(index);
	}
	
	/**
	 * Definit l'element a un index particulier
	 * @param index
	 * @param element
	 */
	public void setElement(int index, E element) {
		this.contenu.set(index, element);
	}
	
	/**
	 * 
	 * @return String value de la colonne
	 */
	public String toString() {
		String res = this.label+"[";
		res += Colonne.join(",", this.contenu);
		return res+"]";
	}
	
	/**
	 * 
	 * @param nb nombre de ligne a afficher
	 * @return string value des nb premieres lignes
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
	 * @return nombre d'element dans la collone
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
    private static String join(String separator, List<?> input) {

        if (input == null || input.size() <= 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.size(); i++) {

            sb.append(input.get(i));

            // if not the last item
            if (i != input.size() - 1) {
                sb.append(separator);
            }

        }

        return sb.toString();

    }

}

