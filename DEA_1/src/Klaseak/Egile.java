package Klaseak;

public class Egile {
	private String izena;
	private String kodea;
	private ArrayList<Argitalpen> argitalpen;
	
	public Egile(String pIzena, String pKodea) {
		super();
		this.izena = pIzena;
		this.kodea = pKodea;
		this.argitalpen = new ArrayList<Argitalpen>();
		
	}
	 private Iterator<Argitalpen> getIterator(){
		 return this.argitalpen.iterator();
	 }
	
	

}
