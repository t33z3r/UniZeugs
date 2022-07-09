package st;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Filmverwaltung {

	private ArrayList<Film> filme;

	public static void main(String[] args) {
		Filmverwaltung verwaltung = new Filmverwaltung();
		verwaltung.leseFilmeEin();
		verwaltung.sucheFilmeAusJahr("2002");
	}

	public Filmverwaltung() {
		filme = new ArrayList<Film>();
	}
	
	public void sucheFilmeAusJahr(String jahr){
		for(Film f : filme){
			if(f.getJahr().equals(jahr)){
				System.out.println(f);
			}
		}
	}

	public void leseFilmeEin() {
		Path pfad = Paths.get("D:\\Daten\\filme.txt");
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(pfad);
			String zeile = null;
			while ((zeile = br.readLine()) != null) {
				String[] datensatz = zeile.split("/");
				if (datensatz.length >= 2) {
					String name = datensatz[0].substring(0, datensatz[0].indexOf("("));
					String jahr = datensatz[0].substring(datensatz[0].indexOf("(")+1, datensatz[0].indexOf(")"));
					Film f = new Film(name, jahr);
					for (int i = 1; i < datensatz.length; i++) {
						f.fuegeSchauspielerHinzu(datensatz[i]);
					}
					filme.add(f);
					//System.out.println(f);
				}

			}

			//System.out.println("Anzahl der Filme: " + filme.size());

		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei:");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Fehler beim Schliessen der Datei:");
				e.printStackTrace();
			}
		}

	}

}
