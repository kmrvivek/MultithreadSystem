package org.learn.multithreading;

public class RaceCondiotion {

	public static void main(String[] args) throws InterruptedException {
		
		Counterr counter = new Counterr();
		IncrementThread in = new IncrementThread(counter);
		DecrementThread de = new DecrementThread(counter);
		in.start();
		de.start();
		in.join();
		de.join();	

		//System.out.println(counter.getValue());
	}

}

class IncrementThread extends Thread {
	Counterr counter;
	
	public IncrementThread(Counterr counter) {
		this.counter = counter;
	}
	
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.increment();
		}
		}
}

class DecrementThread extends Thread {
	Counterr counter;
	
	public DecrementThread(Counterr counter) {
		this.counter = counter;
	}
	
	public void run() {
		System.out.println(counter.getValue());
			counter.decrement();
		}
}

class Counterr {
	int count = 0;
	
	  public void increment() {
				count++;
	}
	
	  public void decrement() {
			 count--;
		 
	}
	
	public int getValue() {
		return count;
	}
}