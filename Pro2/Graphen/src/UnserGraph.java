
import java.util.ArrayList;
import java.util.HashSet;

public class UnserGraph {
	
	private int anzahlKnoten;
	private ArrayList<HashSet<Integer>> nachbarliste;
	
	public UnserGraph(int anzahlKnoten) {
		this.anzahlKnoten = anzahlKnoten;
		nachbarliste = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < anzahlKnoten;i++) {
			nachbarliste.add(new HashSet<Integer>());
		}
		//Basis init.:
		//Knoten viele Zeilen mit:
		//je Zeile ein leeres Set
	}
	
	public boolean addKante(int knotenVon, int knotenNach) {
		if(knotenVon < 0 || knotenNach < 0 
				|| knotenVon >= anzahlKnoten || knotenNach >= anzahlKnoten ) {
			return false; //Knoten von / nach sind nicht in der Liste
		}
		
		nachbarliste.get(knotenVon).add(knotenNach);//von - nach eintragen
		nachbarliste.get(knotenNach).add(knotenVon);//entfaellt bei gerichteten Graph
		return true;
	}
	
	public void gibAus() {
		System.out.println("Liste:");
		System.out.println("Anzahl der Knoten: "+ anzahlKnoten);
		for(int i = 0; i < anzahlKnoten; i++) {
			System.out.print("Knoten:" + i);
			for(int j : nachbarliste.get(i)) {
				System.out.print("\t "+j+ " ");
			}
			System.out.println();
		}
	}
	
	public int getAnzahlKnoten() {
		return anzahlKnoten;
	}
	
	public HashSet<Integer> getNachbarn(int knoten){
		return nachbarliste.get(knoten);
	}

}
