package dataframe_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColonneTest {

	@Test
	public void affichageDebut() {
		Colonne<String> c2  = new Colonne<String>("papa","a","tromper","maman");
		String res = c2.AffichagePremiereLigne(2);
		assertEquals(res, "[label: data: [papa,a,]]");		
	}
	
	@Test
	public void affichageDebutOverflow() {
		Colonne<String> c2  = new Colonne<String>("papa","a","tromper","maman");
		String res = c2.AffichagePremiereLigne(5);
		assertEquals(res, "[label: data: [papa,a,tromper,maman,]]");		
	}
	
	@Test
	public void affichageFin() {
		Colonne<String> c2  = new Colonne<String>("papa","a","tromper","maman");
		String res = c2.AffichageDerniereLigne(2);
		assertEquals(res, "[label: data: [tromper,maman,]]");		
	}
	
	@Test
	public void affichageFinOverflow() {
		Colonne<String> c2  = new Colonne<String>("papa","a","tromper","maman");
		String res = c2.AffichageDerniereLigne(5);
		assertEquals(res, "[label: data: [papa,a,tromper,maman,]]");		
	}
	
}
