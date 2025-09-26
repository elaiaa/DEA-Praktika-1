public class ListaEgileEMA {
	private ArrayList<Egile> ListaEgile;
	private static ListaEgileEMA nireListaEgileEMA=null;
	public static ListaEgileEMA getListaEgileEMA() {
		if(nireListaEgileEMA==null) {
			nireListaEgileEMA= new ListaEgileEMA();
		}
		return nireListaEgileEMA;
	}

}
