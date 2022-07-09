package _6einAusgabe;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class WriterReader {

	// Schreiben
	public static void write(String s, File f) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			fw.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// Lesen
	public static void read(File f) {
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			int c = fr.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fr.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// ################################################################################
	public static void main(String[] args) {
		read(new File(".\\test.txt"));
	}

}
