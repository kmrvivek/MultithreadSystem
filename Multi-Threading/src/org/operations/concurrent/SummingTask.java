package org.operations.concurrent;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SummingTask extends RecursiveTask<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<Integer> numbers;
	private final int min, max;
	
	private final int maxBatchSize =10;
	
	public SummingTask(List<Integer> numbers, int min, int max) {
		this.numbers = numbers;
		this.max = max;
		this.min = min;
	}
	@Override
	protected Integer compute() {
		if(max - min > maxBatchSize) {
			System.out.println("This is too long for a single batch size, so we will divide this task into two tasks");
			System.out.println("Min: "+min+" Max: "+max);
			int mid = min + (max-min)/2;
			System.out.println("Mid: "+mid);
			SummingTask rightTask = new SummingTask(numbers, min, mid);
			System.out.println("Right task with: "+min+" , "+mid);
			SummingTask leftTask = new SummingTask(numbers, mid, max);
			System.out.println("Right task with: "+mid+" , "+max);
			
			leftTask.fork();
			
			int rightResult = rightTask.compute();			
			int leftResult = leftTask.join();
			return leftResult+rightResult;
			
		}else {
			int sum =0;
			for(int i=min; i<max;i++) {
				sum += numbers.get(i);
			}
			return sum;
		}
		

	}

}
