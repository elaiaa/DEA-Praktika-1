import java.util.ArrayList;
import java.util.HashMap;
/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	
public class ListaEgileEMA {
	private HashMap<String,Egile> ListaEgile;
	private static ListaEgileEMA nireListaEgileEMA=null;
	private ListaEgileEMA() {
		this.ListaEgile = new  HashMap<String,Egile>();
	}
	public static ListaEgileEMA getListaEgileEMA() {
		if(nireListaEgileEMA==null) {
			nireListaEgileEMA= new ListaEgileEMA();
		}
		return nireListaEgileEMA;
	}
	
	
	public void getListaEgile() {
		File nireFitxategia = new File("authors-name-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				Egile eg = new Egile(zatitu[1], zatitu[0]);
				this.ListaEgile.put(zatitu[0], eg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
	}
	
	public Egile getEgile(String pKodea) {
		Egile eg = this.ListaEgile.get(pKodea);
		return eg;
	}
	
	public void getEgileenArgitalpenak() {
		File nireFitxategia = new File("publications-authors-all-final.txt");
		ListaArgitalpenEMA argEMA = ListaArgitalpenEMA.getListaArgitalpenEMA();
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				String argKode = zatitu[0];
				String egiKode = zatitu[1];
				Argitalpen arg = argEMA.getArgitalpen(argKode);
				this.ListaEgile.get(egiKode).gehituArgitalpen(argKode, arg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
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
