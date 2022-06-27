package frage12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MeinGraph {
	
	//Implementierung der Variable
	private ArrayList<Kante> nachbarschaften;

	//Konstruktor
	public MeinGraph() {
		nachbarschaften = new ArrayList<Kante>();
	}
	
	//Methode zum HinzufÃ¼gen einer Kante
	public void addKante(int start, int ziel) {
		Kante k = new Kante(start, ziel);
		nachbarschaften.add(k);
		//Optionales Feedback auf der Kommandozeile
		System.out.println("Kante von " + start + " zu " + ziel + " hinzugefuegt.");
	}
	
	//Methode zur Ausgabe der Kantenanzahl
	public void getAnzahlKante() {
		System.out.println(Integer.toString(nachbarschaften.size()) + " Kanten sind derzeit im Graph enthalten.");
	}
	
	//Get-Methode für die Array-List
	public ArrayList<Kante> getNachbarschaften() {
		return nachbarschaften;	
	}
	
	//Methode für die Speicherung mittels Serializable
	//Ist bei dem Infomaterial vom Praktikum 6 SuD vorgegeben
	public void speichereNachbarschaften(String pfad) {
		ObjectOutputStream oos = null;
		try {
			//Verschachtelung des oos -> bos -> fos ermöglicht direkte Eingabe von einem String als Pfad
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pfad)));
			//Schreiben der Datei
			oos.writeObject(nachbarschaften);
			//leert den Stream
			oos.flush();
			//optionales Feedback an den User über die Kommandozeile
			System.out.println("Die Datei nachbarschaften wurde in " + pfad + " abgespeichert.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Methode für das Lesen aus der Datei
	//Auch im Dokument Serialisierung und Deserialisierung Praktikum 6 Ein- und Ausgabe zu finden
	public void ladeNachbarschaften(String pfad) {
		//Diesmal ein InputStream zum Auslesen
		ObjectInputStream ois = null;
		try {
			//Verschachtelung ermöglicht direkte Eingabe von einem String als Pfad
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pfad)));
			//Übergabe der Werte in die nachbarschaften-Variable
			nachbarschaften = (ArrayList<Kante>) ois.readObject();
			//optionales Feedback an den User über die Kommandozeile
			System.out.println("Es wurde aus der Datei " + pfad + " gelesen.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
