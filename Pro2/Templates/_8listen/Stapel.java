package _8listen;

import java.util.NoSuchElementException;

public class Stapel {

	private SimpleList stack;
	
	public Stapel() {
		stack = new SimpleList();
	}
	
	public void push(Object object) {
		stack.insertFirst(object);
	}
	
	public Object pop() throws NoSuchElementException{
		return stack.deleteFirst();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public static void main(String[] args) {
		Stapel stack = new Stapel();
		System.out.println(stack);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		System.out.println("--------------------");
		for (int i = 0; i < 10; i++) {
			stack.pop();
			System.out.println(stack);
		}
		System.out.println("-----Fehler-----");
		stack.pop();
	}
}
