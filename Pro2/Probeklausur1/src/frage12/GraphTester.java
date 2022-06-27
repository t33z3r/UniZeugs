package frage12;

public class GraphTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Erstellen des MeinGraph-Objekts
		MeinGraph mg1 = new MeinGraph();
		
		//Eintragen der Kanten 		
		mg1.addKante(0, 1);
		mg1.addKante(0, 2);
		mg1.addKante(2, 3);
		mg1.addKante(1, 4);
		mg1.addKante(0, 5);
		//Ausgabe der Anzahl
		mg1.getAnzahlKante();
		//Abspeichern in die Datei Nachbarn
		//Bei Eclipse einfach einen Refresh auf dem Projekt-Ordner ausführen, 
		//um die neue Datei zu sehen 
		mg1.speichereNachbarschaften(".\\Nachbarn");
		
		//Prozedur zum Auslesen aus der abgespeicherten Datei
		
		MeinGraph mg2 = new MeinGraph();
		//Aus Datei lesen
		mg2.ladeNachbarschaften(".\\Nachbarn");
		//Ausgabe der Kantenanzahl
		mg2.getAnzahlKante();
		//Ausgabe der einzelnen Kanten
		for (Kante k : mg2.getNachbarschaften()) {
			System.out.println(k.getVon() + " - " + k.getNach());
		}
	}

}
