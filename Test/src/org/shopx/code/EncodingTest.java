package org.shopx.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EncodingTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		
		String arr[] = s.split("");
		//System.out.println(Arrays.toString(arr));
		
		Map<String, Integer> mp = new HashMap<>();
		
		for(int i=0; i<64; i++) {
			mp.put(arr[i], i);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String str[] = br.readLine().trim().split("");
			System.out.println(Arrays.toString(str));
			
			int arrsum[] = new int[n];
			int sum = 0;
			int k = 0;
			for(int i=n-1; i>=0; i--) {
				if(k%2 == 0) {
					int val = mp.get(str[i]) * 2;
					if(val > 63) {
					int index = val/64;
					int remainder = val%64;
					
					arrsum[i] = index+remainder;
					} else {
						
						arrsum[i] = val;
					}
					
				} else {
					
					arrsum[i] = mp.get(str[i]);
				}
				k++;
			}
			System.out.println(Arrays.toString(arrsum));
			
			for(int i=0; i<n; i++) {
				sum += arrsum[i];
			}
			if(sum == 0) {
				System.out.println(arr[0]);
			}else if(sum < 64) {
				System.out.println(arr[64-sum]);
			} else {
			int divisor = sum/64;
			int rem = sum%64;
			int finalValue = (divisor+1)*64 - (sum);
			System.out.println(sum+"  "+divisor+"  "+finalValue+"  rem "+rem);
			System.out.println(arr[finalValue]);
			}		
		}
	}

}
