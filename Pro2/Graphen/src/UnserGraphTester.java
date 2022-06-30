

public class UnserGraphTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnserGraph ug = new UnserGraph(13);
		//kleinster: 0 und groesster Knoten: 12
		ug.addKante(0, 1);
		ug.addKante(0, 3);
		ug.addKante(0, 4);
		ug.addKante(1, 4);
		ug.addKante(2, 3);
		ug.addKante(2, 5);
		ug.addKante(3, 6);
		ug.addKante(3, 4);
		ug.addKante(4, 10);
		ug.addKante(5, 9);
		ug.addKante(6, 9);
		ug.addKante(6, 7);
		ug.addKante(7, 8);
		ug.addKante(8, 9);
		ug.addKante(10, 11);
		ug.addKante(11, 12);

		ug.gibAus();
		
		Tiefensuche ts = new Tiefensuche(ug, 0);
		ts.gibWegAus(0, 8);
		Breitensuche bs = new Breitensuche(ug, 0);
		bs.gibWegAus(0, 8);
	}

}
