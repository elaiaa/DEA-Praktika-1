package Klaseak;

import java.util.HashMap;
import java.util.Iterator;

public class Argitalpen {
	private String kodea;
	private String titulu;
	private HashMap<String, Egile> listaegile;
	private HashMap<String, Argitalpen> listaargitalpen;
	
	public Argitalpen(String pKod, String pTit) {
		this.kodea=pKod;
		this.titulu=pTit;
		this.listaargitalpen=new HashMap<String,Argitalpen>();
		this.listaegile=new HashMap<String,Egile>();
	}
	
}
	


