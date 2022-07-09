package _6einAusgabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BuffReader {

	// Lesen
	private static void lesen(String pfad) {
		BufferedReader bf = null;
		try {
			bf = Files.newBufferedReader(Paths.get(pfad), StandardCharsets.UTF_8);
			String line = null;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlieﬂen der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
	}

	// Schreiben
	private static void schreiben(String pfad) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(pfad));
			bw.write("Textzeile 1");
			bw.newLine();
			bw.write("Textzeile 2");
		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlieﬂen der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
	}

}
