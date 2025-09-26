

import java.util.ArrayList;
import java.util.Iterator;

public class Egile {
	private String izena;
	private String kodea;
	private ArrayList<Argitalpen> argitalpenak;
	
	public Egile(String pIzena, String pKodea) {
		super();
		this.izena = pIzena;
		this.kodea = pKodea;
		this.argitalpenak = new ArrayList<Argitalpen>();
		
	}
	 private Iterator<Argitalpen> getIterator(){
		 return this.argitalpenak.iterator();
	 }
	 
	//Egile bat emanda (identifikatzailea), bueltatu bere argitalpenak
	public void getEgilearenArgitalpenak(Egile pEgile){
		Iterator<Argitalpen> itr=this.getIterator();
		while(itr.hasNext()) {
			Argitalpen a=itr.next();
			System.out.println(a.getTitulua());
		}
		
		
	}

}
