package _9baeume;

public class SimpleNode {
	
	// entspricht Blatt oder Knoten
	//Blatt hat keinen Nachfolger
	//Knoten hat mind. einen Nachfolger
	//Wurzel hat keine Vorgängerknoten
	
	private int wert;//Wert der gespeichert werden soll
	private SimpleNode linkerTB;//linker Teilbaum
	private SimpleNode rechterTB;//rechter Teilbaum
	
	public SimpleNode(SimpleNode linkerTB, int wert, SimpleNode rechterTB){
		this.linkerTB = linkerTB;
		this.rechterTB = rechterTB;
		this.wert = wert;
		
	}

	public static void main(String[] args){		
		
		}

}
