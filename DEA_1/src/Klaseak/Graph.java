package Klaseak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
      HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
	
	public void grafoaSortu(ListaEgileEMA lista){
            // 1. pausua:  th� bete
            // KODEA INPLEMENTATU
		th = new HashMap<String,Integer>();
		Egile[] egileak = new Egile[lista.getListaEgileMapa().size()];/// gero erabiltzeko
		int kont = 0;
		for(Egile e: lista.getListaEgileMapa().values()) {
			th.put(e.getIzena(), kont);
			egileak[kont] = e;
			kont++;
		}
		kont=0;
	
            // 2. pausua: keys� bete
		keys = new String[th.size()];
		for (String iz: th.keySet()) {
			keys[th.get(iz)] = iz;
		}

 	    // 3. pausua: adjList� bete
            // KODEA INPLEMENTATU           
		adjList = (ArrayList<Integer>[])new ArrayList[keys.length];
		for(int i=0;i<adjList.length;i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		boolean[] daude;
		for(int i=0; i<egileak.length;i++) {			
			Egile e = egileak[i];
			int unekoId = th.get(e.getIzena());
			daude = new boolean[egileak.length];
			daude[unekoId] = true;
			UnorderedDoubleLinkedList<Argitalpen> argitalpenak = e.getListaargitalpen();
			Iterator<Argitalpen> itr = argitalpenak.iterator();
    		while(itr.hasNext()) {
    			Argitalpen a = itr.next();
    			HashMap<String, Egile> egilezer = a.getListaegile();
    			for(Egile eg: egilezer.values()) {
    				String izena = eg.getIzena();
    				int id = th.get(izena);
    				if(!daude[id]) {
    					adjList[unekoId].add(id);
    					daude[id] = true;
    				}
    			}
    		}
		}
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean erlazionatuta(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];

                 // KODEA INPLEMENTATU    
		
		return aurkitua;

	}

	public ArrayList<String> erlazionatutaBidea(String a1, String a2){
		    // KODEA INPLEMENTATU    
		ArrayList<String> bidea = new ArrayList<String>();
		return bidea;

	}

}
