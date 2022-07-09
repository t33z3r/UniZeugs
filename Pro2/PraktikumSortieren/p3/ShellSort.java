package p3;

public class ShellSort {
	
	private static Sortieren s = new Sortieren();

	public static void main(String[] args) {
		
		int anzahl = 8;
		long t1, t2;
		
		int[] bestArr = s.bestArray(anzahl);
		int[] worstArr = s.worstArray(anzahl);
		int[] randArr = s.randArray(anzahl);

		//Ausgabe für das Prinzip

		int[] num = randArr.clone();
		s.printArray(num);
		shellSort1(num);
		s.printArray(num);
		
		num = randArr.clone();
		shellSort2(num);
		num = randArr.clone();
		shellSort3(num);
		num = randArr.clone();
		shellSort4(num);
		
		
	}
	
	// Shell-Sort - 1. Distanzfolge:  h0 = objekte.length / 2;
	  //                   h  = h / 2;
	public static void shellSort1(int[] num) {
		int i, j, h;
	    int hilf;
	    for (h = num.length / 2; h > 0; h = h / 2) {
	    	System.out.println("for1");
	    	System.out.println("h: " + h);
	      for (i = h; i < num.length; i++) {
	    	  System.out.println("for2");
	    	  System.out.println("h: " + h);
	        hilf = num[i];
	        System.out.println("hilf: " + hilf);
	        j = i;
	        System.out.println("i: " + i);
	        while ( (j >= h) && (num[j - h] > hilf)) {
	        	System.out.println("while");
	        	System.out.println("j: " + j);
	          num[j] = num[j - h];
	          j = j - h;
	          System.out.println("j: " + j);
	          s.printArray(num);
	        }
	        num[j] = hilf;
	        s.printArray(num);
	      }
	    }
	}
	
	// Shell-Sort - 2. Distanzfolge:  h0 =  2*t  < num.length ;
	  //                                h  = h / 2;
	  public static void shellSort2(int[] num) {
	    int i, j, h;
	    int hilf;
	    // Anfangswert fuer h finden
	    h = 1;
	    do {
	      h = 2 * h;
	    }
	    while (h < num.length);
	    // h wurde soeben initalisiert
	    for ( ; h > 0; h = h / 2) {
	      for (i = h; i < num.length; i++) {
	        hilf = num[i];
	        j = i;
	        while ( (j >= h) && (num[j - h] > hilf)) {
	          num[j] = num[j - h];
	          j = j - h;
	        }
	        num[j] = hilf;
	      }
	    }
	  }

	  // Shell-Sort - 3. Distanzfolge:  h0 =  2**t - 1  < num.length ;
	  //                                h  = h / 2;
	  // nach D.E.Knuth
	  public static void shellSort3(int[] num) {
	    int i, j, h;
	    int hilf;
	    // Anfangswert fuer h finden
	    h = 1;
	    do {
	      h = 2 * h;
	    }
	    while (h - 1 < num.length);
	    for (h = h - 1; h > 0; h = h / 2) {
	      for (i = h; i < num.length; i++) {
	        hilf = num[i];
	        j = i;
	        while ( (j >= h) && (num[j - h] > hilf)) {
	          num[j] = num[j - h];
	          j = j - h;
	        }
	        num[j] = hilf;
	      }
	    }
	  }

	  // Shell-Sort - 4. Distanzfolge:  h0 = 3 * h + 1 <=  num.length / 9 ;
	  //                                h  = h / 3;
	  // nach R. Sedgewick
	  public static void shellSort4(int[] num) {
	    int i, j, h;
	    int hilf;
	    // Anfangswert fuer h finden
	    for (h = 1; h <= num.length / 9; h = 3 * h + 1) {}
	    // h wurde soeben initalisiert
	    for (; h > 0; h = h / 3) {
	      for (i = h; i < num.length; i++) {
	        hilf = num[i];
	        j = i;
	        while ( (j >= h) && (num[j - h] > hilf)) {
	          num[j] = num[j - h];
	          j = j - h;
	        }
	        num[j] = hilf;
	      }
	    }
	  }

}
