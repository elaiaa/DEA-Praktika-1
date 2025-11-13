package Klaseak;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ListaEgileEMA {
	private HashMap<String,Egile> ListaEgile;
	private ListaEgileEMA() {ListaEgile = new HashMap<String, Egile>();}
	private static ListaEgileEMA nireListaEgileEMA=null;
	
	public static ListaEgileEMA getListaEgileEMA() {
		if(nireListaEgileEMA==null) {
			nireListaEgileEMA= new ListaEgileEMA();
		}
		return nireListaEgileEMA;
	}
	
	//FITXATEGIEN KUDEAKETA
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
	//METODOAK
	public void argitalpenakErakutsi(String kodea) {
	    Egile e = this.getEgile(kodea);
	    if (e != null) {
	    	UnorderedDoubleLinkedList<Argitalpen> argitalpenak = e.getListaargitalpen();
	        
	        if (argitalpenak.isEmpty()) {
	            System.out.println("Ez daude argitalpenik egile honentzat.");
	        } else {
	            System.out.println("Argitalpenak:");
	            Iterator<Argitalpen> itr = argitalpenak.iterator();
	    		while(itr.hasNext()) {
	    			Argitalpen a = itr.next();
	    			System.out.println("Kodea: " + a.getKodea() + " - Izenburua: " + a.getTitulu());
	    		}
	        }
	    } else {
	        System.out.println("Ez da egilerik aurkitu kode honekin.");
	    }
	}
	
	public boolean badagoEgilea(String bilatzekoKodea) {
		if(ListaEgile.containsKey(bilatzekoKodea)) {
			return true;
		}
		else {return false;}
	}
	
	public void removeEgile(String pEgile) {
		if(nireListaEgileEMA.badagoEgilea(pEgile)) {
			ListaEgile.remove(pEgile);
			System.out.println("Egilea ezabatu da!");
		} else {
			System.out.println("Ez da egilea aurkitu!");
		}
	}
	
	public boolean aurkitutaEgile(String pEgile) {
		return (ListaEgile.containsKey(pEgile));

	}
	
	public Egile getEgile(String kodea) {
		if(this.badagoEgilea(kodea)) {
			return ListaEgile.get(kodea);
		}
		else {return null;}
		
	}
	
	public void erakutsiGuztiak() {
		for (Map.Entry<String, Egile> entrada : this.ListaEgile.entrySet()) {
	        System.out.println("Kodea: " + entrada.getKey() + " | " + entrada.getValue());
	    }
	}
	
	public HashMap<String, Egile> getListaEgileMapa() {
	    return this.ListaEgile;
	}
	
	
}
