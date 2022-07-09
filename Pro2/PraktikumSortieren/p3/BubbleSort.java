package p3;

public class BubbleSort {
	
	private static Sortieren s = new Sortieren();

	public static void main(String[] args) {
		
		int anzahl = 8;
		long t1, t2;
		
		int[] bestArr = s.bestArray(anzahl);
		int[] worstArr = s.worstArray(anzahl);
		int[] randArr = s.randArray(anzahl);

		//Ausgabe für das Prinzip
		bubbleSortAusgabe(randArr);
		System.out.println();
		
		worstArr = s.worstArray(10000);
		
		//vorher konstante Zeit für das Klonen berechnen
		//um es später abziehen zu können -> für annähernd exakte Zeitmessung
		long tconst = -System.currentTimeMillis();
        int[] num = (int[]) worstArr.clone();
        tconst = tconst + System.currentTimeMillis();
        System.out.println("konstante Zeit : " + tconst); 
        System.out.println();
		
		//Zeitmessung BubbleSort
		System.gc();
		t1 = System.currentTimeMillis();
		num = (int[]) worstArr.clone();
		bubbleSort(num);
		t2 = System.currentTimeMillis();
		System.out.println("Normaler BubbleSort: " + (t2 - t1 - tconst) + " ms");
		if(!s.geordnet(num))
			System.out.println("Array nicht geordnet.");
		System.out.println();
		
		//Zeitmessung BubbleSort mit Abbruch
		System.gc();
		t1 = System.currentTimeMillis();
		num = (int[]) worstArr.clone();
		bubbleSort(num);
		t2 = System.currentTimeMillis();
		System.out.println("BubbleSort mit Abbruch: " + (t2 - t1 - tconst) + " ms");
		if(!s.geordnet(num))
			System.out.println("Array nicht geordnet.");
		System.out.println();
		
		
	}
	
	public static void bubbleSort(int[] num) {
		for (int i = num.length - 2; i >= 0; i--) {
			for (int k = 0; k <= i; k++) {
				if (num[k] > num[k+1])
					vertauschen(num, k, k+1);
			}
		}
	}
	
	public static void bubbleSortAusgabe(int[] num) {
		int count = 0;
		s.printArray(num);
		for(int i = num.length -2; i >= 0; i--) {
			for (int k = 0; k <= i; k++) {
				if(num[k] > num[k+1]) {
					System.out.println("Vertauschen von " + num[k] + " <-> " + num[k+1]);
					vertauschen(num, k, k+1);
					s.printArray(num);
					count++;
				}
			}
		}
		System.out.println("Vertauschung insgesamt: " + count);
	}
	
	public static void bubbleSortAbbruch(int[] num) {
		boolean repeat = true;
		for (int i = num.length - 2; i >= 0 && repeat; i--) {
			for (int k = 0; k <= i; k++) {
				if (num[k] > num[k+1])
					vertauschen(num, k, k+1);
			}
		}
	}
	
	public static void vertauschen(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

}
