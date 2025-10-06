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

	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	
	public void getListaEgile() {
		HashMap<String, Egile> listaEgile = new HashMap<>();
		File nireFitxategia = new File("authors-name-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				Egile eg = new Egile(zatitu[1], zatitu[0]);
				listaEgile.put(zatitu[0], eg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
		this.ListaEgile = listaEgile;
	}
	
	public Egile getEgile(String pKodea) {
		Egile eg = this.ListaEgile.get(pKodea);
		return eg;
	}
	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	
	
	
	
	//Egile bat emanda (identifikatzailea), bueltatu bere argitalpenak
	public void getEgilearenArgitalpenak(Egile pEgile) {
		String bilatzekoKodea=pEgile.getkodea();
		if (this.aurkitutaEgile(pEgile)){
			Egile egilea=ListaEgile.get(bilatzekoKodea);
			egilea.getEgilearenArgitalpenak();
		}
	}
	
	public void removeEgile(String pEgile) {
		if(nireListaEgileEMA.badagoEgilea(pEgile)) {
			ListaEgile.remove(pEgile);
		}


	}
	public boolean badagoEgilea(String bilatzekoKodea) {
		if(ListaEgile.containsKey(bilatzekoKodea)) {
			return true;
		}
		else {return false;}
	}
	public Egile getEgile(String kodea) {
		if(this.badagoEgilea(kodea)) {
			return ListaEgile.get(kodea);
		}
		else {return null;}
		
	}

}
