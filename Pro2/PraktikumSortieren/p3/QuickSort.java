package p3;

public class QuickSort {
	
	private static Sortieren s = new Sortieren();

	public static void main(String[] args) {
		
		int anzahl = 8;
		long t1, t2;

		int[] bestArr = s.bestArray(anzahl);
		int[] worstArr = s.worstArray(anzahl);
		int[] randArr = s.randArray(anzahl);

		// Ausgabe für das Prinzip
		s.printArray(randArr);
		System.out.println();
		quickSortPivotMiddle(randArr);
		System.out.println();
		s.printArray(randArr);

	}
	
	public static void vertauschen(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	public static void quickSortPivotMiddle(int[] num) {
	    quickSortPivotMiddle(num, 0, num.length - 1);
	  }

	  static void quickSortPivotMiddle(int[] num, int l, int r) {
	    int linksindex, rechtsindex;
	    int pivot;
	    if (l < r) {
	      linksindex = l;
	      rechtsindex = r;
	      System.out.println("l-idx: " + linksindex);
	      System.out.println("r-idx: " + rechtsindex);
	      s.printArray(num);
	      pivot = num[ (l + r) / 2];
	      System.out.println("Neues Pivot: " + pivot + " (" + ((l+r)/2) + ")");
	      do {
	        while (num[linksindex] < pivot) {
	          linksindex++;
	          System.out.println("l-idx: " + linksindex);
	        }
	        while (num[rechtsindex] > pivot) {
	          rechtsindex--;
	          System.out.println("r-idx: " + rechtsindex);
	        }
	        if (linksindex <= rechtsindex) {
	          System.out.println("Vertausche " + num[linksindex] + " <-> " + num[rechtsindex]);
	          vertauschen(num, linksindex, rechtsindex);
	          s.printArray(num);
	          linksindex++;
	          rechtsindex--;
	          System.out.println("l-idx: " + linksindex);
	          System.out.println("r-idx: " + rechtsindex);
	        }
	      }
	      while (linksindex <= rechtsindex);
	      System.out.println("Beginn neuer QuickSort l-r-idx");
	      quickSortPivotMiddle(num, l, rechtsindex);
	      System.out.println("Beginn neuer QuickSort r-l-idx");
	      quickSortPivotMiddle(num, linksindex, r);
	    }
	  }

}
