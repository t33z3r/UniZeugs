package frage12;

public class GraphTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MeinGraph mg1 = new MeinGraph();
		
		//Prozedur zum Eintragen + Abspeichern 
		
		mg1.addKante(0, 1);
		mg1.addKante(0, 2);
		mg1.addKante(2, 3);
		mg1.addKante(1, 4);
		mg1.addKante(0, 5);
		System.out.println(mg1.getAnzahlKante());
		mg1.speichereNachbarschaften(".\\Nachbarn");
		
		//Prozedur zum Auslesen aus der abgespeicherten Datei
		
		MeinGraph mg2 = new MeinGraph();
		
		mg2.ladeNachbarschaften(".\\Nachbarn");
		System.out.println(mg2.getAnzahlKante() + " Kanten enthalten.");
		for (Kante k : mg2.getNachbarschaften()) {
			System.out.println(k.getVon() + " - " + k.getNach());
		}
	}

}
