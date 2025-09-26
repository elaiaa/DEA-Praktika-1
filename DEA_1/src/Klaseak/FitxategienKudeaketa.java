package Klaseak;

import java.io.*;					
import java.util.Scanner;			//Scanner klasea


public class FitxategienKudeaketa {
public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(new FileReader("authors-name-all.txt"));
		
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

  
