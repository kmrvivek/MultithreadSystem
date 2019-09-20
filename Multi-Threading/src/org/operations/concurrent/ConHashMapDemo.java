package org.operations.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConHashMapDemo implements Runnable{

	/*private static HashMap<Integer, String> map = new HashMap<>(); */
	
	/*
	 * Using Concurrent hashmap for achieving concurrency
	 */
	
	private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
	
	public static void main(String[] args) {
		
		ConHashMapDemo cm = new ConHashMapDemo();
		Thread th = new Thread(cm, "My own thread");
		th.start();
		
		map.put(1, "Ram");
		map.put(2, "John");
		map.put(3, "Tommy");
		map.put(4, "Crixus");
		map.put(5, "Spartacus");
		map.put(5, "Gannicus");
		
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		
		while(itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			System.out.println(entry.getKey() +" : "+entry.getValue());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put(6, "Onanemaus");
		
	}

}
