package p2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SucheLuecke {
	
	public static void main(String[] args) {
		int[] zahlen;
		int luecke;

		zahlen = randIntegerArray(20);
		System.out.println("Lücke im ungeordneten Array suchen: ");
		luecke = lueckeImUngeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();

		zahlen = lueckeIntegerArray(20);
		System.out.println("Lücke im geordneten Array suchen: ");
		luecke = lueckeImGeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();

		zahlen = upwardIntegerArray(20);
		System.out.println("Lücke im geordneten Array suchen: ");
		luecke = lueckeImGeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();
	}
	
	public static int lueckeImUngeordnetenArray(int[] zahlen) throws NoSuchElementException {
		int i;
		// Minimum und Maximum bestimmen
		int max = zahlen[0];
		int min = zahlen[0];
		for (i = 1; i < zahlen.length; i = i + 1) { 
			if (zahlen[i] > max) {
				max = zahlen[i];
			}
			if (zahlen[i] < min) {
				min = zahlen[i];
			}
		}

		boolean[] istVorhanden = new boolean[max - min + 1];

		for (i = 0; i < istVorhanden.length; i = i + 1) {
			istVorhanden[i] = false;
		}
		for (i = 0; i < zahlen.length; i = i + 1) {
			istVorhanden[zahlen[i] - min] = true;
		}
		for (i = 0; i < istVorhanden.length && istVorhanden[i]; i++) {
			;
		}
		if (i < istVorhanden.length) {
			return min + i;
		} else {
			throw new NoSuchElementException("keine Lücke im Array");
		}

	}
	
	public static int lueckeImGeordnetenArray(int[] zahlen) throws NoSuchElementException {
		if (zahlen[zahlen.length - 1] - zahlen[0] <= zahlen.length - 1) {
			throw new NoSuchElementException("keine Lücke im Array");
		}
		return lueckeImGeordnetenArray(zahlen, 0, zahlen.length - 1);
	}
	
	private static int lueckeImGeordnetenArray(int[] zahlen, int von, int bis) {
		int nichtEnthalten;
		if (bis == von + 1) {
			nichtEnthalten = zahlen[von] + 1;
		} else {
			int mitte = (von + bis) / 2;
			if (zahlen[mitte] - zahlen[von] > mitte - von) {
				nichtEnthalten = lueckeImGeordnetenArray(zahlen, von, mitte);
			} else {
				nichtEnthalten = lueckeImGeordnetenArray(zahlen, mitte, bis);
			}
		}
		return nichtEnthalten;
	}
	
	public static int[] randIntegerArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * n);
		}
		return arr;
	}
	
	public static int[] lueckeIntegerArray(int n) {
		int[] hilf = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			hilf[i] = i;
		}
		int luecke = 1 + (int) (Math.random() * (n - 1));
		int[] arr = new int[n];
		//kopiere von hilf ab Position 0 in arr ab Position 0 bis Position luecke
		System.arraycopy(hilf, 0, arr, 0, luecke);
		//kopiere von hilf ab luecke+1 in arr ab luecke bis arr-Ende
		System.arraycopy(hilf, luecke + 1, arr, luecke, arr.length - luecke);
		return arr;
	}
	
	public static int[] upwardIntegerArray(int n) {
		int[] arr = new int[n];
		arr[0] = (int) (Math.random() * n);
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + (int) (2 * Math.random() + 1);
		}
		return arr;
	}

}
