package p1;

import java.util.*;

public class Sortieren
{
    // Entwickeln Sie hier Ihre Loesungen





    /**
     *  Unsere Lieblingsmethode
     *
     * @param  args   die Kommandozeilenparameter
     */
     public static void main(String[] args)
     {
        int anzahl = 10;
        int[] a;

        a = bestArray(anzahl);
        System.out.println("aufsteigend geordnetes Array");
        printArray(a);

        a = worstArray(anzahl);
        System.out.println("absteigend geordnetes Array");
        printArray(a);

        a = randArray(anzahl);
        System.out.println("zufälliges Array");
        printArray(a);
     }

    // Hilfsmethoden

    /**
     *  Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param  zahlen  das auszugebende Array von int-Zahlen
     */
     public static void printArray(int[] zahlen)
     {
         System.out.println(Arrays.toString(zahlen));
     }

    /**
     *  Methode zum Erzeugen eines aufsteigend sortierten Arrays von int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array {0, 1, ... , n-1}
     */
     public static int[] bestArray(int n)
     {
        int[] zahlen = new int[n];
        for(int i = 0; i < n; i++)
        {
           zahlen[i] = i ;
        }
        return zahlen;
     }

    /**
     *  Methode zum Erzeugen eines absteigend sortierten Arrays von int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array {n-1, n-2, ... , 0}
     */
     public static int[] worstArray(int n)
     {
          int[] zahlen = new int[n];
          for(int i = 0; i < n; i++)
          {
             zahlen[i] = n - 1 - i;
          }
          return zahlen;
     }

    /**
     *  Methode zum Erzeugen eines Arrays von zufälligen int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array aus Zufallszahlen
     */
     public static int[] randArray(int n)
     {
         int[] zahlen = new int[n];
         for(int i = 0; i < n; i++)
         {
             zahlen[i] = (int)(Math.random() * n);
         }
         return zahlen;
     }
}