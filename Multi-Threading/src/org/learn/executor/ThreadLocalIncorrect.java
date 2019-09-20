package org.learn.executor;

public class ThreadLocalIncorrect {
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Counter counter1 = new Counter();
		IncrementingThread in = new IncrementingThread(counter);
		DecrementingThread de = new DecrementingThread(counter);
		in.start();
		de.start();
		in.join();
		de.join();
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
		}
}

class DecrementingThread extends Thread {
	Counter counter;
	
	public DecrementingThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
	//	System.out.println(counter.getValue());
			counter.decrement();
	}
}

class Counter {

	private static final ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
		
		@Override
		public Integer initialValue() {
			return Integer.valueOf(0);
		}
	};

	 
	  public void increment() {
			for(int i =0; i<1000; i++) {
				count.set(count.get().intValue() +1);			
			}
			System.out.println("After Incrementing count is "+count.get());
		}


  public void decrement() {
	  for(int i =0; i<1000; i++) {
			count.set(count.get().intValue() -1);			
		}
		System.out.println("After Decrementing count is "+count.get());		 
  	}


}