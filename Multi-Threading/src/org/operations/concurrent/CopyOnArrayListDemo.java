package org.operations.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListDemo {

	/*private static ArrayList<String> ls = new ArrayList<>();*/
	
	private static List<String> ls = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) {
		ls.add("Crixus");
		ls.add("Harry");
		ls.add("Hermoine");
		ls.add("Onanemus");
		ls.add("Gannicus");
		
		Iterator<String> itr = ls.iterator();
		
		while(itr.hasNext()) {
			String name = itr.next();
			if(name.equals("Harry")) {
				itr.remove();
			}
		}
		
		System.out.println(ls);

	}

}
