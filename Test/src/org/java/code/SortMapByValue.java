package org.java.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {

	public static void main(String[] args) {
		
		 Map<Integer, String> map = new HashMap<Integer, String>();
	        map.put(2, "Rahul");
	        map.put(1, "sourabh");
	        map.put(4, "rishi");
	        map.put(3, "Raju");
	        
	        Set<Entry<Integer, String>> entrySet = map.entrySet();
	        List<Entry<Integer, String>> listOfEntrySet = new ArrayList<Entry<Integer, String>>(entrySet);
	        
	        System.out.println("Before sorting by value: ");
	        for(Map.Entry<Integer, String> entry: listOfEntrySet) {
	        	 System.out.print(entry.getKey()+"="+entry.getValue()+"  ");
	        }
	        
	        Collections.sort(listOfEntrySet, new SortByValue());
	        System.out.println("\nAfter sorting by value: ");
	        for(Map.Entry<Integer, String> entry: listOfEntrySet) {
	        	 System.out.print(entry.getKey()+"="+entry.getValue()+"  ");
	        }

	}

}
