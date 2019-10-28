package org.java.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fico {

	public static void main(String[] args)	{
		List<Integer> al = new ArrayList<>();
		
		al.add(1);
		al.add(2);
		al.add(324);
		al.add(1243);
		al.add(12343);
		al.add(3);
		al.add(321);
		
		Collections.sort(al, new MyComparator());
		System.out.println(al);
	}
	
}

class MyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer p1, Integer p2) {
		int val = (int)Math.log10(p1);
		int val2 = (int)Math.log10(p2);
		if(val > val2) {
			return 1;
		}else if(val == val2) {
			/*if(p1 < p2) {
				return 1;
			} else if(p1 == p2) {
				return 0;
			}else return -1;
			*/
			return -p1.compareTo(p2);
		}else {
			return -1;
		}
	}
}

