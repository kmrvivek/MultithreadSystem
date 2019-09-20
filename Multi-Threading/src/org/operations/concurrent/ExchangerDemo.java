package org.operations.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		
		Exchanger<String> e = new Exchanger<>();
		Thread t1 = new Thread(new Exchange("Apple", e), "Thread 1");
		Thread t2 = new Thread(new Exchange("Banana", e), "Thread 2");
		t1.start();
		t2.start();

	}

}

class Exchange implements Runnable{
	private String item;
	private Exchanger<String> e;
	
	public Exchange(String item, Exchanger<String> e) {
		this.item = item;
		this.e = e;
	}

	@Override
	public void run() {
		String previous = this.item;
		try {
			String current = e.exchange(item);
			System.out.println(Thread.currentThread().getName()+" item exchanged "+previous+" for "+current);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
