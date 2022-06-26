package frage12;

import java.io.Serializable;

public class Kante implements Serializable {
	
	//NOCH UNFERTIG!!!!
	//KOMMENTARE UND TESTS STEHEN NOCH AUS!!!!
	//TESTER-KLASSE FEHLT AUCH NOCH!!!
	//Das wird in der nächsten Woche nachgeholt ;)
	
	public int getVon() {
		return von;
	}

	public int getNach() {
		return nach;
	}

	private int von = 0;
	private int nach = 0;
	
	public Kante(int von, int nach) {
		this.von = von;
		this.nach = nach;
	}
	
	
}
