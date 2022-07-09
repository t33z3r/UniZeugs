package sammlungen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Telefonbuch {

	private Map<String, HashSet<String>> speicher;
	
	public Telefonbuch() {
		speicher = new HashMap<String, HashSet<String>>();
	}
	
	public boolean add(String name, String telnr) {
		boolean b = false;
		//wenn Name vorhanden
		if (speicher.containsKey(name)) {
			HashSet<String> nrset = speicher.get(name);
			b = nrset.add(telnr);
			System.out.println(telnr + " wurde " + name + " hinzugef�gt.");
		} else {
			HashSet<String> nrset = new HashSet<String>();
			b = nrset.add(telnr);
			speicher.put(name, nrset);
			System.out.println(name + " mit der Telefonnummer " + telnr + " wurde angelegt.");
		}
		return b;
	}
	
	public String hatTelNr(String name) {
		String telnrs = "nicht bekannt";
		if (speicher.containsKey(name)) {
			telnrs = speicher.get(name).toString();
		}
		return telnrs;
	}
	
	public boolean l�schen(String name, String telnr) {
		boolean b = false;
		if (speicher.containsKey(name)) {
			Set<String> nrset = speicher.get(name);
			b = nrset.remove(telnr);
			System.out.println(telnr + " wurde von " + name + " gel�scht.");
			if (nrset.isEmpty()) {
				speicher.remove(name);
				System.out.println(name + " wurde ebenfalls gel�scht.");
			}
		}
		return b;
	}
	
	public boolean l�schen(String name) {
		boolean b = false;
		if (speicher.containsKey(name)) {
			speicher.remove(name);
			System.out.println(name + " wurde gel�scht.");
			b = true;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Telefonbuch t = new Telefonbuch();
		t.add("Peter Meyer", "0151 548439584");
		t.add("Susann M�ller", "0172 393576947");
		t.add("Klaus Ritter", "0151 548439584");
		System.out.println(t.hatTelNr("Peter Meyer"));
		t.add("Peter Meyer", "0151 548439523");
		System.out.println(t.hatTelNr("Peter Meyer"));
		t.l�schen("Peter Meyer", "0151 548439523");
		t.l�schen("Klaus Ritter");
	}
	
}
