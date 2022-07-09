package _9baeume;

public class SimpleBaum {
	
	private SimpleNode wurzel; //Baum kennt nur die Wurzel
	
	public SimpleBaum(){
		wurzel = null; //erzeugt einen leeren Baum
	}
	
	public SimpleBaum(int wert){
		wurzel = new SimpleNode(null,wert,null);
		//erzeugt ein Blatt
	}
	
	public SimpleBaum(SimpleBaum linkerTB, int wert, SimpleBaum rechterTB){
		wurzel = new SimpleNode(linkerTB.wurzel,wert,rechterTB.wurzel);
		
		//erzeugt einen knoten
		//werden meistens zu durchlaufen des Baumes benötigt
	}

}
