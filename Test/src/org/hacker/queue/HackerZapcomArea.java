package org.hacker.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerZapcomArea {
	
	 
	public static void main(String[] args) {
		int n = 3;
		List<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(3);
		al.add(4);
	/*	al.add(2);
		al.add(2);
		al.add(3);*/
		int segment = 3;
	 
		double area = getAreaOfSegment(al, n, segment);
		System.out.println(area);
	}

	private static double getAreaOfSegment(List<Integer> al, int n, int segment) {
		Collections.sort(al);
		double b = 0.0;
		int start = 0, end =0;;
		for(int i=0; i < n; i++) {
			int num = al.get(i) * al.get(i);
			al.set(i, num);
		}
		
		System.out.println(al);
		int max = al.get(n-1);
		System.out.println("start max "+max);
		int numberOfSegments = getSumOfSegments(al, max);
		
		System.out.println("numberOfSegments "+numberOfSegments);
		
		while(numberOfSegments < segment) {
			numberOfSegments =  getSumOfSegments(al, --max);
			start = max;
			end = max;
			System.out.println("current max "+max);
			System.out.println("lopp num of numberOfSegments "+numberOfSegments);
		}
		end = start+1;
		System.out.println("start value "+start+ " and end is "+end);
		if(numberOfSegments == segment) {
			return Math.PI * max;
		} else {
			if (numberOfSegments > segment) {
				b = (double) end;
				while (numberOfSegments != segment && b > start) {
					b -= 0.05;
					numberOfSegments = getSumOfSegments(al, b);
					System.out.println("point increment b "+b);
					System.out.println("loop increment numberOfSegments "+numberOfSegments);
				}
			}
			return Math.PI * b;
		}
		
	}

	private static int getSumOfSegments(List<Integer> al, double b) {
	int num = 0;
	 b = (double)Math.round(b * 100d) / 100d;
		for(int i=0; i<al.size(); i++) {
			num += (int) ((double)al.get(i)/b);
		}
		return num;
	
	}

	private static int getSumOfSegments(List<Integer> al, int max) {
		int num = 0;
		
		for(int i=0; i<al.size(); i++) {
			num += (int) ((double)al.get(i)/(double)max);
		}
		return num;
	}

}
