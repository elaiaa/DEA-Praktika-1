package Klaseak;
import java.util.*;

public class ListaArgitalpenEMA {
	private HashMap<String, Argitalpen> ListaArgitalpen;
	private static ListaArgitalpenEMA nireArgitalpenEMA=null;
	private ListaArgitalpenEMA() {
		this.ListaArgitalpen=new HashMap<String, Argitalpen>();
	}
	public static ListaArgitalpenEMA getListaArgitalpenEMA() {
		if(nireArgitalpenEMA==null) {
			nireArgitalpenEMA= new ListaArgitalpenEMA();
		}
		return nireArgitalpenEMA;
	}
	
	//metodoak
		public boolean aurkituArgitalpen(String pKodea) {
			return ListaArgitalpen.containsKey(pKodea);
		}
		public Argitalpen argitalpenaBilatu(String pKodea) {
			boolean aurki=aurkituArgitalpen(pKodea);
			if(aurki) {
				return ListaArgitalpen.get(pKodea);
			}
			else {
				System.out.println("Ez da argitalpenik aurkitu");
				return null;
			}
		//////////////////ELAIA///////////////////////////////
		
		public HashMap<String, Argitalpen> argitalpenAipamenak(String kodea) {
			Argitalpen a= this.argitalpenaBilatu(kodea);
			return a.getListaargitalpen();
		}
		public HashMap<String, Egile> egileak(String kodea) {
			Argitalpen a= this.argitalpenaBilatu(kodea);
			return a.getListaegile();
		}
		public void gehituEgileArgitalpenari(String kodeArgitalpen, String kodeEgile) {
			Egile e= ListaEgileEMA.getListaEgileEMA().getEgile(kodeEgile);
			if(this.ListaArgitalpen.containsKey(kodeArgitalpen))
				{Argitalpen a= ListaArgitalpen.get(kodeArgitalpen);
				a.gehituEgile(e);}
		}
		/////////////////ELAIA-END//////////////////////////////////////////////////
		}
		public void ezabatuArgitalpen(String pKodea) {
			boolean aurki=aurkituArgitalpen(pKodea);
			if(aurki) {ListaArgitalpen.remove(pKodea);}
		}

		///////////////////////GAIZKA//////////////////////
		public void gehituArgitalpen(String pKod, String pTit) {
			Argitalpen a= new Argitalpen(pKod, pTit);
			ListaArgitalpen.put(pKod, a);
		}
		
		public void aipamenaGehitu(String pKodNon, String pKonZein) {
			Argitalpen a= argitalpenaBilatu(pKodNon);
			a.aipamenaGehitu(pKonZein);
		}
		/////////////////////GAIZKA-END////////////////////
		
	}
