package _7suchen;

public class BinäreSuche {

	// Rekursive binäre Suche
	public static int binSucheRek(int[] zahlen, int gesucht, int von, int bis) {
		int pos = -1;
		if (von <= bis) {
			int mitte = (von + bis) / 2;
			if (gesucht > zahlen[mitte]) {
				pos = binSucheRek(zahlen, gesucht, mitte + 1, bis);
			} else {
				if (gesucht < zahlen[mitte]) {
					pos = binSucheRek(zahlen, gesucht, von, mitte - 1);
				} else {
					pos = mitte;
				}
			}
		}
		return pos;

	}

	// Iterative Suche
	public static int binSucheIt(int[] zahlen, int gesucht, int von, int bis) {
		int pos = -1;
		int mitte;
		while ((von <= bis) && (pos == -1)) {
			mitte = (von + bis) / 2;
			if (gesucht > zahlen[mitte]) {
				von = mitte + 1;
			} else if (gesucht < zahlen[mitte]) {
				bis = mitte - 1;
			} else {
				pos = mitte;
			}
		}

		return pos;

	}

	// Rekursive binäre Suche für Objekte
	public static int binSucheRekObj(Comparable[] ob, Object gesucht, int von, int bis) {
		int pos = -1;
		if (von <= bis) {
			int mitte = (von + bis) / 2;
			if (ob[mitte].compareTo(gesucht) < 0) {
				pos = binSucheRekObj(ob, gesucht, mitte + 1, bis);
			} else {
				if (ob[mitte].compareTo(gesucht) > 0) {
					pos = binSucheRekObj(ob, gesucht, von, mitte - 1);
				} else {
					pos = mitte;
				}
			}
		}
		return pos;

	}

	// Kurze Variante mit weniger Eingaben
	public static int binSucheRek(int[] zahlen, int gesucht) {
		return binSucheRek(zahlen, gesucht, 0, zahlen.length - 1);
	}

	public static int binSucheIt(int[] zahlen, int gesucht) {
		return binSucheIt(zahlen, gesucht, 0, zahlen.length - 1);
	}

	// ############################################################################################################
	public static void main(String[] args) {
		Integer[] ob = new Integer[10];
		for (int i = 1; i <= 10; i++) {
			ob[i - 1] = i;
		}

		Integer wanted = 4;

		System.out.println(binSucheRekObj(ob, wanted, 1, 10));

	}
}
