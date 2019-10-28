package org.learn.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcuurentModifactionEx {

	public static void main(String[] args) {
	
		List<String> ls = new ArrayList<>();
		
		ls.add("Raju");
		ls.add("Shyam");
		ls.add("Rahul");
		ls.add("Rohit");
		ls.add("Rounak");
		ls.add("Mummy ji");
		ls.add("Anand");
		
		/*for(String s : ls) {
			if(s.equalsIgnoreCase("rohit")) {
				ls.remove(s);
			}
		}*/
		
		Iterator<String> itr = ls.iterator();
		while(itr.hasNext()) {
			String s = itr.next();
			if(s.equalsIgnoreCase("rohit")) {
				itr.remove();
			}
			System.out.println(s);
		}
		
		System.out.println(ls);

	}

}
