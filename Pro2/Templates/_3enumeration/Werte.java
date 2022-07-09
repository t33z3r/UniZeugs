package _3enumeration;

public enum Werte {

	LISA(1),PETER(2), DOENER(3);
	
	private final int zahl;
	//in enum -> Konstante wie Attr.
	
	private Werte(int zahl) {
		this.zahl = zahl;
	}
	public String toString() {
		return "Bezeichnungszahl:"+zahl;
	}
}