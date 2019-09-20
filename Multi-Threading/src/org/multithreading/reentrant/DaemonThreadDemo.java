package org.multithreading.reentrant;

public class DaemonThreadDemo {

	public static void main(String[] args) {
		Thread t = new Thread(new MyDaemonThread(), "Daemon thread");
		t.setDaemon(true);
		t.start();
		System.out.println("Main thread execution takes place");
	}

}

class MyDaemonThread implements Runnable {

	@Override
	public void run() {
		try {
			int i =0;
			while(true) {
				System.out.println("Running the daemon thread " + i++);
			}
		} finally {
			System.out.println("Daemon thread execution completed");
		}
		
	}
	
}
