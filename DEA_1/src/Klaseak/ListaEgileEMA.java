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
		if (ListaEgile.containsKey(bilatzekoKodea)){
			Egile egilea=ListaEgile.get(bilatzekoKodea);
			egilea.getEgilearenArgitalpenak();
		}
	}

}
