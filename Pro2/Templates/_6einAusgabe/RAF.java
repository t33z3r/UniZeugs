package _6einAusgabe;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RAF {

	// Schreiben
	public static void schreiben(String pfad, String s) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(pfad, "rw");
			raf.writeUTF(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Lesen
	private static void lesen(String pfad) {
		lesen(pfad, 0);
	}

	// Lesen
	private static void lesen(String pfad, int position) {
		RandomAccessFile raf = null;
		String out = "";
		try {
			raf = new RandomAccessFile(pfad, "r");
			long p = position * 8;
			raf.seek(p);
			/*
			 * Wenn aus gewöhnlicher Datei gelesen werden soll byte[] b = new byte[(int)
			 * raf.length()]; raf.read(b); out = new String(b, StandardCharsets.UTF_8);
			 */
			out = raf.readUTF();

		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schließen der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
		System.out.println(out);
	}

	// #############################!!!Nur zum Test!!!#############################
	public static void main(String[] args) {
		lesen(".\\test.txt");
	}

}
