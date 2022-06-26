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
	
	//NOCH UNFERTIG!!!!
	//KOMMENTARE UND TESTS STEHEN NOCH AUS!!!!
	//TESTER-KLASSE FEHLT AUCH NOCH!!!
	//Das wird in der nächsten Woche nachgeholt ;)
	
	private ArrayList<Kante> nachbarschaften;

	public MeinGraph() {
		nachbarschaften = new ArrayList<Kante>();
	}
	
	public void addKante(int start, int ziel) {
		Kante k = new Kante(start, ziel);
		nachbarschaften.add(k);
	}
	
	public int getAnzahlKante() {
		return nachbarschaften.size();
	}
	
	public ArrayList<Kante> getNachbarschaften() {
		return nachbarschaften;	
	}
	
	public void speichereNachbarschaften(String pfad) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pfad)));
			oos.writeObject(nachbarschaften);
			oos.flush();
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
	
	public void ladeNachbarschaften(String pfad) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pfad)));
			nachbarschaften = (ArrayList<Kante>) ois.readObject();
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
