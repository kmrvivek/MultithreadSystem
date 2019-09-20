package org.operations.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Driver {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		ForkJoinPool pool = new ForkJoinPool(5);
		for(int i=0; i<40; i++) {
			numbers.add(10);
		}
		
		ForkJoinTask<Integer> task = pool.submit(new SummingTask(numbers, 0, numbers.size()));
		int result = task.join();
		System.out.println(result);

	}

}
