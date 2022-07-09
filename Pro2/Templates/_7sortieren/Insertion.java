package _7sortieren;

public class Insertion {

	// InsertionSort
	public static void insertionSort(int[] zahlen) {
		int hilf, k;
		for (int i = 1; i < zahlen.length; i++) {
			hilf = zahlen[i];
			for (k = i; (k > 0 && zahlen[k - 1] > hilf); k--) {
				zahlen[k] = zahlen[k - 1];
			}
			zahlen[k] = hilf;
		}
	}

}
