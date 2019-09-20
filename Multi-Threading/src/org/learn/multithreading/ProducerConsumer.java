package org.learn.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		Producer p = new Producer(q);
		Producer p1 = new Producer(q);
		Consumer c = new Consumer(q);
		Thread t1 = new Thread(p, "producer thread");
		Thread t2 = new Thread(c, "consumer thread");
		Thread t3 = new Thread(p1, "second producer thread");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Producer implements Runnable{
	Queue<Integer> q;
	
	public Producer(Queue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		int i=0;
		while(i++ < 20) {
			synchronized (q) {
			while(q.size() == 3) {
				try {
					System.out.println(Thread.currentThread().getName()+" Queue is full waiting for consumer to consume");
					
					q.wait();
				} catch(InterruptedException e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
			
			Random r = new Random();
			int val = r.nextInt();
			q.add(val);
			System.out.println("item produced: "+val);
			q.notifyAll();
			}
		}
		
		
	}
	
}

class Consumer implements Runnable {	
	Queue<Integer> q;
	
	public Consumer(Queue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		int i = 0;
		while(i++ < 20) {
			synchronized (q) {
			while(q.isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName()+" Queue is empty waiting for producer to produce");
				
					q.wait();
				} catch (InterruptedException e) {	
					e.printStackTrace();
				}
			}
			System.out.println("item consumed: "+q.remove());
		
			q.notifyAll();
		}
		}
	}
	
}
