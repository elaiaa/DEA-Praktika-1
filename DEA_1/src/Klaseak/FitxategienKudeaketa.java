package Klaseak;

import java.io.*;					
import java.util.Scanner;			//Scanner klasea


public class FitxategienKudeaketa {
public static void main(String[] args) {
	//System.out.println(new File("Hola.txt").getAbsolutePath());
	//File file = new File("Hola.txt");
	
	try {
		String dir = System.getProperty("user.dir");
		String path = dir + File.separator + "Hola.txt";
		Scanner sc = new Scanner(new FileReader(path));
		
		while (sc.hasNextLine()) {
			int i = sc.nextInt();
			System.out.println(i);
		}
		sc.close();
	
	} 
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
}
  
