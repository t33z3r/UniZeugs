package _5threads;

import java.util.ArrayList;

public class Verwaltungsklasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread tA = new Thread(new DateiThreadA());
		/*
		 * neuen Thread erzeugen -> Klasse/Methode die ausgefuehrt werden sollen
		 */
		Thread tB = new Thread(new DateiThreadB());
		tA.start();
		/*
		 * starten des Threads
		 */
		tB.start();//nach tA und tB start haben wir 3 Thread(main, tA und tB)
		/*
		while(tA.isAlive()) {//aller 10 Sekunden pruefen
			System.out.println("er lebt noch");
			try {
				Thread.sleep(10000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		/*
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int m = 0; m < 100; m++) {
			threads.add(new Thread(new DateiThreadA()));
			threads.add(new Thread(new DateiThreadB()));
		}
		for(Thread t : threads) {
			t.start();
		}*/
		//nach t.start -> 3 Threads(main, tA, tB) + 200 t.start
	}

}
