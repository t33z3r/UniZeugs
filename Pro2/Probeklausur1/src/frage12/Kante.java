package frage12;

import java.io.Serializable;

//erbt vom Interface Serializable
public class Kante implements Serializable {
	
	//Implementierung der gegebenen Methoden/Variablen

	private int von = 0;
	private int nach = 0;
	
	public Kante(int von, int nach) {
		this.von = von;
		this.nach = nach;
	}

	public int getVon() {
		return von;
	}

	public int getNach() {
		return nach;
	}	
	
}
