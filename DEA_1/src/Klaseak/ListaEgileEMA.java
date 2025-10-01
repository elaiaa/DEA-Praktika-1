package Klaseak;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaEgileEMA {
	private HashMap<String,Egile> ListaEgile;
	private ListaEgileEMA() {new  HashMap<String,Egile>();}
	private static ListaEgileEMA nireListaEgileEMA=null;
	public static ListaEgileEMA getListaEgileEMA() {
		if(nireListaEgileEMA==null) {
			nireListaEgileEMA= new ListaEgileEMA();
		}
		return nireListaEgileEMA;
	}
	
	
	
	//Egile bat emanda (identifikatzailea), bueltatu bere argitalpenak
	public void getEgilearenArgitalpenak(Egile pEgile) {
		String bilatzekoKodea=pEgile.getkodea();
		if (this.aurkitutaEgile(pEgile)){
			Egile egilea=ListaEgile.get(bilatzekoKodea);
			egilea.getEgilearenArgitalpenak();
		}
	}
	
	public void removeEgile(Egile pEgile) {
		if (this.aurkitutaEgile(pEgile)){ListaEgile.remove(pEgile.getkodea());}
		ListaEgile.remove(pEgile.getkodea());
	}
	public boolean aurkitutaEgile(Egile pEgile) {
		String bilatzekoKodea=pEgile.getkodea();
		if (ListaEgile.containsKey(bilatzekoKodea)) {
			return true;
		}
		else
		{return false;}
	}

}
