package Klaseak;

import java.util.Scanner;

public class ProgramaNagusia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int aukera;
        
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
            System.out.println("* 10. Datuak fitxategietan gorde");
            System.out.println("* 11. Argitalpen zerrenda ordenatua erakutsi");
            System.out.println("* 0. Irten");
            System.out.print("Aukera: ");

            // Aukera irakurri
            aukera = sc.nextInt();

            //Aukeraketa
            switch (aukera) {
                case 1:
                    System.out.println("1. aukera aukeratu duzu.");
                    algitalpenBilaketa();
                    break;
                case 2:
                    System.out.println("2. aukera aukeratu duzu.");
                    algitalpenaTxertatu();
                    break;
                case 3:
                    System.out.println("3. aukera aukeratu duzu.");
                    aipamenaGehitu();
                    break;
                case 4:
                    System.out.println("4. aukera aukeratu duzu.");
                    egileaGehitu();
                    break;
                case 5:
                    System.out.println("5. aukera aukeratu duzu.");
                    aipamenakErakutsi();
                    break;
                case 6:
                    System.out.println("6. aukera aukeratu duzu.");
                    egileakErakutsi();
                    break;
                case 7:
                    System.out.println("7. aukera aukeratu duzu.");
                    argitalpenakErakutsi();
                    break;
                case 8:
                    System.out.println("8. aukera aukeratu duzu.");
                    argitalpenaEzabatu();
                    break;
                case 9:
                    System.out.println("9. aukera aukeratu duzu.");
                    egileaEzabatu();
                    break;
                case 10:
                    System.out.println("10. aukera aukeratu duzu.");
                    datuakFitxategianGorde();
                    break;
                case 11:
                    System.out.println("11. aukera aukeratu duzu.");
                    argitalpenOrdenatuakErakutsi();
                    break;
                case 0:
                    System.out.println("Programatik irtetzen...");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz!");
            }

            System.out.println(); // Linea en blanco para separar

        } while (aukera != 0);

        sc.close();
    }

	private static void argitalpenOrdenatuakErakutsi() {
		// TODO Auto-generated method stub
		
	}

	private static void argitalpenakErakutsi() {
		// TODO Auto-generated method stub
		
	}

	private static void argitalpenaEzabatu() {
		// TODO Auto-generated method stub
		
	}

	private static void egileaEzabatu() {
		// TODO Auto-generated method stub
		
	}

	private static void datuakFitxategianGorde() {
		// TODO Auto-generated method stub
		
	}

	private static void egileakErakutsi() {
		// TODO Auto-generated method stub
		
	}

	private static void aipamenakErakutsi() {
		// TODO Auto-generated method stub
		
	}

	private static void egileaGehitu() {
		// TODO Auto-generated method stub
		
	}

	private static void aipamenaGehitu() {
		// TODO Auto-generated method stub
		
	}

	private static void algitalpenaTxertatu() {
		// TODO Auto-generated method stub
		
	}

	private static void algitalpenBilaketa() {
		// TODO Auto-generated method stub
		
	}

	private static void datuakKargatu() {
		// TODO Auto-generated method stub
		
	}

}
