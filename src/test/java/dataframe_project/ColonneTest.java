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
	
	
	@Test
	public void t_max_str() {
		Colonne<String> c2  = new Colonne<String>("papa","a","tromper","maman");
		assertEquals("tromper", c2.max());
		assertNotEquals("papa", c2.max());
		
	}
	
	@Test
	public void t_max_intr() {
		Colonne<Integer> c2  = new Colonne<Integer>(1,2,3,4,5,1);
		assertEquals(c2.max().toString(),"5");
		assertNotEquals(c2.max().toString(),"1");
		
	}
	
	
}
