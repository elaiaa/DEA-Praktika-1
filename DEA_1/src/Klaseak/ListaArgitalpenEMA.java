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

	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	
	public void getListaArgitalpen() {
		File nireFitxategia = new File("publications-titles-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				Argitalpen arg = new Argitalpen(zatitu[0], zatitu[1]);
				this.ListaArgitalpen.put(zatitu[0], arg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia aurkitu");
			e.printStackTrace();
		}
	}
	
	public void getArgitalpenenEgileak() {
		File nireFitxategia = new File("publications-authors-all-final.txt");
		ListaEgileEMA egileEMA = ListaEgileEMA.getListaEgileEMA();
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				String argKode = zatitu[0];
				String egiKode = zatitu[1];
				Egile egi = egileEMA.getEgile(egiKode);
				this.ListaArgitalpen.get(argKode).gehituEgile(egiKode, egi);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
	}
	
	public void getArgitalpenenArgitalpenak() {
		File nireFitxategia = new File("publications-citedPubs-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				String arg1Kode = zatitu[0];
				String arg2Kode = zatitu[1];
				Argitalpen arg = this.ListaArgitalpen.get(arg2Kode);
				this.ListaArgitalpen.get(arg1Kode).gehituArgitalpen(arg2Kode, arg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
		
		
	}
	public Argitalpen getArgitalpen(String pKodea) {
		return this.ListaArgitalpen.get(pKodea);
	}
	/*************************USUNE FITXATEGIEN KUDEAKETA***************************/	

	
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
			if(ListaArgitalpen.containsKey(pKod)) {}
			else {
				ListaArgitalpen.put(pKod, a);
			}
		}
		
		public void aipamenaGehitu(String pKodNon, String pKonZein) {
			Argitalpen a= argitalpenaBilatu(pKodNon);
			a.aipamenaGehitu(pKonZein);
		}
	/////////////////////GAIZKA-END////////////////////
		
	}
