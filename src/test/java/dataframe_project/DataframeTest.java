package dataframe_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataframeTest {

	@Test 
	public void t_ConstrSimple() {
		int[] tab = new int[2];
		tab[0] = 2; tab[1] = 7;
		Dataframe d = new Dataframe(tab);
		assertEquals(d.getSize(), 1); //on doit avoir 1 seul colone dans datasize
		d = new Dataframe(tab, tab, tab);
		assertEquals(d.getSize(), 3); //on doit avoir 3 colones dans datasize
		
	}

}
