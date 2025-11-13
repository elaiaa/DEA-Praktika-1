package Klaseak;

import java.util.HashMap;

public class Argitalpen implements Comparable<Argitalpen>{
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
	
	//FITXATEGIEN KUDEAKETA
	public void gehituEgile(String pKodea, Egile pEgile) {
		this.listaegile.put(pKodea, pEgile);
	}
	
	public void gehituArgitalpen(String pKodea, Argitalpen pArgitalpen) {
		this.listaargitalpen.put(pKodea, pArgitalpen);
	}
	
	//METODOAK
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
	
	public boolean gehituEgile(Egile e) {
		boolean erantzuna ;
		if(!listaegile.containsKey(e.getkodea())) {
			this.listaegile.put(e.getkodea(), e);
			erantzuna = true;
		}else {
			System.out.println("Egilea existitzen da jada!");
			erantzuna = false;
		}
		return erantzuna;
	}
	
	public boolean aipamenaGehitu(String pKodeZein) {
		boolean erantzuna;
		Argitalpen a= ListaArgitalpenEMA.getListaArgitalpenEMA().argitalpenaBilatu(pKodeZein);
		if(listaargitalpen.containsKey(pKodeZein)) {
			System.out.println("Aipamena existitzen da jada!");
			erantzuna = false;;
		}else {
			this.listaargitalpen.put(pKodeZein, a);
			erantzuna = true;
		}
		return erantzuna;
	}
	
	public void printArgitalpen() {
		System.out.println("Kodea: "+this.kodea);
		System.out.println("Izenburua: "+this.titulu);
		System.out.println("--------------------------------");
	}

	@Override
	public int compareTo(Argitalpen a) {
		return this.titulu.compareToIgnoreCase(a.titulu);
	}
}
	


