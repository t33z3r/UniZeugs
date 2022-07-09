package _8listen;

import java.util.NoSuchElementException;

public class DLRList<E> {
	
	private DLElement<E> entry;
	
	private int size;
	
	public DLRList() {
		entry = new DLElement<E>();
		entry.next = entry;
		entry.previous = entry;
		size = 0;
	}
	
	public E getFirst() throws NoSuchElementException{
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return entry.next.data;
	}
	
	public E getLast() throws NoSuchElementException{
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return entry.previous.data;
	}
	
	private void addBefore(E data, DLElement<E> current) throws IllegalArgumentException {
		DLElement<E> newElement = new DLElement<E>(data, current.previous, current);
		newElement.previous.next = newElement;
		newElement.next.previous = newElement;
		size++;
	}
	
	public void addFirst(E data) {
		addBefore(data, entry.next);
	}
	
	public void addLast(E data) {
		addBefore(data, entry);
	}
	
	private E removeElement(DLElement<E> current) throws NoSuchElementException{
		if (entry == current) {
			throw new NoSuchElementException();
		}
		E olddata = current.data;
		current.previous.next = current.next;
		current.next.previous = current.previous;
		current.next = current.previous = null;
		current.data = null;
		size--;
		return olddata;
	}
	
	public E removeFirst() throws NoSuchElementException {
		return removeElement(entry.next);
	}
	
	public E removeLast() {
		return removeElement(entry.previous);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (DLElement<E> current = entry.next; current != entry; current = current.next) {
			sb.append(current.data == this ? "(this List)" : current.data.toString());
			if (current.next != entry) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void clear() {
		DLElement<E> next;
		DLElement<E> current = entry.next;
		while (current != entry) {
			next = current.next;
			removeElement(current);
			current = next;
		}
	}
	
	public static void main(String[] args) {
		DLRList list = new DLRList();
		list.addFirst(String.valueOf("Test"));
		list.addFirst(String.valueOf("Test2"));
		list.addLast(String.valueOf("Test3"));
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}

}
