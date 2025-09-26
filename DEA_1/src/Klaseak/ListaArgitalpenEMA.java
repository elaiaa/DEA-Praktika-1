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
		}
		public void ezabatuArgitalpen(String pKodea) {
			boolean aurki=aurkituArgitalpen(pKodea);
			if(aurki) {ListaArgitalpen.remove(pKodea);}
		}
		
	}
