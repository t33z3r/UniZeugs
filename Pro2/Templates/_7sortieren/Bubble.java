package _7sortieren;

public class Bubble {

	// Hilfsmethode zum Vertauschen
	public static void vertauschen(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

	// BubbleSort Standard
	public static void bubbleSort(int[] num) {
		for (int i = num.length - 2; i >= 0; i--) {
			for (int k = 0; k <= i; k++) {
				if (num[k] > num[k + 1])
					vertauschen(num, k, k + 1);
			}
		}
	}

	// BubbleSort mit Abbruch bei bereits sortiertem Array
	public static void bubbleSortAbbruch(int[] num) {
		boolean repeat = true;
		for (int i = num.length - 2; i >= 0 && repeat; i--) {
			for (int k = 0; k <= i; k++) {
				repeat = false;
				if (num[k] > num[k + 1]) {
					vertauschen(num, k, k + 1);
					repeat = true;
				}
			}
		}
	}

}
