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
}
