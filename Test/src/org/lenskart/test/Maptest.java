package org.lenskart.test;

import java.util.HashMap;
import java.util.Map;

public class Maptest {

	public static void main(String[] args) {
		Map<WeekDay, String> mp = new HashMap<>();
		
		mp.put(new WeekDay("Monday"), "Cooking");
		mp.put(new WeekDay("Tuesday"), "Washing");
		mp.put(new WeekDay("Monday"), "Reading");
		
		System.out.println(mp.size());
		for(Map.Entry<WeekDay, String> m: mp.entrySet()) {
			System.out.println(m.getKey().day+"  "+m.getValue());
		}

	}

}

class WeekDay {
	
	protected String day;
	
	public WeekDay(String day) {
		this.day = day;
	}

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		return result;
	} */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeekDay other = (WeekDay) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		return true;
	}
	
	
}
