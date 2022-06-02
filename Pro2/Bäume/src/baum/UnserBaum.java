package baum;

public class UnserBaum {
	
	private Node wurzel; //Baum kennt nur die Wurzel
	
	public UnserBaum(){
		wurzel = null; //erzeugt einen leeren Baum
	}
	
	public UnserBaum(int wert){
		wurzel = new Node(null,wert,null);
		//erzeugt ein Blatt
	}
	
	public UnserBaum(UnserBaum linkerTB, int wert, UnserBaum rechterTB){
		wurzel = new Node(linkerTB.wurzel,wert,rechterTB.wurzel);
		
		//erzeugt einen knoten
		//werden meistens zu durchlaufen des Baumes benötigt
	}

}
