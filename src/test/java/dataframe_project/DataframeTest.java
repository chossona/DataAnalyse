package dataframe_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DataframeTest {

	@Test 
	public void t_ConstrSimple_1() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Dataframe d = new Dataframe(c1);
		assertEquals(d.getSize(), 1);//test controlleur1
	}
	
	@Test 
	public void t_dataframe_vide() {
		Dataframe d = new Dataframe();
		d.Afficher();
	}
	
	@Test 
	public void t_dataframe_vide_lastligne() {
		Dataframe d = new Dataframe();
		d.AfficherDernieresLignes(5);
	}
	
	@Test 
	public void t_dataframe_vide_firstline() {
		Dataframe d = new Dataframe();
		d.AfficherPremieresLignes(5);
	}
	
	@Test 
	public void t_ConstrSimple_2() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Colonne<Integer> c2  = new Colonne<Integer>(1,5,6,7,8);
		Dataframe d = new Dataframe(c1,c2);
		assertEquals(d.getSize(), 2);//test controlleur 2
		ArrayList<Colonne> contenu = new ArrayList<Colonne>();
		contenu.add(c2);
		contenu.add(c1);
		assertEquals(d.getSize(), 2);//test controlleur 3

	}
	
	@Test 
	public void t_ConstrSimple_3() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Colonne<Integer> c2  = new Colonne<Integer>(1,5,6,7,8);
		ArrayList<Colonne> contenu = new ArrayList<Colonne>();
		contenu.add(c2);
		contenu.add(c1);
		Dataframe d = new Dataframe(contenu);
		assertEquals(d.getSize(), 2);//test controlleur 3

	}
	
	@Test 
	public void t_affichage_int() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Colonne<Integer> c2  = new Colonne<Integer>(1,5,6,7,8);
		Colonne<Integer> c3  = new Colonne<Integer>(1,5,6,7,8);
		Dataframe d = new Dataframe(c1,c2,c3);
		assertEquals("[ [1,2,3] [1,5,6,7,8] [1,5,6,7,8] ]", d.toString());
	}
	
	@Test 
	public void t_affichage_str_int() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Colonne<Integer> c2  = new Colonne<Integer>(1,5,6,7,8);
		Colonne<String> c3  = new Colonne<String>("papa","a","tromper","maman");
		Dataframe d = new Dataframe(c1,c2,c3);
		assertEquals("[ [1,2,3] [1,5,6,7,8] [papa,a,tromper,maman] ]", d.toString());
	}
	
	@Test
	public void lecture_csv(){
		Dataframe d = new Dataframe("exemple_csv.csv");
		assertEquals("[ Noms[Pierre,Paul,Jacques] Ages[26,18,58] ]", d.toString());
	}

	@Test 
	public void t_lecture_csv_vide() {
		Dataframe d = new Dataframe("exemple_vide.csv");
		assertEquals("[ ]", d.toString());
	}
	
	@Test 
	public void t_lecture_csv_inexistant() {
		try {
			Dataframe d = new Dataframe("introuvable.csv");
		}catch (Exception e) {
			fail("erreur a l'ouverture");
		}
	}
	
	@Test 
	public void t_selection_une_colonne() {
		Colonne<Integer> c1 = new Colonne<Integer>("label1",Arrays.asList(1,2,3));
		Colonne<Integer> c2 = new Colonne<Integer>("label2",Arrays.asList(4,5,6));
		Colonne<Integer> c3 = new Colonne<Integer>("label3",Arrays.asList(7,8,9));
		Dataframe d1 = new Dataframe(c1,c2,c3);
		Dataframe copyColonne = d1.loc("label2");
		Dataframe dExpected = new Dataframe(c2);
		assertEquals(copyColonne.toString(), dExpected.toString());
	}
	
	@Test
	public void t_selection_plusieurs_colonne() {
		Colonne<Integer> c1 = new Colonne<Integer>("label1",Arrays.asList(1,2,3));
		Colonne<Integer> c2 = new Colonne<Integer>("label2",Arrays.asList(4,5,6));
		Colonne<Integer> c3 = new Colonne<Integer>("label3",Arrays.asList(7,8,9));
		Colonne<Integer> c4 = new Colonne<Integer>("label4",Arrays.asList(10,11,12));
		Colonne<Integer> c5 = new Colonne<Integer>("label5",Arrays.asList(13,14,15));
		Dataframe d = new Dataframe(c1,c2,c3,c4,c5);
		Dataframe copyColonne = d.loc("label2","label4");
		Dataframe dExpected = new Dataframe(c2,c3,c4);
		assertEquals(copyColonne.toString(), dExpected.toString());
	}
	
	@Test
	public void t_selection_un_ligne() {
		Colonne<Integer> c1 = new Colonne<Integer>("label1",Arrays.asList(1,2,3));
		Colonne<Integer> c2 = new Colonne<Integer>("label2",Arrays.asList(4,5,6));
		Colonne<Integer> c3 = new Colonne<Integer>("label3",Arrays.asList(7,8,9));
		Dataframe d1 = new Dataframe(c1,c2,c3);
		Dataframe copyLigne = d1.iloc(1);
		assertEquals(copyLigne.toString(), "[ label1[2] label2[5] label3[8] ]");
	}
	
	public void t_selection_plusieurs_ligne() {
		Colonne<Integer> c1 = new Colonne<Integer>("label1",Arrays.asList(1,2,3,4,5));
		Colonne<Integer> c2 = new Colonne<Integer>("label2",Arrays.asList(6,7,8,9,10));
		Colonne<Integer> c3 = new Colonne<Integer>("label3",Arrays.asList(11,12,13,14,15));
		Dataframe d1 = new Dataframe(c1,c2,c3);
		Dataframe copyLigne = d1.iloc(1,3);
		assertEquals(copyLigne.toString(), "[ label1[2,3,4] label2[7,8,9] label3[12,13,14] ]");
	}
}
