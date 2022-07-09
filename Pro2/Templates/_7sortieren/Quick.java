package _7sortieren;

public class Quick {
	
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
	      pivot = num[ (l + r) / 2];
	      do {
	        while (num[linksindex] < pivot) {
	          linksindex++;
	        }
	        while (num[rechtsindex] > pivot) {
	          rechtsindex--;
	        }
	        if (linksindex <= rechtsindex) {
	          vertauschen(num, linksindex, rechtsindex);
	          linksindex++;
	          rechtsindex--;
	        }
	      }
	      while (linksindex <= rechtsindex);
	      quickSortPivotMiddle(num, l, rechtsindex);
	      quickSortPivotMiddle(num, linksindex, r);
	    }
	  }

}
