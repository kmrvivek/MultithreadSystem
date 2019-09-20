package org.multithreading.reentrant;

public class DeadLockExample {

	Resource resource1 = new Resource();	
	Resource resource2 = new Resource();
	
	public static void main(String[] args) {
		DeadLockExample d = new DeadLockExample();
		Thread t1 = new Thread(new T1(d),"Thread 1");
		Thread t2 = new Thread(new T2(d),"Thread 2");
		t1.start();
		t2.start();
	}
	
	public void method1() {
		synchronized (resource1) {
			System.out.println("lock acquired on resource1 by : "+Thread.currentThread().getName());
			synchronized (resource2) {
				System.out.println("lock acquired on resource2 by : "+Thread.currentThread().getName());
			}
		}
	}
	
	public void method2() {
		synchronized (resource1) {
			System.out.println("lock acquired on resource1 by : "+Thread.currentThread().getName());
			synchronized (resource2) {
				System.out.println("lock acquired on resource2 by : "+Thread.currentThread().getName());
			}
		}
	}

}

class Resource{}

class T1 implements Runnable {
	DeadLockExample d;
	
	T1(DeadLockExample d){
		this.d = d;
	}

	@Override
	public void run() {
		d.method1();
	}
	
}


class T2 implements Runnable {
	DeadLockExample d;
	
	T2(DeadLockExample d){
		this.d = d;
	}

	@Override
	public void run() {
		d.method2();
	}
	
}