package p3;

import java.util.Arrays;

public class UnSort {

	public static void unsortieren(int[] zahlen)
    {
       for(int i = 0; i < zahlen.length; i++)
       {
           int randpos = (int)(Math.random() * (zahlen.length));
           vertauschen(zahlen, i, randpos);
       }
   }
	
	public static void vertauschen(int[] zahlen, int i, int j)
    {
        int hilf = zahlen[i];
        zahlen[i] = zahlen[j];
        zahlen[j] = hilf;
    }
	
	public static void main(String[] args)
    {
       int anzahlKlein = 10;
       int[] a;

       a = bestArray(anzahlKlein);
       printArray(a);
       System.out.println("\nunsortieren liefert ");
       unsortieren(a);
       printArray(a);
   }
	
	public static void printArray(int[] zahlen)
    {
         System.out.print(Arrays.toString(zahlen));
    }
	
	public static int[] bestArray(int n)
    {
       int[] zahlen = new int[n];
       for(int i = 0; i < n; i++)
       {
          zahlen[i] = i ;
       }
       return zahlen;
    }
}
