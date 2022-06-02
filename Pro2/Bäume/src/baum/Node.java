package baum;

public class Node {
	
	// entspricht Blatt oder Knoten
	//Blatt hat keinen Nachfolger
	//Knoten hat mind. einen Nachfolger
	//Wurzel hat keine Vorgängerknoten
	
	private int wert;//Wert der gespeichert werden soll
	private Node linkerTB;//linker Teilbaum
	private Node rechterTB;//rechter Teilbaum
	
	public Node(Node linkerTB, int wert, Node rechterTB){
		this.linkerTB = linkerTB;
		this.rechterTB = rechterTB;
		this.wert = wert;
		
	}

	public static void main(String[] args){		
		
		}

}
