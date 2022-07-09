package _7sortieren;

public class Shell {

	// Shell-Sort - 1. Distanzfolge: h0 = objekte.length / 2;
	// h = h / 2;
	public static void shellSort1(int[] num) {
		int i, j, h;
		int hilf;
		for (h = num.length / 2; h > 0; h = h / 2) {
			for (i = h; i < num.length; i++) {
				hilf = num[i];
				j = i;
				while ((j >= h) && (num[j - h] > hilf)) {
					num[j] = num[j - h];
					j = j - h;
				}
				num[j] = hilf;
			}
		}
	}

	// Shell-Sort - 2. Distanzfolge: h0 = 2*t < num.length ;
	// h = h / 2;
	public static void shellSort2(int[] num) {
		int i, j, h;
		int hilf;
		// Anfangswert fuer h finden
		h = 1;
		do {
			h = 2 * h;
		} while (h < num.length);
		// h wurde soeben initalisiert
		for (; h > 0; h = h / 2) {
			for (i = h; i < num.length; i++) {
				hilf = num[i];
				j = i;
				while ((j >= h) && (num[j - h] > hilf)) {
					num[j] = num[j - h];
					j = j - h;
				}
				num[j] = hilf;
			}
		}
	}

	// Shell-Sort - 3. Distanzfolge: h0 = 2**t - 1 < num.length ;
	// h = h / 2;
	// nach D.E.Knuth
	public static void shellSort3(int[] num) {
		int i, j, h;
		int hilf;
		// Anfangswert fuer h finden
		h = 1;
		do {
			h = 2 * h;
		} while (h - 1 < num.length);
		for (h = h - 1; h > 0; h = h / 2) {
			for (i = h; i < num.length; i++) {
				hilf = num[i];
				j = i;
				while ((j >= h) && (num[j - h] > hilf)) {
					num[j] = num[j - h];
					j = j - h;
				}
				num[j] = hilf;
			}
		}
	}

	// Shell-Sort - 4. Distanzfolge: h0 = 3 * h + 1 <= num.length / 9 ;
	// h = h / 3;
	// nach R. Sedgewick
	public static void shellSort4(int[] num) {
		int i, j, h;
		int hilf;
		// Anfangswert fuer h finden
		for (h = 1; h <= num.length / 9; h = 3 * h + 1) {
		}
		// h wurde soeben initalisiert
		for (; h > 0; h = h / 3) {
			for (i = h; i < num.length; i++) {
				hilf = num[i];
				j = i;
				while ((j >= h) && (num[j - h] > hilf)) {
					num[j] = num[j - h];
					j = j - h;
				}
				num[j] = hilf;
			}
		}
	}

}
