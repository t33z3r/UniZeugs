package _2random;

public class ZufallszahlenGenerator {

	private long aktuellerWert = 0;
	
	//private static long a = 3421;
	//private static long c = 1;
	//private static long m = 65536;
	private static double x = 0;
	
	
	private static long a = 9301;
	private static long c = 49297;
	private static long m = 233280;
	
	
	/* 
     * private static long a = 25214903917L;
	 * private static long c = 11;
	 * private static long m = 281474976710655L;
	 */
	
	public ZufallszahlenGenerator(long startwert) {
		aktuellerWert = startwert;
		aktuellerWert = (aktuellerWert * a + c) % m;
	}
	
	ZufallszahlenGenerator(){
		aktuellerWert = Math.abs(System.currentTimeMillis());
	}
	
	public double generiereZahl() {
		aktuellerWert = (aktuellerWert * a + c) % m;
		return x = (double) aktuellerWert;
	}
	
	public double generiereZahl(double startwert) {
		aktuellerWert = (long) startwert;
		aktuellerWert = (aktuellerWert * a + c) % m;
		return x = (double) aktuellerWert;
	}
	
	public double zufallsDouble() {
		aktuellerWert = (aktuellerWert * a + c) % m;
		x = (double)aktuellerWert / (double)m;
		return x;
	}
	
	public double zufallsDouble(double max) {
		aktuellerWert = (aktuellerWert * a + c) % m;
		x = (double)aktuellerWert / (double)m;
		double y = x * (max-1) + 1;
		return y;
	}
	
	public int zufallsInt(int max) {
		aktuellerWert = (aktuellerWert * a + c) % m;
		x = ((double)aktuellerWert) / m;
		int result = (int) (x * (max)+1);
		return result;
	}
	
}
