package org.operations.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	Semaphore binary = new Semaphore(1);
	public static void main(String[] args) {
		
		final SemaphoreDemo test = new SemaphoreDemo();
		
		new Thread("My_Thread_1") {
			@Override
			public void run(){
				test.mutualExclusion();
			}
		}.start();
		
		new Thread("My_Thread_2") {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();		

	}

	public void mutualExclusion() {
		try {
			binary.acquire();
			System.out.println(Thread.currentThread().getName()+" :inside mutual Exclusive");
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName()+" :outside mutual exclusive");
		}
	}
}
