package Klaseak;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaArgitalpenEMATest {

	@Before
	public void setUp() throws Exception {
	
		ListaArgitalpenEMA ListaArgitalpenORD= ListaArgitalpenEMA.getListaArgitalpenEMA();
		ListaArgitalpenORD.gehituArgitalpen("1", "Bad");
		ListaArgitalpenORD.gehituArgitalpen("2", "F");
		ListaArgitalpenORD.gehituArgitalpen("3", "C");
		ListaArgitalpenORD.gehituArgitalpen("4", "Ba");
		ListaArgitalpenORD.gehituArgitalpen("5", "Baa");
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		OrderedDoubleLinkedList<Argitalpen> a = ListaArgitalpenEMA.getListaArgitalpenEMA().argitalpenOrdenatuak();
		System.out.println("Argitalpenen zerrenda alfabetikoki ordenatua:");
		System.out.println("--------------------------------");
		Iterator<Argitalpen> itr = a.iterator();
		while(itr.hasNext()) {
			Argitalpen arg = itr.next();
			arg.printArgitalpen();
		}

	}

}
