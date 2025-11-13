package Klaseak;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class ProgramaNagusia {

	private static ListaArgitalpenEMA argitalpenak = ListaArgitalpenEMA.getListaArgitalpenEMA();
	private static ListaEgileEMA egileak = ListaEgileEMA.getListaEgileEMA();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        
		int aukera = -1;

        datuakKargatu();

        do {
            // Menua erakutsi
            System.out.println("********************MENUA********************");
            System.out.println("* 1.  Argitalpen baten bilaketa");
            System.out.println("* 2.  Argitalpen berri bat txertatu");
            System.out.println("* 3.  Argitalpen bati aipamen bat gehitu");
            System.out.println("* 4.  Argitalpen bati egile bat gehitu");
            System.out.println("* 5.  Argitalpen baten aipamenak erakutsi");
            System.out.println("* 6.  Argitalpen baten egileak erakutsi");
            System.out.println("* 7.  Egile baten argitalpenak erakutsi");
            System.out.println("* 8.  Argitalpen bat ezabatu");
            System.out.println("* 9.  Egile bat ezabatu");
            System.out.println("* 10. - Datuak fitxategietan gorde");
            System.out.println("* 11. - Argitalpen zerrenda ordenatua erakutsi");
            System.out.println("* 0. Irten");
            System.out.print("Aukera: ");

            // Aukera irakurri
            if (sc.hasNextInt()) {
    		    aukera = sc.nextInt();
    		    sc.nextLine();
    		    if (aukera >= 0 && aukera <= 11) {
    		        System.out.println(aukera + ". aukera aukeratu duzu!");
    		    } else {
    		        System.out.println("❌ 0tik 11rako zenbaki bat aukeratu behar duzu!");
    		    }
    		} else {
    		    System.out.println("❌ Sarrera okerra. 1etik 8ra bitarteko zenbaki bat sartu behar duzu.");
    		    sc.next(); // limpiar el valor incorrecto
    		    sc.nextLine(); //limpiar scaner
    		}

            //Aukeraketa
            switch (aukera) {
                case 1:
                    algitalpenBilaketa();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 2:
                    algitalpenaTxertatu();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 3:
                    aipamenaGehitu();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 4:
                    egileaGehitu();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 5:
                    aipamenakErakutsi();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 6:
                    egileakErakutsi();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 7:
                    argitalpenakErakutsi();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 8:
                    argitalpenaEzabatu();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 9:
                    egileaEzabatu();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 10:
                    datuakFitxategianGorde();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 11:
                    argitalpenOrdenatuakErakutsi();
                    System.out.println(); // Linea en blanco para separar
                    esperarEnter();
                    break;
                case 0:
                    System.out.println("Programatik irtetzen...");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz!");
            }            
        } while (aukera != 0);
        sc.close();
    }       
	
	private static void argitalpenOrdenatuakErakutsi() {
		OrderedDoubleLinkedList<Argitalpen> a = ListaArgitalpenEMA.getListaArgitalpenEMA().argitalpenOrdenatuak();
		System.out.println("Argitalpenen zerrenda alfabetikoki ordenatua:");
		System.out.println("--------------------------------");
		Iterator<Argitalpen> itr = a.iterator();
		while(itr.hasNext()) {
			Argitalpen arg = itr.next();
			arg.printArgitalpen();
		}
		//for(int i=0;i<a.size(); i++) {
		//	a.get(i).printArgitalpen();
		//}
	}

	private static void argitalpenakErakutsi() {
		System.out.println("Sartu egilearen kodea: ");
		String kodea = sc.nextLine();
		egileak.argitalpenakErakutsi(kodea);	
	}

	private static void argitalpenaEzabatu() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String kodea = sc.nextLine();
		argitalpenak.ezabatuArgitalpen(kodea);	
	}

	private static void egileaEzabatu() {
		System.out.println("Sartu egilearen kodea: ");
		String kodea = sc.nextLine();
		egileak.removeEgile(kodea);
	}

	private static void datuakFitxategianGorde() {
		ArgitalpenenFitxategiaSortu("argitalpenakEguneratuta.txt",argitalpenak.getListaArgitalpenMapa());
		EgileenFitxategiaSortu("egileakEguneratuta.txt" , egileak.getListaEgileMapa());
	}

	
	private static void egileakErakutsi() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String a = sc.nextLine();
		argitalpenak.egileakErakutsi(a);
	}

	private static void aipamenakErakutsi() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String a = sc.nextLine();
		argitalpenak.erakutsiAipamenak(a);
	}

	private static void egileaGehitu() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String argitalpen = sc.nextLine();
		System.out.println("Sartu egilearen kodea: ");
		String egile = sc.nextLine();
		boolean eginda = argitalpenak.gehituEgileArgitalpenari(argitalpen, egile);
		if (eginda)System.out.println("Egilea gorde da!");
	}
	
	private static void aipamenaGehitu() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String kodea = sc.nextLine();
		System.out.println("Sartu aipamenaren kodea: ");
		String izenburua = sc.nextLine();
		boolean eginda = argitalpenak.aipamenaGehitu(kodea, izenburua);
		if (eginda) System.out.println("Aipamena gorde da!");
		else System.out.println("Aipamena ez da gorde!");
	}

	private static void algitalpenaTxertatu() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String kodea = sc.nextLine();
		System.out.println("Sartu argitalpenaren izenburua: ");
		String izenburua = sc.nextLine();
		boolean eginda = argitalpenak.gehituArgitalpen(kodea, izenburua);
		if (eginda) System.out.println("Gehitu da algitalpena!");
		else System.out.println("Ezin izan da argitalpena gehitu!");	
	}
	
	private static void algitalpenBilaketa() {
		System.out.println("Sartu argitalpenaren kodea: ");
		String kodea = sc.nextLine();
		Argitalpen bilatua = argitalpenak.argitalpenaBilatu(kodea);
		if (bilatua != null) System.out.println("Izenburua: "+ bilatua.getTitulu());
	}

	private static void datuakKargatu() {
		egileak.getListaEgile();
		argitalpenak.getListaArgitalpen();
		argitalpenak.getArgitalpenenEgileak();
		argitalpenak.getArgitalpenenArgitalpenak();
	}
	
	private static void esperarEnter() {
	    System.out.println(" Sakatu Enter jarraitzeko...");
	    sc.nextLine();
	}
	
	private static void ArgitalpenenFitxategiaSortu(String fitxategiIzena, HashMap<String, Argitalpen> map) {
	    try {
	        PrintWriter writer = new PrintWriter(fitxategiIzena, "UTF-8");
	        for (Entry<String, Argitalpen> entry : map.entrySet()) {
	            writer.println(entry.getKey() + " # " + entry.getValue());
	        }
	        writer.close();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void EgileenFitxategiaSortu(String fitxategiIzena, HashMap<String, Egile> map) {
	    try {
	        PrintWriter writer = new PrintWriter(fitxategiIzena, "UTF-8");
	        for (Entry<String, Egile> entry : map.entrySet()) {
	            writer.println(entry.getKey() + " # " + entry.getValue());
	        }
	        writer.close();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}

