package org.learn.multithreading;

public class ResourceAllocation {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		Counter counter1 = new Counter();
		IncrementingThread in = new IncrementingThread(counter);
		DecrementingThread de = new DecrementingThread(counter);
		in.start();
		de.start();
		in.join();
		de.join();
		System.out.println(counter.getValue());
		System.out.println(Counter.getClssValue());

	}

}

class IncrementingThread extends Thread {
	Counter counter;
	
	public IncrementingThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		synchronized (counter) {
			counter.increment();
		}			
			Counter.cIncrement();
		}
}

class DecrementingThread extends Thread {
	Counter counter;
	
	public DecrementingThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
//		System.out.println(counter.getValue());
			counter.decrement();
			Counter.cDecrement();
		}
}

class Counter {
	int count = 0;
	static int classLevelCount  = 0;
	
/*	 synchronized public static void cIncrement() {
			for(int i =0; i<100000; i++) {
				//System.out.println("Increment Method");
				classLevelCount++;
			}
	}
	
	 synchronized public static void cDecrement() {
		 for(int i =0; i<100000; i++) {
			// System.out.println("Decrement Method");
			 classLevelCount--;
		 }
	}*/
	
	 public static void cIncrement() {
		for(int i =0; i<100000; i++) {
			//System.out.println("Increment Method");
			synchronized (Counter.class) {
				classLevelCount++;
			}
			
		}
	 }

		 public static void cDecrement() {
				 for(int i =0; i<100000; i++) {
					// System.out.println("Decrement Method");
					 synchronized (Counter.class) {
						 classLevelCount--;
					}
					
				 }
		 }
		 
		  public void increment() {
				for(int i =0; i<200000; i++) {
						count++;			
				}
			}
	
/*	  public void increment() {
			for(int i =0; i<200000; i++) {
				//System.out.println("Increment Method");
				synchronized (this) {
					count++;
				}
			
			}
	}*/
	
	  public void decrement() {
		 for(int i =0; i<200000; i++) {
			// System.out.println("Decrement Method");
			 synchronized (this) {
				 count--;
			}
			 
		 }
	}
	
	public int getValue() {
		return count;
	}
	
	public static int getClssValue() {
		return classLevelCount;
	}
}