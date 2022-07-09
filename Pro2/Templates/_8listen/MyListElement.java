package _8listen;

public class MyListElement <E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private MyListElement<E> next = null;//Nachfolger
	private E data = null; //Daten
	
	public MyListElement(MyListElement<E> next, E data) {
		this.next = next;
		this.data = data;
	}
	
	public MyListElement<E> getNext(){
		return next;
	}
	
	public E getData() {
		return data;
	}

}
