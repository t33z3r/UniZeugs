package _2recursion;

public class MatheFunktionen {
	
	public static long ackermann( long n, long m) {
		if ( n == 0 ) {
			return m + 1;
		}
		if ( m == 0 ) {
			return ackermann( n - 1, 1 );
		} else {
			return ackermann( n - 1 , ackermann( n , m - 1));
		}
	}
	
	public static long rekursiv(long n) {
		if (n == 0) {
			return 1;
		}
		if (n > 0) {
			return rekursiv((n - 1))+1;
		}else {
			return 0;
		}
	}
	
	public static void hanoi(int anzahl, String quelle, String ziel, String hilfsturm) {
		if (anzahl > 0) {
			hanoi((anzahl-1), quelle, hilfsturm, ziel);
			System.out.println("Scheibe von " + quelle + " nach " + ziel + " legen.");
			hanoi((anzahl-1), hilfsturm, ziel, quelle);
		}
	}
	
	public static void main(String args[]) {
		int x = 3;
		int y = 1;
		System.out.println("Ackermann(" + x + ", " + y + ")= " + ackermann(x,y));
		System.out.println(rekursiv(100));
		hanoi(3, "A", "B", "C");
		
	}

}
