package _7suchen;

public class MaxMin {

	// Maximum bestimmen
	public static int bestimmeMax(int[] zahlen) {
		int max = zahlen[0];
		int i;
		for (i = 1; i < zahlen.length; i = i + 1) {
			if (zahlen[i] > max) {
				max = zahlen[i];
			}
		}
		return max;
	}

	// Minimum bestimmen
	public static int bestimmeMin(int[] zahlen) {
		int min = zahlen[0];
		int i;
		for (i = 1; i < zahlen.length; i = i + 1) {
			if (zahlen[i] < min) {
				min = zahlen[i];
			}
		}
		return min;
	}

}
