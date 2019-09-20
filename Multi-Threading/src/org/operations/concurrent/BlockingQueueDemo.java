package org.operations.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<Obj> bq = new LinkedBlockingQueue<>();
		
		Thread t1 = new Thread(new Producers(bq),"Producer 1");
		Thread t2 = new Thread(new Producers(bq), "Producer 2");
		
		Thread t3 = new Thread(new Consumers(bq), "Consumer 1");
		Thread t4 = new Thread(new Consumers(bq), "Consumer 2");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class Consumers implements Runnable {
	private BlockingQueue<Obj> bq;
	
	public Consumers(BlockingQueue<Obj> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		
		for(int i=0; i<50; i++) {
			try {
				Obj obj = bq.take();
				System.out.println("Consuming Object "+obj.name+"  "+Thread.currentThread().getName());
				if(bq.isEmpty()) {
					System.out.println("waiting .....");
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}	
	
}	

class Producers implements Runnable {
	
	private BlockingQueue<Obj> bq;
	
	public Producers(BlockingQueue<Obj> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		
		for(int i=0; i<50; i++) {
			Obj obj = new Obj("My Object--> "+i);
			System.out.println("Producing Object "+obj.name+"  "+Thread.currentThread().getName());
			try {
				bq.put(obj);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


class Obj {
	 String name;
	public Obj(String name) {
		this.name = name;
	}
}