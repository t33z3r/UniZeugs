package _3arrayContains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lottozahlen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] zahlen  = new Integer[7];
		//Lottozahlen + Zusatzzahl
		Random rnd = new Random();
		
		for(int m = 0; m < 6 ; m++) {
			int zahl = -1;
			do {
				zahl = rnd.nextInt(49)+1;//1-49
				
			}while(Arrays.asList(zahlen).contains(zahl));
			zahlen[m] = zahl;
		}
		
		zahlen[6] = rnd.nextInt(10);
		
		System.out.println("Lottozahlen:");
		for(int m = 0; m<6; m++) {
			System.out.println(zahlen[m]);
		}
		System.out.println("Zusatzzahl: "+ zahlen[6]);
	}

}
