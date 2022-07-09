package _8sammlungen;

import java.util.HashSet;
import java.util.TreeSet;

public class Sets {
	//Unsortiert
	private HashSet<String> Hash;
	//Sortiert
	private TreeSet<String> Tree;

	public static void main(String[] args) {
		Sets f = new Sets();
		f.add("Freund1");
		f.add("Freund2");
		f.add("Freund3");
		f.add("Freund4");
		f.add("Freund5");
		f.add("Freund6");
		f.add("Freund1");
		f.add("Freund2");
		f.add("Freund3");
		f.show();
	}
	
	public Sets() {
		Hash = new HashSet<String>();
		Tree = new TreeSet<String>();
		
	}
	
	public void add(String name) {
		Hash.add(name);
		Tree.add(name);
	}
	
	public void show() {
		System.out.println("HashSet:");
		for (String s : Hash) {
			System.out.println(s);
		}
		System.out.println("------------------------------");
		System.out.println("TreeSet: ");
		for (String s : Tree) {
			System.out.println(s);
		}
	}

}
