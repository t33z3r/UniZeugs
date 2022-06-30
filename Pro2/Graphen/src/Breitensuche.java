import java.util.ArrayList;

public class Breitensuche {
	
	/*
	 * Feld für besuchte Knoten
	 * von welchen Knoten aus wurde der neue Knoten erreicht
	 */
	
	private boolean[] marked;
	private int[] edgeTo;
	
	public Breitensuche(UnserGraph ug, int startknoten){
		marked = new boolean[ug.getAnzahlKnoten()];
		edgeTo = new int[ug.getAnzahlKnoten()];
		
		suche(ug,startknoten);
	}
	
	private void suche(UnserGraph ug, int aktuellerKnoten){
		/*
		 * Warteschlange enthält die Liste der "Wege" (Knoten), die 
		 * noch bearbeitet werden müssen
		 */
		ArrayList<Integer> warteschlange = new ArrayList<Integer>();
		/*
		 * Wo soll gestartet werden?
		 */
		warteschlange.add(aktuellerKnoten);
		/*
		 * aktueller Knoten wird besucht
		 */
		marked[aktuellerKnoten] = true;
		while(!warteschlange.isEmpty()){
			/*
			 * solange in der Warteschlange noch etwas ist, mache weiter
			 * hole den ersten Wert aus der Warteschlange
			 */
			int ersterKnotenInDerWarteschlange = warteschlange.remove(0);
			for (int nachbarKnoten : ug.getNachbarn(ersterKnotenInDerWarteschlange)){
				/*
				 * Lade alle Nachbarknoten vom ersten Knoten aus der Warteschlange
				 */
				if(!marked[nachbarKnoten]){
					/*
					 * Kann der Nachbarknoten benutzt werden?
					 */
					/*
					 * Der Nachbarknoten wurde über den ersten Knoten in der 
					 * Warteschlange besucht
					 */
					edgeTo[nachbarKnoten] = ersterKnotenInDerWarteschlange;
					/*
					 * Nachbarknoten als besucht markiert
					 */
					marked[nachbarKnoten] = true;
					/*
					 * neue Nachbarknoten ("Wege") der Warteschlange hinzufügen
					 */
					warteschlange.add(nachbarKnoten);
					
				}
			}
		}
	}
	
	public void gibWegAus(int start, int ziel){
		String erg = "->" + ziel;
		int aktuellerWert = ziel;
		/*
		 * solange Start nicht erreicht -> mach weiter
		 */
		while (aktuellerWert != start){
			/*
			 * hole den Knoten, über welchen der aktuelle Knoten erreicht wurde
			 */
			aktuellerWert = edgeTo[aktuellerWert];
			erg = "->" + aktuellerWert + erg;
		}
		System.out.println(erg);
	}

}
/*
 * gute Kollisionsfunktion
 * bessere Hashfunktion
 * F8
 * 
 * TreeSet natürliche Ordnung
 * HashSet durch Hashfunktion eingeordnet
 * keine doppelten Elemente
 * 
 * RAF FilePointer
 * 
 * Breitensuche findet den optimalen Weg, wenn er existiert
 * 
 * Tiefensuche findet einen Weg, wenn er existiert
 * 
 */
