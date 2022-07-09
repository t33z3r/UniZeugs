package _2random;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ZufallszahlenGenerator zg1 = new ZufallszahlenGenerator();
		ZufallszahlenGenerator zg2 = new ZufallszahlenGenerator(1);
		System.out.println(zg2.generiereZahl(1));
		System.out.println(zg2.generiereZahl());
		System.out.println(zg2.zufallsDouble());
		System.out.println(zg2.zufallsDouble(10));
		System.out.println(zg2.zufallsInt(100));
	}

}
