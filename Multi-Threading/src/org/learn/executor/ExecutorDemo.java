package org.learn.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		List<Task> list = new ArrayList<>(200);		
		ExecutorService eService = Executors.newFixedThreadPool(20);
		for(int i=0; i<200; i++) {
			list.add(new Task(i+21));
		}
		
		for(Task t : list) {
			System.out.println("Inside for loop");
			eService.submit(t);
		}
		eService.shutdown();

	}

}

class Task implements Runnable {
	
	private int value;
	
	Task(int val){
		this.value = val;
	}
	List<Integer> ls = new ArrayList<>(200);	
int i = 0;
	@Override
	public void run() {
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
	}
	
	private int getValue() {
		return this.value;
	}
	
}
