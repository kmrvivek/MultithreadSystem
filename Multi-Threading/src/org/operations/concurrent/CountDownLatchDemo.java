package org.operations.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new LatchExecution(latch), " My_Thread 1");
		Thread t2 = new Thread(new LatchExecution(latch), " My_Thread 2");
		Thread t3 = new Thread(new LatchExecution(latch), " My_Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Now processing "+Thread.currentThread().getName()+" thread.Final latch count "+latch.getCount());
	}

}

class LatchExecution implements Runnable {

	private CountDownLatch latch;
	
	LatchExecution(CountDownLatch latch){
		this.latch =latch;
	}
	
	@Override
	public void run() {		
		System.out.println(Thread.currentThread().getName()+"  is proccesiing. and latch count is "+latch.getCount());
		latch.countDown();
	}
	
}