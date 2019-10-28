package org.learn.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		int val[] = {10, 20, 6};
		List<Long> list = new ArrayList<>();
		List<Future<Long>> fut = new ArrayList<>();
		for(int i=0; i<3;i++) {
			System.out.println("Submiting task to cal factorial of "+val[i]);	
			 fut.add(ex.submit(new MyFactorial(val[i])));
			System.out.println("Submitted task to cal factorial of "+val[i]);	
			
		}
		for(int i=0; i<3;i++) {
			Long resultOfFact = fut.get(i).get();
			list.add(resultOfFact);
			System.out.println("factorial of val "+val[i]+ " is "+resultOfFact);
		}
		ex.shutdown();
		System.out.println(list.toString());
	}

}

class MyFactorial implements Callable<Long> {

	private int num;
	
	MyFactorial(int num){
		this.num = num;
	}
	
	@Override
	public Long call() throws Exception {
		long result = 1;
		while(num > 0) {
			result = result *  num--;
			Thread.sleep(200);
		}
		return result;
	}
	
}
