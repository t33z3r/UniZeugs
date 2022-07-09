package _9breitenTiefenSuche;

public class Tiefensuche {

	/*
	 * Feld für besuchte Knoten
	 */
	private boolean[] marked;
	/*
	 * von welchen Knoten aus wurde der neue Knoten besucht
	 */
	private int[] edgeTo;
	
	public Tiefensuche(UnserGraph ug, int startknoten){
		marked = new boolean[ug.getAnzahlKnoten()];
		edgeTo = new int[ug.getAnzahlKnoten()];
		
		suche(ug, startknoten);
	}
	
	private void suche(UnserGraph ug, int aktuellerKnoten){
		/*
		 * Tiefensuche für jeden einzelnen Knoten
		 */
		marked[aktuellerKnoten] = true; 
		/*
		 * aktueller Knoten wird besucht
		 */
		for ( int knotenNachbar : ug.getNachbarn(aktuellerKnoten)){
			/*
			 * Lade jeden einzelnen Nachbarn des aktuellen Knoten und
			 * speichere in jeden Durchlauf einen dieser Nachbarn in
			 * der Variable knotenNachbar 
			 */
			if (!marked[knotenNachbar]){
				/*
				 * falls Nachbarknoten noch nicht besucht benutze diesen
				 */
				edgeTo[knotenNachbar] = aktuellerKnoten;
				/*
				 * der Nachbarknoten wurde über den aktuellen Knoten erreicht
				 */
				suche(ug,knotenNachbar);
			}
		}
	}
	
	public void gibWegAus(int start, int ziel){
		/*
		 * bei der Ausgabe eines Weges ist es günstiger vom Ziel -> Start
		 */
		String erg = "->" + ziel;
		int aktuellerWert = ziel;
		while(aktuellerWert != start){
			/*
			 * solange der Startwert noch nicht erreicht ist 
			 * -> mache weiter
			 */
			aktuellerWert = edgeTo[aktuellerWert];
			erg = "->" + aktuellerWert + erg;
		}
		
		System.out.println(erg);
	}
}
