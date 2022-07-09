package _2random;

public class WürfelTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int anzahl = 30;
		int summe = 0;
		double durchschnitt = 0;
		int[] ergebnisse = new int[30];
		
		int[] h = new int[6];
		
		ZufallszahlenGenerator zg = new ZufallszahlenGenerator();
		
		for (int i=1;i<=anzahl;i++) {
			ergebnisse[(i-1)] = zg.zufallsInt(6);
			System.out.print(ergebnisse[(i-1)] + ", ");
			switch (ergebnisse[(i-1)]) {
			case 1: h[0] += 1;
			break;
			case 2: h[1] += 1;
			break;
			case 3: h[2] += 1;
			break;
			case 4: h[3] += 1;
			break;
			case 5: h[4] += 1;
			break;
			case 6: h[5] += 1;
			break;
			}
				
		}
		
		System.out.println();
		
		/*System.out.println();
		for (int i=0;i<ergebnisse.length;i++) {
			System.out.println(ergebnisse[i]);
		}*/
		
		for (int i=0;i<ergebnisse.length;i++) {
			summe += ergebnisse[i];
		}
		System.out.println("Summe: " + summe);
		
		for (int i=0;i<ergebnisse.length;i++) {
			if (i != 0) {
				durchschnitt = (durchschnitt+ergebnisse[i])/2;
			}
			if (i == 0) {
				durchschnitt += ergebnisse[i];
			}
		}
		System.out.println("Durchschnitt: " + durchschnitt);
		System.out.println("Relative Häufigkeiten:");
		System.out.println("Eins: " + ((double)h[0]/anzahl)*100);
		System.out.println("Zwei: " + ((double)h[1]/anzahl)*100);
		System.out.println("Drei: " + ((double)h[2]/anzahl)*100);
		System.out.println("Vier: " + ((double)h[3]/anzahl)*100);
		System.out.println("Fünf: " + ((double)h[4]/anzahl)*100);
		System.out.println("Sechs: " + ((double)h[5]/anzahl)*100);
		
	}

}
