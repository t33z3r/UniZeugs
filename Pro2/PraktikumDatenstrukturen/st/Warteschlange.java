package st;

import java.util.NoSuchElementException;

public class Warteschlange<E> {
	
	private DLRList<E> queue;
	
	public Warteschlange() {
		queue = new DLRList<E>();
	}
	
	public E element() throws NoSuchElementException{
		if (queue.isEmpty()) {
			throw new NoSuchElementException("Warteschlange leer");
		}
		return queue.getFirst();
	}
	
	public E peek() {
		if (queue.isEmpty()) {
			return null;
		}
		return queue.getFirst();
	}
	
	public boolean add(E data) {
		queue.addLast(data);
		return true;
	}
	
	public boolean offer(E data) {
		queue.addLast(data);
		return true;
	}
	
	public E remove() throws NoSuchElementException {
		if (queue.isEmpty()) {
			throw new NoSuchElementException("Queue leer");
		}
		return queue.removeFirst();
	}
	
	public E poll() {
		if (queue.isEmpty()) {
			return null;
		}
		return queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public static void main(String[] args) {
		Warteschlange<Float> fifo = new Warteschlange<Float>();
		System.out.println(fifo);
		for (int i = 0; i < 10; i++) {
			System.out.println("hinten einfügen: " + (1.0f / (i+1)));
			fifo.add(1.0f / (i + 1));
			System.out.println(fifo);
		}
		while (!fifo.isEmpty()) {
			System.out.println(fifo.poll() + " wurde vorne entnommen.");
			System.out.println(fifo);
		}
	}
}
