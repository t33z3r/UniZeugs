package _7createArrays;

import java.util.Arrays;

public class IntArrays {

	public void printArray(int[] zahlen) {
		System.out.println(Arrays.toString(zahlen));
	}

	public int[] bestArray(int n) {
		int[] zahlen = new int[n];
		for (int i = 0; i < n; i++) {
			zahlen[i] = i;
		}
		return zahlen;
	}

	public int[] worstArray(int n) {
		int[] zahlen = new int[n];
		for (int i = 0; i < n; i++) {
			zahlen[i] = n - 1 - i;
		}
		return zahlen;
	}

	public int[] randArray(int n) {
		int[] zahlen = new int[n];
		for (int i = 0; i < n; i++) {
			zahlen[i] = (int) (Math.random() * n);
		}
		return zahlen;
	}

	public boolean geordnet(int[] num) {
		for (int i = 0; i < num.length - 1; i++)
			if (num[i] > num[i + 1])
				return false;
		return true;
	}

}
