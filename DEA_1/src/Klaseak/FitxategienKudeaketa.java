package Klaseak;

import java.io.*;					
import java.util.Scanner;

public class FitxategienKudeaketa {
	public static void main(String[] arg) {
		File nireFitxategia = new File("authors-name-all.txt");
		
		try (Scanner nireScanner = new Scanner(nireFitxategia)) {
			while (nireScanner.hasNextLine()) {
				String datua = nireScanner.nextLine();
				System.out.println(datua);
			}
			nireScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errorea gertatu da, ezin daitezte fitxategiak irakurri");
			e.printStackTrace();
		}
	}
	public void fitxategiaSortu(String fALdatutakoFItxategiak, String[] lerroak) {
		// Post: fIzena izeneko fitxategian idatzi dira lerroak
		  try {
		    PrintWriter writer = new PrintWriter(fALdatutakoFItxategiak, "UTF-8");
		    for (String lerro: lerroak) {
		      writer.println(lerro);
		    }
		    writer.close();
		  } 
		  catch (IOException e) {
		    e.printStackTrace();
		  }
		}


	
}
  
