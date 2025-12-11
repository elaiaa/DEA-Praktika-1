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
		ArrayList<Egile> egileak = new ArrayList<Egile>();/// gero erabiltzeko
		for(Egile e: lista.getListaEgileMapa().values()) {
			if(!th.containsKey(e.getIzena())) {
				th.put(e.getIzena(),egileak.size() );
				egileak.add(e);
			}else {
				Egile original = egileak.get(th.get(e.getIzena()));
				UnorderedDoubleLinkedList<Argitalpen> eArg = e.getListaargitalpen();
				Iterator<Argitalpen> itr = eArg.iterator();
				while(itr.hasNext()) {
					Argitalpen a = itr.next();
					original.gehituArgitalpen(a.getKodea(), a);
				}
				
			}
		}
	
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
		for(int i=0; i<egileak.size();i++) {			
			Egile e = egileak.get(i);
			int unekoId = th.get(e.getIzena());
			daude = new boolean[egileak.size()];
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
	
	public boolean erlazionatutaBoolean(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
		
		if (!th.containsKey(a1) || !th.containsKey(a2)) 
			{aurkitua=false;}
		else {
			aztertuGabeak.add(pos1);
		    aztertuak[pos1] = true;
		    
		    while (!aztertuGabeak.isEmpty() && !aurkitua) {
		    	
		    	int unekoa = aztertuGabeak.remove();//hurrengoko egilea atera aztertzeko
		    	
		    	if (unekoa == pos2) {
		            aurkitua = true;}
		        else {
		        	for (int lagun : adjList[unekoa]) {//auzokideak aztertu
		                if (!aztertuak[lagun]) {//auzokide hau aztertuta ez badago
		                    aztertuak[lagun] = true;//aztertu bezala jarri
		                    aztertuGabeak.add(lagun);//eta aztertzeko listara gehitu gero aztertzeko
		            	}  
		        	}
		        	
		        }

		    }

		}
		return aurkitua;
	}
	public ArrayList<String> erlazionatutaBidea(String a1, String a2) {
	    if (a1.equals(a2)) {
	        ArrayList<String> b = new ArrayList<>();
	        b.add(a1);
	        return b;
	    }
	    if (!th.containsKey(a1) || !th.containsKey(a2)){
	        return null;
		}
	    int start = th.get(a1);
	    int goal = th.get(a2);
	    boolean[] visited = new boolean[adjList.length];
	    int[] parent = new int[adjList.length];   // para reconstruir el camino
	    Arrays.fill(parent, -1);
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(start);
	    visited[start] = true;
	    boolean found = false;
	    while (!queue.isEmpty()) {
	        int current = queue.poll();
	        if (current == goal) {
	            found = true;
	            break;
	        }
	        for (int neighbor : adjList[current]) {
	            if (!visited[neighbor]) {
	                visited[neighbor] = true;
	                parent[neighbor] = current;
	                queue.add(neighbor);
	            }
	        }
	    }
	    if (!found) return null;
		ArrayList<String> path = new ArrayList<>();
	    int curr = goal;
	    while (curr != -1) {
	        path.add(keys[curr]);
	        curr = parent[curr];
	    }
	    Collections.reverse(path);
	    return path;
	}

	public HashMap<String, Double> randomWalkPageRank(){
		Random r = new Random();
		int n = keys.length;
		long kop = 0;
		HashMap<String, Double> emaitza = new HashMap<String, Double>();
		for (String izena : keys) {     
		    emaitza.put(izena, 0.0);    
		}
		int IBILBIDEAK = 10;
		for(int i = 0; i<IBILBIDEAK ; i++) {
			boolean[] aztertuak = new boolean[n];
			boolean buk = false;
			//lehenengoa aukeratu 
			int unekoa = r.nextInt(n);
			//aztertua markatu
			aztertuak[unekoa]=true;
			//kontadorea gehitu
			String izena = keys[unekoa];               
	        emaitza.put(izena, emaitza.get(izena) + 1);
	        kop++;
	        //iterazioak hasi
			while(!buk) {
				int x= r.nextInt(100);
				if(x < 85) {
					int irteeraKop = adjList[unekoa].size();
					if (irteeraKop>0) {
						int idxnext = r.nextInt(irteeraKop);
						int next = adjList[unekoa].get(idxnext);
						if (!aztertuak[next]) {
							unekoa = next;
							//aztertua markatu
							aztertuak[unekoa]=true;
							//kontadorea gehitu
							String iz = keys[unekoa];               
					        emaitza.put(iz, emaitza.get(iz) + 1);
					        kop++;
						} else {
							buk = true;
						}
					} else {
						buk = true;
					}
				} else {
					buk = true;
				}
			}
		}
		//balioak normalizatu
		for (String name : keys) {
            double v = emaitza.get(name);
            emaitza.put(name, v / (double)kop);
        }
		return emaitza;
	}
}













