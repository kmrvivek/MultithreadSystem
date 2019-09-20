package org.java.code;

public class FindOne {

	public static void main(String[] args) {
		int[] arr = {1,2,3,10,11,12,11,41,11};
		int count = 0;
		for(int a: arr) {
			String d = Integer.toString(a);
			if(d.length() == 1) {
				if(d.contains("1")) {
					count ++;
				}
			} else {
				String[] e = d.split("");
				for (int i = 0; i < e.length; i++) {
					String f = e[i];
					if(f.contains("1")) {
						count ++;
					}
				}
			}
		}

		System.out.println("Total count: "+count);
	}

}
