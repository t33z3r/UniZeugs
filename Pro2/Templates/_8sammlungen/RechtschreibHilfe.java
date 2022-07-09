package _8sammlungen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RechtschreibHilfe {

	private String woerterbuchfile;
	private String txtfile;
	private Set<String> woerterbuch;
	private Map<Integer, List<String>> fehler;
	
	public RechtschreibHilfe(String woerterbuchhilfe, String txtfile) {
		this.txtfile = txtfile;
		this.woerterbuchfile = woerterbuchhilfe;
		initWoerterbuch();
		analysiereText();
	}
	
	private void initWoerterbuch() {
		woerterbuch = new HashSet<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(woerterbuchfile));
			String wort = br.readLine();
			while (wort != null) {
				woerterbuch.add(wort.trim().toLowerCase());
				wort = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Einlesen der Datei " + woerterbuchfile);
			e.printStackTrace();
		}
	}
	
	private void analysiereText() {
		fehler = new HashMap<Integer, List<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(txtfile));
			String line = br.readLine();
			int count = 0;
			Integer linenr;
			StringTokenizer st;
			String begrenzer = " \t.,;:!?()-";
			ArrayList<String> fehlerliste;
			String wort;
			while (line != null) {
				line = line.toLowerCase();
				linenr = Integer.valueOf(count);
				st = new StringTokenizer(line, begrenzer);
				fehlerliste = new ArrayList<String>();
				fehler.put(linenr, fehlerliste);
				while (st.hasMoreTokens()) {
					wort = st.nextToken();
					if (!woerterbuch.contains(wort)) {
						fehlerliste.add(wort);
					}
				}
				line = br.readLine();
				count++;
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Text-Analysieren.");
			e.printStackTrace();
		}
	}
	
	public void generiereReport() {
		System.out.println();
		System.out.println("einfache Variante: ");
		System.out.println();
		List<String> fehlerliste;
		for (int i = 0; i < fehler.size(); i++) {
			System.out.println("Zeile " + (i+1) + ": ");
			fehlerliste = fehler.get(Integer.valueOf(i));
			for (String f : fehlerliste) {
				System.out.println(f + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Variante mit Fehlermarkierung im Text: ");
		System.out.println();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(txtfile));
			for (int i = 0; i < fehler.size(); i++) {
				String oline = br.readLine();
				String low = oline.toLowerCase();
				StringBuffer error = new StringBuffer(low.length());
				for (int k = 0; k < low.length(); k++) {
					error.append(' ');
				}
				fehlerliste = fehler.get(Integer.valueOf(i));
				Iterator<String> it = fehlerliste.iterator();
				while(it.hasNext()) {
					String wrongWord = it.next();
					int start = 0;
					while (start >= 0) {
						int pos = low.indexOf(wrongWord, start);
						if (pos >= 0) {
							for (int m = 0; m < wrongWord.length(); m++) {
								error.setCharAt(pos + m, '~');
							}
							start = pos + error.length();
						} else {
							start = -1;
						}
					}
				}
				System.out.println(oline);
				System.out.println(error);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Fehler bei Fehlermarkierung");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RechtschreibHilfe rh = new RechtschreibHilfe(".\\woerter.txt", ".\\text.txt");
		rh.generiereReport();
	}
	
	
}
