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
		HashMap<String, Argitalpen> listaArgitalpen = new HashMap<>();
		File nireFitxategia = new File("publications-titles-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				Argitalpen arg = new Argitalpen(zatitu[0], zatitu[1]);
				listaArgitalpen.put(zatitu[0], arg);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
		this.ListaArgitalpen = listaArgitalpen;
		System.out.println(this.ListaArgitalpen);
	}
	
	public void getArgitalpenenEgileak() {
		File nireFitxategia = new File("publications-authors-all-final.txt");
		ListaEgileEMA egileEMA = ListaEgileEMA.getListaEgileEMA();
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String lineaOsoa = nireScanner.nextLine();
				String[] zatitu = lineaOsoa.split(" # ");
				for (String i : this.ListaArgitalpen.keySet()) {
					if (i.equals(zatitu[0])) {		//Argitalpen kodeak berdinak dira
						Egile eg = egileEMA.getEgile(zatitu[1]);	//Egilea aurkitu kodearekin
						this.ListaArgitalpen.get(i).gehituEgile(zatitu[1], eg);	//Argitalpenaren listaEgile HashMap-ean egilea gehitu
					}
				}
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin da fitxategia irakurri");
			e.printStackTrace();
		}
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
