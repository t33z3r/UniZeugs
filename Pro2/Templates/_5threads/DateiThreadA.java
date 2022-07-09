package _5threads;

import java.util.Date;

public class DateiThreadA implements Runnable{
	
	/*
	 * Das Interface Runnable ermöglicht es eine Klasse/Methode in einen eigenen Thread
	 * (Prozess auf dem Rechner) auszuführen
	 */
	
	public void run() {
		machWas();
	}
	
	public void machWas() {
		for(int m = 0; m < 20; m++) {
			System.out.println(
				Thread.currentThread().getName() + 
				" - " +
				new Date()
				);		
			try {
				Thread.sleep((long)(Math.random()*10000));
				/*
				 * Thread wartet zwischen 0 bis < 10 Sekunden
				 */
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
	}

}
