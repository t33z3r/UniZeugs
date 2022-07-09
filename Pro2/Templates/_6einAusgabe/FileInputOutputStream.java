package _6einAusgabe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileInputOutputStream {

	// Lesen
	private static void lesen(String pfad) {

		InputStream is = null;

		try {
			is = Files.newInputStream(Paths.get(pfad), StandardOpenOption.READ);
			int b = is.read();
			while (b != -1) {
				System.out.print((char) b);
				b = is.read();
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlieﬂen der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
	}

	// Schreiben
	private static void schreiben(String pfad) {

		OutputStream out = null;

		try {
			out = new FileOutputStream(pfad);
			String text = "Ein kleiner Text \n Noch ein Text";
			char[] zeichen = text.toCharArray();
			for (int i = 0; i < zeichen.length; i++) {
				out.write(zeichen[i]);
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlieﬂen der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		schreiben(".\\test.d");
		lesen(".\\test.d");
	}
}
