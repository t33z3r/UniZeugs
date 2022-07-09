package _7sortieren;

public class Count {

	// Hilfsmethode zur Bestimmung des Maximums
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// CountSort
	public static void countSort(int[] num) {
		int m = max(num);
		int[] count = new int[m + 1];
		int i, k;
		for (i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (i = 0; i < num.length; i++) {
			count[num[i]] = count[num[i]] + 1;
		}
		int idx = 0;
		for (i = 0; i < count.length; i++) {
			for (k = 0; k < count[i]; k++) {
				num[idx] = i;
				idx++;
			}
		}
	}

}
