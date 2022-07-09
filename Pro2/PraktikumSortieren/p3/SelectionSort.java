package p3;

public class SelectionSort {

	private static Sortieren s = new Sortieren();

	public static void main(String[] args) {
		
		int anzahl = 8;
		long t1, t2;
		
		int[] bestArr = s.bestArray(anzahl);
		int[] worstArr = s.worstArray(anzahl);
		int[] randArr = s.randArray(anzahl);

		//Ausgabe für das Prinzip
		
		insertionSortAusgabe(randArr);
		System.out.println("------------------------------");
		
		randArr = s.randArray(anzahl);
		selectionSortAusgabe(randArr);
		
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
		selectionSort(num);
		t2 = System.currentTimeMillis();
		System.out.println("SelectionSort: " + (t2 - t1 - tconst) + " ms");
		if(!s.geordnet(num))
			System.out.println("Array nicht geordnet.");
		System.out.println();
		
		//Zeitmessung BubbleSort mit Abbruch
		System.gc();
		t1 = System.currentTimeMillis();
		num = (int[]) worstArr.clone();
		insertionSort(num);
		t2 = System.currentTimeMillis();
		System.out.println("InsertionSort: " + (t2 - t1 - tconst) + " ms");
		if(!s.geordnet(num))
			System.out.println("Array nicht geordnet.");
		System.out.println();
		
		
	}
	
	public static void vertauschen(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	public static int minPositionAb(int[] arr, int pos) {
		int minPos = pos;
		for(int i = pos + 1; i < arr.length; i++) {
			if (arr[i] < arr[minPos]) {
				minPos = i;
			}
		}
		return minPos;
	}
	
	public static void selectionSort(int[] zahlen) {
		int minPos;
		for(int i = 0; i < zahlen.length - 1; i++) {
			minPos = minPositionAb(zahlen, i);
			if (minPos != i) {
				vertauschen(zahlen, i, minPos);
			}
		}
	}
	
	public static void selectionSortAusgabe(int[] zahlen) {
		int minPos;
		s.printArray(zahlen);
		for(int i = 0; i < zahlen.length - 1; i++) {
			minPos = minPositionAb(zahlen, i);
			if (minPos != i) {
				System.out.println("Vertausche " + zahlen[i] + " <-> " + zahlen[minPos]);
				vertauschen(zahlen, i, minPos);
				s.printArray(zahlen);
			}
		}
	}
	
	public static void insertionSort(int[] zahlen) {
		int hilf, k;
		for(int i = 1; i < zahlen.length; i++) {
			hilf = zahlen[i];
			for(k = i; (k > 0 && zahlen[k - 1] > hilf); k--) {
				zahlen[k] = zahlen[k - 1];
			}
			zahlen[k] = hilf;
		}
	}
	
	public static void insertionSortAusgabe(int[] zahlen) {
		int hilf, k;
		String erg;
		s.printArray(zahlen);
		for(int i = 1; i < zahlen.length; i++) {
			hilf = zahlen[i];
			erg = "";
			for(k = i; ((k > 0) && (zahlen[k - 1] > hilf)); k--) {
				zahlen[k] = zahlen[k - 1];	
					erg += "\tVertausche " + zahlen[k] + " <-> " + hilf + "\n";
			}
			erg = "Vertausche " + zahlen[i] + " <-> " + hilf  + "\n" + erg;
			zahlen[k] = hilf;
			System.out.println(erg);
			s.printArray(zahlen);
		}
	}

}
