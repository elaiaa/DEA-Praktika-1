package Klaseak;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

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
	
	//FITXATEGIEN KUDEAKETA
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
			System.out.println("Errorea gertatu da, ezin da fitxategia aurkitu");
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
	
	//METODOAK
		public boolean aurkituArgitalpen(String pKodea) {
			return ListaArgitalpen.containsKey(pKodea);
		}
		
		public Argitalpen argitalpenaBilatu(String pKodea) {
			boolean aurki=ListaArgitalpen.containsKey(pKodea);
			if(aurki) {
				return ListaArgitalpen.get(pKodea);
			}
			else {
				System.out.println("Ez da argitalpenik aurkitu");
				return null;
			}
		}
		
		public void erakutsiAipamenak(String kodea) {
		    Argitalpen a = this.argitalpenaBilatu(kodea);
		    if (a != null) {
		        HashMap<String, Argitalpen> aipamenak = a.getListaargitalpen();
		        if (aipamenak.isEmpty()) {
		            System.out.println("Ez dago aipamenik argitalpen honentzat.");
		        } else {
		            System.out.println("Aipamenak:");
		            for (String kod : aipamenak.keySet()) {
		                Argitalpen aipamena = aipamenak.get(kod);
		                System.out.println("Kodea: " + kod + " - Izenburua: " + aipamena.getTitulu());
		            }
		        }
		    } else {
		        System.out.println("Ez da argitalpenik aurkitu kode honekin.");
		    }
		}
		
		public void egileakErakutsi(String kodea) {
		    Argitalpen a = this.argitalpenaBilatu(kodea);
		    
		    if (a != null) {
		        HashMap<String, Egile> egileak = a.getListaegile();
		        
		        if (egileak.isEmpty()) {
		            System.out.println("Ez daude egilerik argitalpen honentzat.");
		        } else {
		            System.out.println("Egileak:");
		            for (String kod : egileak.keySet()) {
		                Egile egilea = egileak.get(kod);
		                System.out.println("Kodea: " + kod + " - Izena: " + egilea.getIzena());
		            }
		        }
		    } else {
		        System.out.println("Ez da argitalpenik aurkitu kode honekin.");
		    }
		}
		
		public boolean gehituEgileArgitalpenari(String kodeArgitalpen, String kodeEgile) {
			boolean erantzuna= false;
			Egile e= ListaEgileEMA.getListaEgileEMA().getEgile(kodeEgile);
			if (e != null) {
				if(this.ListaArgitalpen.containsKey(kodeArgitalpen))
				{Argitalpen a= ListaArgitalpen.get(kodeArgitalpen);
				a.gehituEgile(e); erantzuna=true;
				} else {System.out.println("Ez da argitralpen hori existitzen!");}
			} else {System.out.println("Ez da egile hori existitzen!");}
			return erantzuna;
		}
		
		public void ezabatuArgitalpen(String pKodea) {
			boolean aurki=aurkituArgitalpen(pKodea);
			if(aurki) {
				ListaArgitalpen.remove(pKodea);
				System.out.println("Argitalpena ezabatu da!");
			} else {System.out.println("Ez da argitalpena aurkitu!");;}
		}
		public boolean gehituArgitalpen(String pKod, String pTit) {
			boolean erantzuna;
			Argitalpen a= new Argitalpen(pKod, pTit);
			if(ListaArgitalpen.containsKey(pKod)) {
				System.out.println("Existitzen da argitalpena jada!");
				erantzuna = false;
			}else {
				ListaArgitalpen.put(pKod, a);
				erantzuna = true;
			}
			return erantzuna;
		}
		
		public void erakutsiGuztiak() {
			for (Map.Entry<String, Argitalpen> entrada : this.ListaArgitalpen.entrySet()) {
		        System.out.println("Kodea: " + entrada.getKey() + " | " + entrada.getValue());
		    }
		}
		
		public boolean aipamenaGehitu(String pKodNon, String pKonZein) {
			boolean eginda = false;
			Argitalpen a= argitalpenaBilatu(pKodNon);
			if (a!= null)  eginda = a.aipamenaGehitu(pKonZein);
			return eginda;
		}	
		
		public HashMap<String, Argitalpen> getListaArgitalpenMapa() {
		    return this.ListaArgitalpen;
		}
		
		public OrderedDoubleLinkedList<Argitalpen> argitalpenOrdenatuak(){
			OrderedDoubleLinkedList<Argitalpen> zerOrd = new OrderedDoubleLinkedList<Argitalpen>();
			for(Argitalpen i : ListaArgitalpen.values()) {
				zerOrd.add(i);
			}
			return zerOrd;
		}
	}
