package Klaseak;


import java.util.HashMap;
import java.util.Iterator;


public class Egile implements Comparable<Egile>{
	private String izena;
	private String kodea;
	private UnorderedDoubleLinkedList<Argitalpen> argitalpenak;
	
	public Egile(String pIzena, String pKodea) {
		super();
		this.izena = pIzena;
		this.kodea = pKodea;
		this.argitalpenak = new UnorderedDoubleLinkedList<Argitalpen>();
		
	}
	
	//FITXATEGIEN KUDEAKETA
	public void gehituArgitalpen(String pKodea, Argitalpen pArgitalpen) {
		this.argitalpenak.addToRear(pArgitalpen);
	}
	
	//METODOAK
	public UnorderedDoubleLinkedList<Argitalpen> getListaargitalpen() {
		return argitalpenak;
	}

	public void setListaargitalpen(UnorderedDoubleLinkedList<Argitalpen> listaargitalpen) {
		this.argitalpenak = listaargitalpen;
	}
	
	public void getEgilearenArgitalpenak(){
		Iterator<Argitalpen> itr = argitalpenak.iterator();
		while(itr.hasNext()) {
			Argitalpen a = itr.next();
			System.out.println(a.getTitulu());
		}
	}

	public String getkodea() {return this.kodea;}
	
	public String getIzena() {return this.izena;}

	@Override
	public int compareTo(Egile e) {
		return this.izena.compareToIgnoreCase(e.izena);
	}

}
