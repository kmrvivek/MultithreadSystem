package org.operations.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDivideAndConquer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] arr = {25, 14, 87, 12, 89, 125, 64, 7, 54, 2, 14, -1};
		
		int num = findMinimum(arr, 0, arr.length-1);
		System.out.println(Thread.currentThread().getName()+" final value "+num);
	}

	private static int findMinimum(int[] arr, int i, int j) throws InterruptedException, ExecutionException {
		
		if(i < j) {
			int mid = i + (j-i)/2;
			
			ExecutorService service = Executors.newFixedThreadPool(10);
			
			Future<Integer> future1 = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread().getName()+" for min index: "+i+" and max "+mid);
					return findMinimum(arr, i, mid);
				}				
			});
			
			Future<Integer> future2 = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {	
					System.out.println(Thread.currentThread().getName()+" for min index: "+(mid+1)+" and max "+j);
					return findMinimum(arr, mid+1, j);
				}
			});
			
			int min1 = future1.get();
			int min2 = future2.get();
			
			service.shutdown();
			if(min1 < min2) {
				return min1;
			} else {
				return min2;
			}
		} else {
			return arr[i];
		}
		
	}

}
