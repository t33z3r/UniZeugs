package _5threads;

import java.util.Date;

public class DateiThreadB implements Runnable {
	
	public void run() {
		eineMethode();
	}
	
	public void eineMethode() {
		for(int i = 0; i < 20; i++) {
			System.out.println(
					Thread.currentThread().getId() +
					" - " +
					new Date()
					);
			try {
				Thread.sleep((long)(Math.random()*10000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}

}
