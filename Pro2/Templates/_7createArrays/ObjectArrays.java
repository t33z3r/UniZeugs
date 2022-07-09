package _7createArrays;

import java.util.Arrays;

public class ObjectArrays {
	
	public static void printArray(Object[] objekte) {
	    System.out.println(Arrays.toString(objekte));
	  }

	  public static boolean istGeordnet(Comparable[] arr) {
	    boolean unordnungGefunden = false;
	    int i = 0;
	    while ( (!unordnungGefunden) && (i + 1 < arr.length)) {
	      unordnungGefunden = (arr[i].compareTo(arr[i + 1]) > 0);
	      i = i + 1;
	    }
	    return !unordnungGefunden;
	  }

	  public static Integer[] bestIntegerArray(int n) {
	    Integer[] objekte = new Integer[n];
	    for (int i = 0; i < n; i++) {
	      objekte[i] = i;//new Integer(i);
	    }
	    return objekte;
	  }

	  public static Integer[] worstIntegerArray(int n) {
	    Integer[] objekte = new Integer[n];
	    for (int i = 0; i < n; i++) {
	      objekte[i] = n - 1 - i;//new Integer(n - 1 - i);
	    }
	    return objekte;
	  }

	  public static Integer[] randIntegerArray(int n) {
	    Integer[] objekte = new Integer[n];
	    for (int i = 0; i < n; i++) {
	      objekte[i] = (int) (Math.random() * n);//new Integer( (int) (Math.random() * n));
	    }
	    return objekte;
	  }

	  public static Integer[] constIntegerArray(int n) {
	    Integer[] objekte = new Integer[n];
	    for (int i = 0; i < n; i++) {
	      objekte[i] = 0;//new Integer(0);
	    }
	    return objekte;
	  }

}
