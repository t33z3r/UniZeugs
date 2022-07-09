package _8listen;

import java.util.Iterator;

public class MyTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyList<String> liste = new MyList<String>();
		
		liste.add("Hallo");
		liste.add("Heute");
		
		System.out.println(liste);
		
		Iterator<String> iterator = liste.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		liste.remove();
		liste.remove();
		System.out.println(liste);
		liste.remove();
	}

}
