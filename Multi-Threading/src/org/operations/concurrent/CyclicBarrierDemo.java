package org.operations.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		BarrierMaster br = new BarrierMaster();
		CyclicBarrier barrier = new CyclicBarrier(3, br);
		Thread t1 = new Thread(new Task(barrier), " My_Thread 1");
		Thread t2 = new Thread(new Task(barrier), " My_Thread 2");
		Thread t3 = new Thread(new Task(barrier), " My_Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class BarrierMaster implements Runnable {

	@Override
	public void run() {
		System.out.println("Thank You EveryOne");
		
	}
	
}

class Task implements Runnable {
	
	private CyclicBarrier barrier;
	
	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" : I am done with my task");
		try {
			barrier.await();
			System.out.println(Thread.currentThread().getName()+" : I am done with another task");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}