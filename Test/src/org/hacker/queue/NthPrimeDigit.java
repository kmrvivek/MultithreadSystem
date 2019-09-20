package org.hacker.queue;

import static java.lang.Math.pow; 

public class NthPrimeDigit {
	static void nthprimedigitsnumber(long n) 
	{ 
	
		long len = 1; 


		long prev_count = 0; 
		while (true) { 
		
			long curr_count = (long)(prev_count + pow(4, len)); 

			if (prev_count < n && curr_count >= n) 
				break; 

			len++; 

			prev_count = curr_count; 
		} 

	    System.out.println("prev_count "+prev_count);


		for (int i = 1; i <= len; i++) { 
			// j = 1 means 2 j = 2 means ...j = 4 means 7 
			for (long j = 1; j <= 4; j++) { 
				if (prev_count + pow(4, len - i) < n) {
					prev_count += pow(4, len - i);
				} 
				else { 
					if (j == 1) 
						System.out.print("2"); 
					else if (j == 2) 
						System.out.print("3"); 
					else if (j == 3) 
						System.out.print("5"); 
					else if (j == 4) 
						System.out.print("7"); 
					break; 
				} 
			} 
		} 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		nthprimedigitsnumber(10); 
		nthprimedigitsnumber(21); 
		nthprimedigitsnumber(100); 
	} 
}
