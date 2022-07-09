package _5callableThreadReadWriteLock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VerwaltungFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long n = 25; //Welchen Wert hat die Fibonaccizahl an der Stelle n
		
		ExecutorService verwalter = Executors.newFixedThreadPool(2);
		
		Callable<Long> t1 = new FibonacciBerechnung(n - 1);
		Callable<Long> t2 = new FibonacciBerechnung(n - 2);
		
		Future<Long> ergebnis1 = verwalter.submit(t1);
		Future<Long> ergebnis2 = verwalter.submit(t2);
		
		try {
			long gesamtErgebnis = ergebnis1.get() + ergebnis2.get();
			//in get() steckt das Ergebnis der Teilberechnung
			//er wartet bei get() solange, bis das Ergebnis vorliegt
			System.out.println("Fibonaccizahl an Stelle " + n + " ist " + gesamtErgebnis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		verwalter.shutdown();

	}

}
