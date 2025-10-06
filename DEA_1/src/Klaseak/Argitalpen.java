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

	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/
	public void gehituEgile(String pKodea, Egile pEgile) {
		this.listaegile.put(pKodea, pEgile);
	}
	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	

	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public String getTitulu() {
		return titulu;
	}

	public void setTitulu(String titulu) {
		this.titulu = titulu;
	}

	public HashMap<String, Egile> getListaegile() {
		return listaegile;
	}

	public void setListaegile(HashMap<String, Egile> listaegile) {
		this.listaegile = listaegile;
	}

	public HashMap<String, Argitalpen> getListaargitalpen() {
		return listaargitalpen;
	}

	public void setListaargitalpen(HashMap<String, Argitalpen> listaargitalpen) {
		this.listaargitalpen = listaargitalpen;
	}
	/////////////ELAIA///////////////////////////////////
	
	public void gehituEgile(Egile e) {
		if(!listaegile.containsKey(e)) {
		this.listaegile.put(e.getkodea(), e);}
	}
	
	
	/////////////ELAIA-END//////////////////////////////////////
	///////////////GAIZKA///////////////////
	public void aipamenaGehitu(String pKodeZein) {
		Argitalpen a= ListaArgitalpenEMA.getListaArgitalpenEMA().argitalpenaBilatu(pKodeZein);
		if(listaargitalpen.containsKey(pKodeZein)) {}
		else {
			this.listaargitalpen.put(pKodeZein, a);
		}
	}
	///////////////GAIZKA-END///////////////
}
	







