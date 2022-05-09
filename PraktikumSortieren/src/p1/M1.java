package p1;

public class M1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long time;
		
		int n = 10;
		
		Sortieren s = new Sortieren();
		int[] test1 = s.worstArray(n);
		int[] test2 = s.bestArray(n);
		int[] test3 = s.randArray(n);
		
		/*
		System.out.println("BubbleSort");
		
		System.out.println("best:");
		s.printArray(test2);
		time = System.currentTimeMillis();
		bubbleSort(test2);
		time = System.currentTimeMillis() - time;
		s.printArray(test2);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("worst:");
		s.printArray(test1);
		time = System.currentTimeMillis();
		bubbleSort(test1);
		time = System.currentTimeMillis() - time;
		s.printArray(test1);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("rand:");
		s.printArray(test3);
		time = System.currentTimeMillis();
		bubbleSort(test3);
		time = System.currentTimeMillis() - time;
		s.printArray(test3);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		*/
		/*
		System.out.println("MergeSort");
		
		System.out.println("best:");
		s.printArray(test2);
		time = System.currentTimeMillis();
		mergeSort(test2, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test2);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("worst:");
		s.printArray(test1);
		time = System.currentTimeMillis();
		mergeSort(test1, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test1);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("rand:");
		s.printArray(test3);
		time = System.currentTimeMillis();
		mergeSort(test3, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test3);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		*/
		
		/*
		System.out.println("QuickSort");
		
		System.out.println("best:");
		s.printArray(test2);
		time = System.currentTimeMillis();
		quickSort(test2, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test2);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("worst:");
		s.printArray(test1);
		time = System.currentTimeMillis();
		quickSort(test1, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test1);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("rand:");
		s.printArray(test3);
		time = System.currentTimeMillis();
		quickSort(test3, 0, n-1);
		time = System.currentTimeMillis() - time;
		s.printArray(test3);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		*/
		
		System.out.println("CountSort");
		
		System.out.println("best:");
		s.printArray(test2);
		time = System.currentTimeMillis();
		countSort(test2, max(test2));
		time = System.currentTimeMillis() - time;
		s.printArray(test2);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("worst:");
		s.printArray(test1);
		time = System.currentTimeMillis();
		countSort(test1, max(test1));
		time = System.currentTimeMillis() - time;
		s.printArray(test1);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
		System.out.println("rand:");
		s.printArray(test3);
		time = System.currentTimeMillis();
		countSort(test3, max(test3));
		time = System.currentTimeMillis() - time;
		s.printArray(test3);
		System.out.println("Zeit: " + time / n + "ms");
		System.out.println();
		
	}
	
	public static int max(int[] zahlen){
		int max = zahlen[0];
		for (int i = 1; i <= (zahlen.length -1); i++){
			if (zahlen[i] > max){
				max = zahlen[i];
			}
		}
		return max;
	}
	
	public static void vertauschen(int[] zahlen, int i, int j){
		int hilf = zahlen[i];
		zahlen[i] = zahlen[j];
		zahlen[j] = hilf;
	}
	
	public static void bubbleSort(int[] zahlen){
		for (int i = (zahlen.length - 2); i >= 0; i--){
			for (int j = 0; j <= i; j++){
				if (zahlen[j] > zahlen[j+1]){
					vertauschen(zahlen, j, j+1);
				}
			}
		}
	}
	
	public static void insertionSort(int[] zahlen){
		for (int i = 1; i <= zahlen.length - 1; i++){
			int j = i;
			int h = zahlen[i];
			while (j > 0 && zahlen[j-1] > h)
			{
				zahlen[j] = zahlen[j-1];
				j = j-1;
			}
			zahlen[j] = h;
		}
	}
	
	public static void mergeSort(int[] zahlen, int l, int r){
		if (l < r){
			int m = ((l + r) / 2);
			mergeSort(zahlen, l, m);
			mergeSort(zahlen, m + 1, r);
			merge(zahlen, l, m, r);
		}
	}
	
	public static void merge(int[] zahlen, int l, int m, int r){
		int[] h = new int[(r - l + 1)];
		int li = l;
		int ri = m + 1;
		int i = 0;
		while (li <= m && ri <= r){
			if (zahlen[li] <= zahlen[ri]){
				h[i] = zahlen[li];
				li++;
			}
			else {
				h[i] = zahlen[ri];
				ri++;
			}
			i++;
		}
		if (li > m){
			for (int j = 0; j <= (r - ri); j++){
				h[i + j] = zahlen[ri + j];
			}
		}
		else {
			for (int j = 0; j <= (m - li); j++){
				h[i + j] = zahlen[li + j];
			}
		}
		for (int j = 0; j <= (r - l); j++){
			zahlen[l + j] = h[j];
		}
	}
	
	public static void quickSort(int[] zahlen, int l, int r){
		if (l < r){
			int li = l;
			int ri = r;
			int pivot = zahlen[(l+r)/2];
			do {
				while (zahlen[li] < pivot){
					li++;
				}
				while (zahlen[ri] > pivot){
					ri--;
				}
				if (li <= ri){
					vertauschen(zahlen, li, ri);
					li++;
					ri--;
				}
			}
			while (li <= ri);
			quickSort(zahlen, l, ri);
			quickSort(zahlen, li, r);
		}
	}
	
	public static void countSort(int[] zahlen, int max){
		int[] z = new int[max+1];
		for (int i = 0; i <= max; i++){
			z[i] = 0;
		}
		for (int i = 0; i <= (zahlen.length - 1); i++){
			z[zahlen[i]] = z[zahlen[i]] + 1 ;
		}
		int index = 0;
		for (int i = 0; i <= max; i++){
			for (int j = 0; j <= (z[i] - 1); j++){
				zahlen[index] = i;
				index++;
			}
		}
	}

}
