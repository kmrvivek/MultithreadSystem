package org.hacker.queue;

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            int sum = 0;
            while(n >1){
                if(n%2 == 0){
                    sum += n/2;
                    n = n/2;
                }
                if(n%2 != 0){
                    sum += n/2;
                    n = n/2 + 1;
                }
            }

            System.out.println(sum);
        }
        sc.close();
   }
}

