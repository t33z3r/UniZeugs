package raf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Copy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		String folder = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\Kopien";	
		Path fold = Paths.get(folder);
		String file = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\test.txt";
		String t1 = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\test-kopie.txt";
		String t2 = "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\Kopien\\test-kopie.txt";
		
		if(!Files.exists(fold)) {
			Files.createDirectory(fold);
		}
		
		copy(file,t1);
		
		move(t1, t2);
		
		copyURL("http://www.staff.hs-mittweida.de/~altrogge/Beispiel_NIO.txt", "Z:\\Uni\\Semester2\\Programmierung2\\Pr\\Ein-Ausgabe\\Test\\Kopien\\Beispiel.txt");
		
	}
	
	public static void copy(String source, String target) throws IOException{
		Path s = Paths.get(source);
		Path t = Paths.get(target);
		
		Files.copy(s, t, StandardCopyOption.REPLACE_EXISTING);
		
		if(Files.exists(t)) {
			System.out.println("Die Datei " + s.getFileName() + " wurde in die Datei " + t.getFileName() + " kopiert.");
		}
		
	}
	
	public static void move(String source, String target) throws IOException {
		Path s = Paths.get(source);
		Path t = Paths.get(target);
		
		Files.move(s, t, StandardCopyOption.REPLACE_EXISTING);
		
		if (Files.exists(t)){
			System.out.println("move operation was successfull");
		}
		
	}
	
	public static void copyURL(String source, String target) throws IOException {
		URL u = new URL(source);
		InputStream is = u.openStream();
		Path t = Paths.get(target);
		Files.copy(is, t, StandardCopyOption.REPLACE_EXISTING);
		if (is != null) {
			is.close();
		}
		if (Files.exists(t)){
			System.out.println("url copy operation was successfull");
		}
	}

}
