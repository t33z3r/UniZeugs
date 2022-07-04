package p2;

import java.util.Arrays;

public class SucheObjekte {

	public static void main(String[] args) {
		//Eigentlich genau dasselbe, wie zuvor nur statt int[]-Arrays Integer-Objekt-Arrays
		int anzahl = 10;
		Integer[] objekte;
		Integer gesucht;
		int pos;
		
		objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;
        System.out.println("sequentielle Suche mit Ausnahme-Behandlung");
        pos = seqSucheMitException(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();
	}
	
	public static Integer[] randIntegerArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n); 
        }
        return arr;
    }
	
	public static Integer[] ordIntegerArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
	
	//Beispielmethode - Rest siehe SucheSeqBin.java
	public static int seqSucheMitException(Object[] objekte, Object gesucht) {
        int i = 0;
        try {
            while (!objekte[i].equals(gesucht)) {
                i = i + 1;
            }
        } catch (Exception e) {
            i = -1;
        }
        return i;
    }

}
