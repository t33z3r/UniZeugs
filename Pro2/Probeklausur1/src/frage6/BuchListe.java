package frage6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BuchListe {
	
	//NOCH NICHT GANZ VOLLSTÄNDIG
	//etwaige Sonderfälle noch nicht berücksichtigt
	
	//Erstellen der Hashmap für die Speicherung
	private static Map<String, String> books = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		//mögliche Eingabe einer ISBN über die Kommandozeile	
		String buch = null;
		if (args.length != 0)
			buch = args[0];
		
		//Einträge für Testbücher erstellen
		ergaenzeBuch("0000", "Test1");
		ergaenzeBuch("0000", "Test1");
		ergaenzeBuch("0001", "Test2");
		
		//Ausgabe der Titel
		getBuch("0000");
		getBuch("0001");
		getBuch("0002");
		
		//Ausgabe der eingegebenen ISBN
		if (buch != null)
			getBuch(buch);
		}
	
	
	//Methode für das Ergänzen von Büchern in die Liste
	public static void ergaenzeBuch(String isbn, String title) {
		//Iterator für das Gegenprüfen, ob sich der Eintrag bereits in der Liste befindet
		Iterator<Entry<String,String>> iterator = books.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> buch = iterator.next();
			if (buch.getKey().toString() == isbn)
				//Gewünschte Meldung bei Dopplung
				System.out.println("bereits vorhanden");
		}		
		//Ergänzung des Buchs zu der Liste -> wenn doppelt, dann passiert nichts
		books.put(isbn, title);
	}
	
	//Methode für die Ausgabe der Bücher
	public static void getBuch(String isbn) {
		//Iterator für das Suchen nach dem Name des Buchs mit der übergebenen ISBN
		Iterator<Entry<String,String>> iterator = books.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> buch = iterator.next();
			if (buch.getKey() == isbn)	
				System.out.println(buch.getValue());			
		}
	}
	
	
	
	
}
