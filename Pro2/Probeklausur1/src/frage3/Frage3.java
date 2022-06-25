package frage3;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Frage3 {
	
	public static void main(String[] args) {
		//Erstellen der Pfad-Objekte der zukünftigen Verzeichnisse
		Path dir1 = Paths.get(".\\A");
		Path dir2 = Paths.get(".\\B");
		
		//try-catch-Block für Ein- und Ausgabe-Operationen in den aufgerufenen Methoden
		try {
			createTestFiles(dir1);
			copyFiles(dir1, dir2);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Methode zum Kopieren aller Dateien eines Verzeichnisses
	//dir1 -> Quellverzeichnis
	//dir2 -> Zielverzeichnis
	
	public static void copyFiles(Path dir1, Path dir2) throws IOException {
		//Prüfung, ob Verzeichnisse bereits existieren (lt. Aufgabenstellung gewünscht)
		if (!Files.exists(dir1)) {
			//Falls diese noch nicht existieren werden sie erstellt
			Files.createDirectory(dir1);
		}
		
		if (!Files.exists(dir2)) {
			Files.createDirectory(dir2);
		}
		//Anlegen eines File-Objekts für die Auflistung der darin enthaltenen Dateien
		File files = new File(dir1.toString());
		//File-Array zum Abspeichern jener Liste
		File[] content = files.listFiles();
		//Für alle Elemente des Arrays (Für jede Datei im Quellverzeichnis)
		for (File file : content) {
			//Erstellen der Pfad-Objekte für jede einzelne Datei
			//Quelle
			Path source = Paths.get(file.getPath());
			//Ziel
			Path target = Paths.get(dir2.toString() + "\\" + file.getName());
			//Kopieroperation
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		}
		
		
	}
	
	//Zusätzliche Methode zum Erstellen von Testverzeichnissen/-dateien
	
	public static void createTestFiles(Path dir1) throws IOException {
		//Prüfen, ob Verzeichnis existiert
		if (!Files.exists(dir1)) {
			Files.createDirectory(dir1);
			}
		//Prüfen, ob Verzeichnis leer ist
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir1);
		if (!dirStream.iterator().hasNext()) {
			//Erstellung von Test-Files
			Path testfile1 = Paths.get(dir1 + "\\testfile1.txt");
			Path testfile2 = Paths.get(dir1 + "\\testfile2.txt");
			Files.createFile(testfile1);
			Files.createFile(testfile2);
		    }
		
		
	}

}
