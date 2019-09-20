package org.learn.executor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintDate());
		Thread t2 = new Thread(new PrintDate());

		t1.start();
		t2.start();
	}

}

class DateFormatPerThread {

	private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd/MM/yyyy");
		}
	};

	public static DateFormat getDateFormatted() {
		return dateFormatHolder.get();
	}
}

class PrintDate implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread " + Thread.currentThread().getName() + " Formatted date is "
					+ DateFormatPerThread.getDateFormatted().format(new Date()));
		}
	}

}
