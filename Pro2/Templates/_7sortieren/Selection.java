package _7sortieren;

public class Selection {

	// Hilfsfunktion zum Vertauschen
	public static void vertauschen(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

	// Hilfsfunktion Suche nach kleinstem Element ab Position
	public static int minPositionAb(int[] arr, int pos) {
		int minPos = pos;
		for (int i = pos + 1; i < arr.length; i++) {
			if (arr[i] < arr[minPos]) {
				minPos = i;
			}
		}
		return minPos;
	}

	// SelectionSort
	public static void selectionSort(int[] zahlen) {
		int minPos;
		for (int i = 0; i < zahlen.length - 1; i++) {
			minPos = minPositionAb(zahlen, i);
			if (minPos != i) {
				vertauschen(zahlen, i, minPos);
			}
		}
	}

}
