package p2;

public class SucheSeqBin {

	public static void main(String[] args) {
		//System.out.println((int)(Math.random() * 100));
		//Zufallszahl von 1 - 100
		
		int anzahl = 7500000;
		int[] zahlen = randIntArr(anzahl);
		int gesucht = anzahl -2;
		int pos = -1;
		long time;
		int testanzahl = 10;
		int i;
		
		//sequentielle Suche
		System.out.println("Sequentielle Suche mit Exception:");
		time = System.currentTimeMillis();
		for (i=0; i < testanzahl; i++) {
			pos = seqSuche(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Pos " + pos);
		System.out.println("Benötigte Zeit: " + time + " ms");
		System.out.println("---------------------------------");
		
		System.out.println("Sequentielle Suche mit Grenze:");
		time = System.currentTimeMillis();
		for (i=0; i < testanzahl; i++) {
			pos = seqSucheGrenze(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Pos " + pos);
		System.out.println("Benötigte Zeit: " + time + " ms");
		System.out.println("---------------------------------");
		
		System.out.println("Sequentielle Suche mit Stopper:");
		time = System.currentTimeMillis();
		for (i=0; i < testanzahl; i++) {
			pos = seqSucheStop(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Pos " + pos);
		System.out.println("Benötigte Zeit: " + time + " ms");
		System.out.println("---------------------------------");
		
		System.out.println("Sequentielle Suche mit Schleife:");
		time = System.currentTimeMillis();
		for (i=0; i < testanzahl; i++) {
			pos = seqSucheFor(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Pos " + pos);
		System.out.println("Benötigte Zeit: " + time + " ms");
		System.out.println("---------------------------------");
		
		
		//binäre Suche
		zahlen = ordIntArr(anzahl);
		if (istGeordnet(zahlen)) {
			System.out.println("Binäre rekursive Suche:");
			time = System.currentTimeMillis();
			for (i=0; i < testanzahl; i++) {
				pos = binSearch(zahlen, gesucht);
			}
			time = System.currentTimeMillis() - time;
			System.out.println(gesucht + " ist an Pos " + pos);
			System.out.println("Benötigte Zeit: " + time + " ms");
			System.out.println("---------------------------------");
			
			System.out.println("Binäre iterative Suche:");
			time = System.currentTimeMillis();
			for (i=0; i < testanzahl; i++) {
				pos = binSearch2(zahlen, gesucht);
			}
			time = System.currentTimeMillis() - time;
			System.out.println(gesucht + " ist an Pos " + pos);
			System.out.println("Benötigte Zeit: " + time + " ms");
			System.out.println("---------------------------------");
			
		}
		
	}
	
	public static int seqSuche(int[] zahlen, int gesucht) {
		int i = 0;
		try {
			while (zahlen[i] != gesucht) {
				i++;
			}
		} catch (Exception e) {
			i = -1;
		}
		return i;
	}
	
	public static int seqSucheGrenze(int[] zahlen, int gesucht) {
		int i = 0;
		while (i < zahlen.length && zahlen[i] != gesucht) {
			i++;
		}
		if (i == zahlen.length) {
			i = -1;
		}
		return i;
	}
	
	public static int seqSucheStop (int[] zahlen, int gesucht) {
		int letzterIndex = zahlen.length -1;
		int letzteZahl = zahlen[letzterIndex];
		zahlen[letzterIndex] = gesucht;
		int i = 0;
		while (zahlen[i] != gesucht) {
			i++;
		}
		if (i == letzterIndex && gesucht != letzteZahl) {
			i = -1;
		}
		zahlen[letzterIndex] = letzteZahl;
		return i;
	}
	
	public static int seqSucheFor (int[] zahlen, int gesucht) {
		int i;
		for (i = 0; i < zahlen.length && zahlen[i] != gesucht; i++) {
			;
		}
		if (i == zahlen.length) {
			i = -1;
		}
		return i;
	}
	
	public static int[] randIntArr(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * n);
		}
		return arr;
	}
	
	public static int[] ordIntArr(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	public static boolean istGeordnet(int[] zahlen) {
		boolean unordnungGefunden = false;
		int i = 0;
		while (!unordnungGefunden && (i < zahlen.length -1)) {
			unordnungGefunden = zahlen[i] > zahlen[i+1];
			i++;
		}
		if (!unordnungGefunden)
			System.out.println("Array ist geordnet.");
		else
			System.out.println("Array ist ungeordnet.");
		return !unordnungGefunden;
	}
	
	public static int binSucheRek(int[] zahlen, int gesucht, int von, int bis) {
		int pos = -1;
		if (von <= bis) {
			int mitte = (von + bis)/2;
			if (gesucht > zahlen[mitte]) {
				pos = binSucheRek(zahlen, gesucht, mitte+1, bis);
			} else {
				if (gesucht < zahlen[mitte]) {
					pos = binSucheRek(zahlen, gesucht, von, mitte-1);
				}else {
					pos = mitte;
				}
			}
		}
		return pos;
		
	}
	
	public static int binSucheIt(int[] zahlen, int gesucht, int von, int bis) {
		int pos = -1;
		int mitte;
		while ((von <= bis) && (pos == -1)) {
			mitte = (von + bis) / 2;
			if (gesucht > zahlen[mitte]) {
				von = mitte + 1;
			} else if (gesucht < zahlen[mitte]) {
				bis = mitte - 1;
			} else 
			{
				pos = mitte;
			}
		}
		
		return pos;
		
	}
	
	public static int binSearch(int[] zahlen, int gesucht) {
		return binSucheRek(zahlen, gesucht, 0, zahlen.length-1);
	}
	
	public static int binSearch2(int[] zahlen, int gesucht) {
		return binSucheIt(zahlen, gesucht, 0, zahlen.length-1);
	}
		
}
