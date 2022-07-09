package _6einAusgabe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesDirectories {

	// Kopieren von 2 Dateien
	public static void copy(String quelle, String ziel) throws IOException {

		FileInputStream fis = new FileInputStream(quelle);

		FileOutputStream fos = new FileOutputStream(ziel);

		int b = fis.read();

		while (b != -1) {
			fos.write(b);
			b = fis.read();
		}
		fis.close();
		fos.close();
	}

	// Anzeigen von Datei-Eigenschaften und Verzeichnis-Inhalt
	public static void file(String path) throws IOException {
		File file = new File(path);
		// Pfad
		System.out.println(file.getCanonicalPath());
		// Name
		System.out.println(file.getName());
		// Kann gelesen werden
		System.out.println(file.canRead());
		// Kann geschrieben werden
		System.out.println(file.canWrite());
		// Kann ausgeführt werden
		System.out.println(file.canExecute());
		// In welchem Verzeichnis liegt der Pfad?
		System.out.println(file.getParent());
		// Ist der Pfad ein Verzeichnis?
		System.out.println(file.isDirectory());
		// Ist der Pfad eine Datei?
		System.out.println(file.isFile());

		// Verzeichnis-Inhalt
		/*
		 * File[] files = file.listFiles();
		 * 
		 * for(File f : files) { System.out.println(f.getPath()); }
		 */
		// Rekursiv
		getFiles(file);

		/*
		 * Manipulation mit delete() mkdir() renameTo(<Neuer Name>) setReadOnly()
		 * setLastModified()
		 */

	}

	// Rekursiver Verzeichnis-Inhalt
	public static void getFiles(File path) {
		File[] files = path.listFiles();

		for (File f : files) {
			System.out.println(f.getPath());
			if (f.isDirectory())
				getFiles(f);
		}
	}

	// Kopieren von Dateien eines Verzeichnisses in ein anderes Verzeichnis
	public static void copyFiles(Path dir1, Path dir2) throws IOException {

		if (!Files.exists(dir1)) {
			System.err.println(dir1 + " existiert nicht.");
			System.exit(1);
		}

		if (!Files.exists(dir2)) {
			System.err.println(dir2 + " existiert nicht.");
			System.exit(1);
		}

		File files = new File(dir1.toString());

		File[] content = files.listFiles();

		for (File file : content) {

			Path source = Paths.get(file.getPath());

			Path target = Paths.get(dir2.toString() + "\\" + file.getName());

			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		}

	}

	// Prüfen, ob ein Verzeichnis leer ist
	public static boolean isEmpty(String s) throws IOException {
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(s));
		return (!dirStream.iterator().hasNext());
	}

	// Verzeichnis/Dateien verschieben
	public static void move(Path p1, Path p2) throws IOException {
		Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);
	}

	// Dateien erstellen
	public static void createFile(String s) throws IOException {
		Files.createFile(Paths.get(s));
	}

	// Verzeichnis erstellen
	public static void createDir(String s) throws IOException {
		Files.createDirectory(Paths.get(s));
	}

	// #############################################################################
	public static void main(String[] args) throws IOException {
		FilesDirectories v = new FilesDirectories();
		// createDir(".\\A");
		// createDir(".\\B");
		System.out.println(isEmpty(".\\A"));
		// createFile(".\\A\\file.txt");
		copyFiles(Paths.get(".\\A"), Paths.get(".\\B"));
	}

}
