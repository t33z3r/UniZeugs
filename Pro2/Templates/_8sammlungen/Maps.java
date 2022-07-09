package _8sammlungen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Maps {

	private Map<String, HashSet<String>> storage;
	
	public Maps() {
		storage = new HashMap<String, HashSet<String>>();
	}
	
	public boolean add(String name, String num) {
		boolean b = false;
		//wenn Name vorhanden
		if (storage.containsKey(name)) {
			HashSet<String> nrset = storage.get(name);
			b = nrset.add(num);
			System.out.println(num + " wurde " + name + " hinzugefuegt.");
		} else {
			HashSet<String> nrset = new HashSet<String>();
			b = nrset.add(num);
			storage.put(name, nrset);
			System.out.println(name + " mit der Nummer " + num + " wurde angelegt.");
		}
		return b;
	}
	
	public String hatnum(String name) {
		String nums = "nicht bekannt";
		if (storage.containsKey(name)) {
			nums = storage.get(name).toString();
		}
		return nums;
	}
	
	public boolean loeschen(String name, String num) {
		boolean b = false;
		if (storage.containsKey(name)) {
			Set<String> nrset = storage.get(name);
			b = nrset.remove(num);
			System.out.println(num + " wurde von " + name + " geloescht.");
			if (nrset.isEmpty()) {
				storage.remove(name);
				System.out.println(name + " wurde ebenfalls geloescht.");
			}
		}
		return b;
	}
	
	public boolean loeschen(String name) {
		boolean b = false;
		if (storage.containsKey(name)) {
			storage.remove(name);
			System.out.println(name + " wurde geloescht.");
			b = true;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Maps t = new Maps();
		t.add("Peter Meyer", "0151 548439584");
		t.add("Susann Mueller", "0172 393576947");
		t.add("Klaus Ritter", "0151 548439584");
		System.out.println(t.hatnum("Peter Meyer"));
		t.add("Peter Meyer", "0151 548439523");
		System.out.println(t.hatnum("Peter Meyer"));
		t.loeschen("Peter Meyer", "0151 548439523");
		t.loeschen("Klaus Ritter");
	}
	
}
