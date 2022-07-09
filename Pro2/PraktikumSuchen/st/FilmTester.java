package st;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilmTester {
	
	public String getName() {
		return name;
	}

	public String getJahr() {
		return jahr;
	}

	public ArrayList<String> getSp() {
		return sp;
	}

	private String name;
	private String jahr;
	private ArrayList<String> sp;
	private static ArrayList<FilmTester> filme;

	public static void main(String[] args) {
		filme = new ArrayList<FilmTester>();
		leseFilmEin();
		search("2002");	
	}
	
	public static void search(String j) {
		for (FilmTester f : filme) {
			if (f.getJahr().equals(j)) {
				System.out.println(f);
			}
		}
	}
	
	public static void leseFilmEin() {
		Path pfad = Paths.get(".\\filme.txt");
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(pfad);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("/");
				if (data.length >= 2) {
					String n = data[0].substring(0, data[0].indexOf("(")); 
					String j = data[0].substring(data[0].indexOf("(")+1, data[0].indexOf(")"));
					FilmTester f = new FilmTester(n,j);
					for (int i = 1; i < data.length; i++) {
						f.addActor(data[i]);
					}
					filme.add(f);
					//System.out.println(f.out());
				}
			}	
			//System.out.println("Anzahl der Filme: " + filme.size());
		}
		catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei.");
		}
		finally {
			try {
				br.close();
			}
			catch (IOException e) {
				System.err.println("Fehler beim Schließen der Datei.");
			}
		}
	}
	
	public FilmTester(String n, String j) {
		name = n;
		jahr = j;
		sp = new ArrayList<String>();
	}
	
	public void addActor(String n) {
		sp.add(n);
	}
	
	public String toString() {
		String e = "";
		e += "Film: " + name + "\n";
		e += "Jahr: " + jahr + "\n";
		e += "Schauspieler: \n";
		for (String spname : sp) {
			e += "\t" + spname + "\n";
		}
		e += "-----------------------------";
		return e;
	}

}
