package _6einAusgabe;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFMitIndex {

	// Schreiben
	public static void schreibenMitIndex(String pfad, String[] s) {
		RandomAccessFile rafData = null;
		RandomAccessFile rafIndex = null;
		try {
			rafData = new RandomAccessFile(pfad, "rw");
			rafIndex = new RandomAccessFile(pfad.substring(0, pfad.length() - 1) + "i", "rw");
			long p = 0;
			rafIndex.writeLong(p);
			for (String strings : s) {
				rafData.writeUTF(strings);
				p = rafData.getFilePointer();
				rafIndex.writeLong(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (rafData != null) {
				try {
					rafData.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (rafIndex != null) {
				try {
					rafIndex.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Lesen
	private static String lesenMitIndex(String pfad, int position) {
		RandomAccessFile rafData = null;
		RandomAccessFile rafIndex = null;
		String out = "";
		try {
			rafData = new RandomAccessFile(pfad, "r");
			rafIndex = new RandomAccessFile(pfad.substring(0, pfad.length() - 1) + "i", "r");
			long p = position * 8;
			rafIndex.seek(p);
			long p2 = rafIndex.readLong();
			rafData.seek(p2);
			out = rafData.readUTF();

		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei " + pfad);
			e.printStackTrace();
		} finally {
			if (rafData != null) {
				try {
					rafData.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlie�en der Datei " + pfad);
					e.printStackTrace();
				}
			}
			if (rafIndex != null) {
				try {
					rafIndex.close();
				} catch (IOException e) {
					System.err.println("Fehler beim Schlie�en der Datei " + pfad);
					e.printStackTrace();
				}
			}
		}
		return out;
	}

}
