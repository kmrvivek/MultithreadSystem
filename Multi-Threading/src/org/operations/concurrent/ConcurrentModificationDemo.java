package org.operations.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationDemo implements Runnable{

	//private static List<String> ls = new ArrayList<>();
	
	/* Using Concurrent CoppyOnArrayList for achieving concurrency */
	 
	
	private static List<String> ls = new CopyOnWriteArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		ConcurrentModificationDemo demo = new ConcurrentModificationDemo();
		ls.add("Ram");
		ls.add("Balram");
		ls.add("Shyam");
		ls.add("Raju");
			
		Thread t = new Thread(demo);
		t.start();
		
		Iterator<String> itr = ls.iterator();		
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println("Main thread accessing "+name);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(ls);
	}

	@Override
	public void run() {
	
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		ls.add("Vivek");
		ls.add("Shilpa");
	}

}
