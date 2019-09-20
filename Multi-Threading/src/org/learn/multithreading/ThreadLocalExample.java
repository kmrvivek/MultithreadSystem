package org.learn.multithreading;

public class ThreadLocalExample {
	
	public static class MyRunnable implements Runnable {
		
		int val;
		 public MyRunnable(int val) {
			this.val = val;
		}
		 
		public void setVal(int val) {
			this.val = val;
		}

	    private ThreadLocal<Integer> threadLocal =
	           new ThreadLocal<Integer>();
	    

	    @Override
	    public void run() {
	        threadLocal.set( (int) (Math.random() * 100D) );
	        setVal(this.val +10);
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	        }

	        System.out.println(threadLocal.get()+"  "+" Thread is"+Thread.currentThread().getName());
	        System.out.println("val is "+val+" Thread is"+Thread.currentThread().getName());
	    }
	}

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable(10);

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}

