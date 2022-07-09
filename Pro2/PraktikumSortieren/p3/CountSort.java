package p3;

public class CountSort {

	private static Sortieren s = new Sortieren();

	public static void main(String[] args) {
		
		int anzahl = 8;
		long t1, t2;
		
		int[] bestArr = s.bestArray(anzahl);
		int[] worstArr = s.worstArray(anzahl);
		int[] randArr = s.randArray(anzahl);

		//Ausgabe für das Prinzip

		countSort(randArr);
		
		
		
	}
	
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void countSort(int[] num) {
		countSortAusgabe(num, max(num));
	}
	
	public static void countSortAusgabe(int[] num, int max) {
		System.out.print("num:\t");
		s.printArray(num);
		int[] count = new int[max+1];
		int i, k;
		for (i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		System.out.print("count:\t");
		s.printArray(count);
		for (i = 0; i < num.length; i++) {
			count[num[i]] = count[num[i]]+1;
			System.out.print("count:\t");
			s.printArray(count);
		}
		System.out.print("count:\t\t\t\t");
		s.printArray(count);
		System.out.print("num:\t\t\t\t");
		s.printArray(num);
		int idx = 0;
		for (i = 0; i < count.length; i++) {
			for (k = 0; k < count[i]; k++) {
				num[idx] = i;
				System.out.print("num:\t" + idx + "\t" + "i: " + i + "\tk: " + k + "\t");
				s.printArray(num);
				idx++;
			}
		}
	}

}
