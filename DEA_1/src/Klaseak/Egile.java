package Klaseak;


import java.util.HashMap;


public class Egile {
	private String izena;
	private String kodea;
	private HashMap<String, Argitalpen> argitalpenak;
	
	public Egile(String pIzena, String pKodea) {
		super();
		this.izena = pIzena;
		this.kodea = pKodea;
		this.argitalpenak = new HashMap<String, Argitalpen>();
		
	}
	
	 
	//Egile bat emanda (identifikatzailea), bueltatu bere argitalpenak
	public void getEgilearenArgitalpenak(){
		for (Argitalpen i : argitalpenak.values()) {
			  System.out.println(i.getTitulu());
			}
	}

	public String getkodea() {return this.kodea;}
}
