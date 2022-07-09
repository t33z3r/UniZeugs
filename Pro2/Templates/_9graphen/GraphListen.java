package _9graphen;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphListen {
	
	public ArrayList<Integer>[] getAdj() {
		return adj;
	}

	public int getAnzahlKanten() {
		return anzahlKanten;
	}

	public int getAnzahlKnoten() {
		return anzahlKnoten;
	}

	//E-Edge
	private int anzahlKanten;
	//V-Vertex
	private int anzahlKnoten;
	
	private ArrayList<Integer>[] adj;
	
	public GraphListen(int anzahlKnoten) {
		this.anzahlKnoten = anzahlKnoten;
		this.anzahlKanten = 0;
		adj = new ArrayList[anzahlKnoten];
		for (int v = 0; v < anzahlKnoten; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	public GraphListen(String dateiname) {
		try {
			//Muss nicht extra geschlossen werden
			Scanner eingabe = new Scanner(new File(dateiname));
			//Lesen aus Datei
			anzahlKnoten = eingabe.nextInt();
			anzahlKanten = eingabe.nextInt();
			
			//Init ArrayList
			adj = new ArrayList[anzahlKnoten];
			
			for(int i = 0; i < anzahlKnoten; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			
			//Absicherung mit hasNextInt, falls falsch in Datei geschrieben wurde
			for (int i = 0; i < anzahlKanten && eingabe.hasNextInt(); i++) {
				int start = eingabe.nextInt();
				int ende = eingabe.nextInt();
				addKante(start, ende);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addKante(int start, int ende) {
		pruefeKnotenNr(start);
		pruefeKnotenNr(ende);
		adj[start].add(ende);
		//entfällt bei gerichteten Graphen
		adj[ende].add(start);
	}
	
	public void pruefeKnotenNr(int knoten) {
		if (knoten < 0 || knoten >= anzahlKnoten) {
			throw new IndexOutOfBoundsException("falscher Index");
		}
	}
	
	public ArrayList<Integer> getNachbarn(int knoten){
		pruefeKnotenNr(knoten);
		return adj[knoten];
	}
	
	//Anzahl der Kanten, die von einem Knoten abgehen
	public int getGrad(int knoten) {
		pruefeKnotenNr(knoten);
		//Achtung: Dopplungen dürfen in der ArrayList existieren
		return adj[knoten].size();
	}
	
	public String toString() {
		String erg = "";
		erg = erg + "Anzahl Kanten: " + anzahlKanten + "\nAnzahlKnoten: " + anzahlKnoten + "\n";
		for (int i = 0; i < anzahlKnoten; i++) {
			erg = erg + (i+1) + ":\t";
			for (int n : adj[i]) {
				erg = erg + (n+1) + "\t";
			}
			erg = erg + "\n";
		}
		return erg;
	}
	
	/*
	public static void main(String[] args) {
		GraphListen gl = new GraphListen(".\\graph2.txt");
		System.out.println(gl);
	}
	*/
	
}
