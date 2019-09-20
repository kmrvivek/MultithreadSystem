package org.learn.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {
	public static void main(String[] args) {
		List<MyTask> list = new ArrayList<>(100);		
		ExecutorService eService = Executors.newFixedThreadPool(20);
		for(int i=0; i<100; i++) {
			list.add(new MyTask(i+21));
		}
		
		for(MyTask t : list) {
			System.out.println("Inside for loop");
			eService.submit(t);
		}
		eService.shutdown();

	}

}

class MyTask implements Callable<String> {
	
	private int value;
	
	MyTask(int val){
		this.value = val;
	}
	List<Integer> ls = new ArrayList<>(200);	
int i = 0;
	@Override
	public String call() {
		if(ls.contains(getValue())) {
			System.out.println("Duplicate value "+Thread.currentThread().getName()+" thread is ec=xecuting the task\n"
					+ "And the value is "+getValue());
		} else {			
		
			ls.add(getValue());
		System.out.println("Currently "+Thread.currentThread().getName()+" thread is ec=xecuting the task\n"
				+ "And the value is "+getValue());
	}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "completed";
	}
	
	private int getValue() {
		return this.value;
	}
	
}

