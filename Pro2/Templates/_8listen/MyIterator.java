package _8listen;

import java.util.Iterator;

public class MyIterator <E> implements Iterator<E>{
	
	//aktuelles Element
	private MyListElement<E> currentElement; 

	public MyIterator(MyListElement<E> firstElement) {
		currentElement = firstElement;
		//beim Start ist das erste Element in der Liste gleichzeitig das aktuelle Element	
	}
	
	@Override
	public boolean hasNext() {
		// Nächstes Element nicht leer?
		return currentElement != null;
	}

	@Override
	public E next() {
		E data  = currentElement.getData();
		currentElement = currentElement.getNext();
		return data;
	}

}
