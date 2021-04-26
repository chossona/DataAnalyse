package dataframe_project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DataframeTest {

	@Test 
	public void t_ConstrSimple_1() {
		Colonne c1 = new Colonne<Integer>(1,2,3);
		Dataframe d = new Dataframe(c1);
		assertEquals(d.getSize(), 1);//test controlleur1
	}
	@Test 
	public void t_ConstrSimple_2() {
		Colonne c1 = new Colonne<Integer>(1,2,3);
		Colonne c2  = new Colonne<Integer>(1,5,6,7,8);
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
		assertEquals("[[1,2,3,][1,5,6,7,8,][1,5,6,7,8,]]", d.toString());
	}
	
	@Test 
	public void t_affichage_str_int() {
		Colonne<Integer> c1 = new Colonne<Integer>(1,2,3);
		Colonne<Integer> c2  = new Colonne<Integer>(1,5,6,7,8);
		Colonne<String> c3  = new Colonne<String>("papa","a","tromper","maman");
		Dataframe d = new Dataframe(c1,c2,c3);
		assertEquals("[[1,2,3,][1,5,6,7,8,][papa,a,tromper,maman,]]", d.toString());
	}

}
