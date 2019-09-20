package org.java.code;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class SortByValue implements Comparator<Map.Entry<Integer, String>>{

	@Override
	public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
		// TODO Auto-generated method stub
		return o2.getValue().compareToIgnoreCase(o1.getValue());
	}

	
	

}
