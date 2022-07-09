package _8listen;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E> implements Iterable<E> {
	// nur das 1. Element wird gespeichert
	private MyListElement<E> firstElement;

	public MyList() {
		firstElement = null;
	}

	@Override
	public Iterator<E> iterator() {
		// erstes Element an Iterator übergeben
		return new MyIterator<E>(firstElement);
	}

	public void add(E data) {
		MyListElement<E> newElement = new MyListElement<E>(firstElement, data);
		// Am Anfang einfügen
		firstElement = newElement;
	}

	public E remove() throws NoSuchElementException {
		if (firstElement == null) {
			throw new NoSuchElementException("keine Elemente mehr");
		}
		MyListElement<E> tmp = firstElement;
		firstElement = tmp.getNext();
		return tmp.getData();
	}

	public String toString() {
		String tmp = "";
		//Laufvariable
		MyListElement<E> currentElement = firstElement;
		while(currentElement != null) {
			tmp = tmp + "->" + currentElement.getData();
			currentElement = currentElement.getNext();
		}
		return tmp;
	}
}
