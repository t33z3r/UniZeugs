package _7sortieren;

public class Merge {

	private static void mergeSort(int[] num, int l, int r) {
		// Überprüfung, ob Liste nur aus 0 oder 1 Elementen besteht
		if (l < r) {
			int mitte = (l + r) / 2;
			mergeSort(num, l, mitte);
			mergeSort(num, mitte + 1, r);
			merge(num, l, mitte, r);
		}
	}

	private static void merge(int[] num, int l, int m, int r) {
		int[] hilf = new int[r - l + 1]; // Hilfsarray zum Mischen
		int linksindex = l; // Index in linker Teilliste
		int rechtsindex = m + 1; // Index in rechter Teilliste
		int i = 0; // Index des naechsten Elements
		int j = 0; // ein Zaehlindex
		while ((linksindex <= m) && (rechtsindex <= r)) { // in beiden Teillisten sind noch Elemente
			if (num[linksindex] <= num[rechtsindex]) {
				hilf[i] = num[linksindex];
				linksindex = linksindex + 1;
			} else {
				hilf[i] = num[rechtsindex];
				rechtsindex = rechtsindex + 1;
			}
			i = i + 1;
		}
		if (linksindex > m) { // linke Teilliste leer: Rest der rechten Teilliste uebernehmen
			// System.arraycopy(objekte, rechtsindex, hilf, i, rechts - rechtsindex + 1);
			for (j = 0; rechtsindex + j <= r; j++) {
				hilf[i + j] = num[rechtsindex + j];
			}
		} else { // rechte Teilliste leer: Rest der linken Teilliste uebernehmen
			// System.arraycopy(objekte, linksindex, hilf, i, mitte - linksindex + 1);
			for (j = 0; linksindex + j <= m; j++) {
				hilf[i + j] = num[linksindex + j];
			}
		}
		// System.arraycopy(hilf, 0, objekte, links, hilf.length);
		for (j = 0; j < hilf.length; j++) {
			num[l + j] = hilf[j];
		}
	}

}
