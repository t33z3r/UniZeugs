package _5callableThreadReadWriteLock;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class KritischePosition {
	
	public static void main(String[] args) {
		kritischePosition();
	}
	
	private static void kritischePosition() {
		ArrayList<String> liste = new ArrayList<String>();
		
		ExecutorService verwalter = Executors.newFixedThreadPool(2);
		
		ReadWriteLock schloss = new ReentrantReadWriteLock();
		//in Java bereits definiertes Schloss fuer Lesen und Schreiben
		
		//Schreiber
		verwalter.submit(()->{
			schloss.writeLock().lock();
			try {
				TimeUnit.SECONDS.sleep(2);//Sekunden
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			liste.add("Hanna");
			liste.add("Dirk");
			liste.add("Marie");
			schloss.writeLock().unlock();
		});
		
		//Leser
		Runnable leser = ()->{
			schloss.readLock().lock();
			System.out.println(liste.get(1));
			schloss.readLock().unlock();
		};
		
		verwalter.submit(leser);
		verwalter.shutdown();
		
		/*
		 * wartet bis alle aktiven Threads fertig sind und macht dann den shutdown
		 */
		
		try {
			verwalter.awaitTermination(60, TimeUnit.SECONDS);
			/*
			 * warte 60 Sekunden und dann shutdownNow()
			 */
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
