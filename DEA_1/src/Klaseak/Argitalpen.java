package Klaseak;
import java.util.ArrayList;
import java.util.Iterator;

public class Argitalpen {
	private String kodea;
	private String titulu;
	private ArrayList<Egile> listaegile;
	private ArrayList<Argitalpen> listaargitalpen;
	
	public Argitalpen(String pKod, String pTit) {
		this.kodea=pKod;
		this.titulu=pTit;
		this.listaargitalpen=new ArrayList<Argitalpen>();
		this.listaegile=new ArrayList<Egile>();
	}
	
	private Iterator<Argitalpen> getIteratorA(){
		return this.listaargitalpen.iterator();
	}
	private Iterator<Egile> getIteratorE(){
		return this.listaegile.iterator();
	}
	
}
	

