package st;

public class DLElement<E> {
	public E data;
	public DLElement<E> next;
	public DLElement<E> previous;
	
	public DLElement() {
		data = null;
		next = null;
		previous = null;
	}
	
	public DLElement(E data, DLElement<E> prev, DLElement<E> next) throws IllegalArgumentException{
		if (data == null) {
			throw new IllegalArgumentException("keine Daten");
		}
		this.data = data;
		this.previous = prev;
		this.next = next;
	}
	
	
}
