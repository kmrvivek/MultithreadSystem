package org.multithreading.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClass {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		Counter counter1 = new Counter();
		IncrementingThread in = new IncrementingThread(counter);
		DecrementingThread de = new DecrementingThread(counter);
		in.start();
		de.start();
		in.join();
		de.join();
		System.out.println("Object level count: "+counter.getValue());
		System.out.println("Class level count: "+Counter.getClssValue());

	}

}

class IncrementingThread extends Thread {
	Counter counter;
	
	public IncrementingThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
			counter.increment();		
			Counter.cIncrement();
		}
	}
	
class DecrementingThread extends Thread {
	Counter counter;
	
	public DecrementingThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
			counter.decrement();
			Counter.cDecrement();
		}
	}

class Counter {
	int count = 0;
	static int classLevelCount  = 0;
	Lock lock =  new ReentrantLock();
	static Lock classLock =  new ReentrantLock();
	
	 public static void cIncrement() {
		for(int i =0; i<100000; i++) {
			classLock.lock();
				classLevelCount++;
			classLock.unlock();
		}
	 }
	
		 public static void cDecrement() {
				 for(int i =0; i<100000; i++) {
					classLock.lock();
						 classLevelCount--;
					classLock.unlock();
				 }
		 }
		 
	
	
		  public void increment() {
			 try {
				if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) { 
					for(int i =0; i<20; i++) {					
							count++;	
						System.out.println("Incrementing");	
					}
				 } else {
					 System.out.println("Incrementing : Perform alternative approach");
				 }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	
		 public void decrement() {
			 if(lock.tryLock()) { 
				 for(int i =0; i<20; i++) {
					  count--;
					System.out.println("Decrementing");	
				}
			 } else {
					 System.out.println("Decrementing : Perform alternative approach");
				 }
	 
		 }
		public int getValue() {
			return count;
		}
		
		public static int getClssValue() {
			return classLevelCount;
		}
}