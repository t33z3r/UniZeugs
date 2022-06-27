package frage6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BuchListe {
	
	//NOCH NICHT GANZ VOLLST�NDIG
	//etwaige Sonderf�lle noch nicht ber�cksichtigt
	
	//Erstellen der Hashmap f�r die Speicherung
	private static Map<String, String> books = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		//m�gliche Eingabe einer ISBN �ber die Kommandozeile	
		String buch = null;
		if (args.length != 0)
			buch = args[0];
		
		//Eintr�ge f�r Testb�cher erstellen
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
	
	
	//Methode f�r das Erg�nzen von B�chern in die Liste
	public static void ergaenzeBuch(String isbn, String title) {
		//Iterator f�r das Gegenpr�fen, ob sich der Eintrag bereits in der Liste befindet
		Iterator<Entry<String,String>> iterator = books.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> buch = iterator.next();
			if (buch.getKey().toString() == isbn)
				//Gew�nschte Meldung bei Dopplung
				System.out.println("bereits vorhanden");
		}		
		//Erg�nzung des Buchs zu der Liste -> wenn doppelt, dann passiert nichts
		books.put(isbn, title);
	}
	
	//Methode f�r die Ausgabe der B�cher
	public static void getBuch(String isbn) {
		//Iterator f�r das Suchen nach dem Name des Buchs mit der �bergebenen ISBN
		Iterator<Entry<String,String>> iterator = books.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> buch = iterator.next();
			if (buch.getKey() == isbn)	
				System.out.println(buch.getValue());			
		}
	}
	
	
	
	
}
