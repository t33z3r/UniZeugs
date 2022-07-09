package _8listen;

import java.util.NoSuchElementException;

public class SimpleList {

	private ListElement first;
	
	//Leere Liste
	public SimpleList() {
		first = null;
	}
	
	//Liste mit Anfangselement
	private SimpleList(ListElement first) {
		this.first = first;
	}
	
	//Liste leer?
	public boolean isEmpty() {
		return (first == null);
	}
	
	//Liste leeren
	public void clear() {
		first = null;
	}
	
	//Get erstes Objekt
	public Object getFirst() throws NoSuchElementException{
		if (first == null) {
			throw new NoSuchElementException("Liste leer");
		}
		return first.data;
	}
	
	//Neues erstes Objekt einfügen
	public void insertFirst(Object data) {
		ListElement e = new ListElement(data, first);
		first = e;
	}
	
	//erstes Datenobjekt zurückgeben und anschließend löschen
	public Object deleteFirst() throws NoSuchElementException{
		if (first == null) {
			throw new NoSuchElementException("Liste leer");
		}
		ListElement e = first;
		first = first.next;
		return e.data;
	}
	
	//toString rekursiv
	
	public String toString() {
		String str = "";
		if (first != null) {
			SimpleList rest = new SimpleList(first.next);
			str = " -> " + first.data + rest.toString();
		}
		return str;
	}
	
	
	//toString iterativ
	/*
	public String toString() {
		String str = "";
		int count = 0;
		while (first != null) {
			str += " -> " + deleteFirst();
		}		
		return str;
	}
	*/
	
	public static void main(String[] args) {
		SimpleList sl = new SimpleList();
		System.out.println(sl);
		for (int i = 0; i < 10; i++) {
			sl.insertFirst(i);
			System.out.println(sl);
		}
		System.out.println();
		
	}
	
	
}
