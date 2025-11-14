package Klaseak;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	@Before
	public void setUp() throws Exception {
		
		HashMap<String,Egile> egileak=ListaEgileEMA.getListaEgileEMA().getListaEgileMapa();
		Egile e1 = new Egile("Gaizka","3463");
		Egile e2 = new Egile("Elaia","2345");
		Egile e3 = new Egile("Usune","9367");
		Egile e4 = new Egile("Malen","3662");
		Egile e5 = new Egile("Eneko","8711");
		
		Argitalpen a1 = new Argitalpen("666","La Biblia");
		Argitalpen a2 = new Argitalpen("543","El Castillo Ambulante");
		Argitalpen a3 = new Argitalpen("932","Hunger Games");
		Argitalpen a4 = new Argitalpen("295","Metamorfosis");
		Argitalpen a5 = new Argitalpen("203","Biografia de J.A.");
		
		egileak.put(e1.getkodea(),e1);
		egileak.put(e2.getkodea(),e2);
		egileak.put(e3.getkodea(),e3);
		egileak.put(e4.getkodea(),e4);
		egileak.put(e5.getkodea(),e5);
		
		e1.gehituArgitalpen(a1.getKodea(), a1);
		e1.gehituArgitalpen(a2.getKodea(), a2);
		e1.gehituArgitalpen(a3.getKodea(), a3);
		e1.gehituArgitalpen(a4.getKodea(), a4);
		
		e2.gehituArgitalpen(a1.getKodea(), a1);
		e2.gehituArgitalpen(a2.getKodea(), a2);
		
		e3.gehituArgitalpen(a2.getKodea(), a2);
		e3.gehituArgitalpen(a4.getKodea(), a4);
		
		e4.gehituArgitalpen(a3.getKodea(), a3);
		
		e5.gehituArgitalpen(a5.getKodea(), a5);
		
		a1.gehituEgile(e1.getkodea(), e1);
		a1.gehituEgile(e2.getkodea(), e2);
		
		a2.gehituEgile(e1.getkodea(), e1);
		a2.gehituEgile(e2.getkodea(), e2);
		a2.gehituEgile(e3.getkodea(), e3);
		
		a3.gehituEgile(e1.getkodea(), e1);
		a3.gehituEgile(e4.getkodea(), e4);
		
		a4.gehituEgile(e1.getkodea(), e1);
		a4.gehituEgile(e3.getkodea(), e3);
		
		a5.gehituEgile(e5.getkodea(), e5);
		
		
		
	
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		Graph grafoa = new Graph();
		grafoa.grafoaSortu(ListaEgileEMA.getListaEgileEMA());
		grafoa.print();
		
		System.out.println(" ");
		
		System.out.println("Erlazionatuta?");
		String iz1 = "";
		String iz2 = "";
		boolean erl = grafoa.erlazionatutaBoolean(iz1, iz2);
		System.out.println(erl);
	}

}

