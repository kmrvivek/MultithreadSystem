package org.hacker.queue;

public class MultiTreadSapiens {

	public static void main(String[] args) throws InterruptedException {
		Batting b = new Batting();
		Bowling b2 = new Bowling(b);
		Thread t1 = new Thread(b);
		Thread t2 = new Thread(b2);
		t1.start();
		t2.start();
		t1.join();

	}

}


class Batting implements Runnable {

	@Override
	public void run() {
		synchronized(this) {
			for(int i=0; i<100000; i++) {
				System.out.println("Batting is done "+i);
			}
		
		}
	
		
	}
	
}

class Bowling implements Runnable {
	
	private Batting batting;
	
	public Bowling(Batting batting) {
		this.batting  = batting;
	}

	@Override
	public void run() {
		synchronized (batting) {
					System.out.println("bowling done");
		}
		
	}
	
}
