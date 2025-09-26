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
		public Argitalpen argitalpenaBilatu(String pKodea) {
			boolean aurki=getListaArgitalpenEMA().ListaArgitalpen.containsKey(pKodea);
			if(aurki) {
				return getListaArgitalpenEMA().ListaArgitalpen.get(pKodea);
			}
			else {
				System.out.println("Ez da argitalpenik aurkitu");
			}
			
		}
}
