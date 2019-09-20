package org.java.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; 

// A class 'MovieComp' that implements Comparable 
class MovieComp implements Comparable<MovieComp> 
{ 
	private double rating; 
	private String name; 
	private int year; 

	// Used to sort MovieComps by year 
	public int compareTo(MovieComp m) 
	{ 
		return this.year - m.year; 
	} 

	// Constructor 
	public MovieComp(String nm, double rt, int yr) 
	{ 
		this.name = nm; 
		this.rating = rt; 
		this.year = yr; 
	} 

	// Getter methods for accessing private data 
	public double getRating() { return rating; } 
	public String getName() { return name; } 
	public int getYear()	 { return year; } 
} 

// Class to compare MovieComps by ratings 
class RatingCompare implements Comparator<MovieComp> 
{ 
	public int compare(MovieComp m1, MovieComp m2) 
	{ 
		if (m1.getRating() < m2.getRating()) return -1; 
		if (m1.getRating() > m2.getRating()) return 1; 
		else return 0; 
	} 
} 

// Class to compare MovieComps by name 
class NameCompare implements Comparator<MovieComp> 
{ 
	public int compare(MovieComp m1, MovieComp m2) 
	{ 
		return m1.getName().compareTo(m2.getName()); 
	} 
} 

// Driver class 
public class ComparatorMain 
{ 
	public static void main(String[] args) 
	{ 
		ArrayList<MovieComp> list = new ArrayList<>(); 
		list.add(new MovieComp("Force Awakens", 8.3, 2015)); 
		list.add(new MovieComp("Star Wars", 8.7, 1977)); 
		list.add(new MovieComp("Empire Strikes Back", 8.8, 1980)); 
		list.add(new MovieComp("Return of the Jedi", 8.4, 1983)); 

		// Sort by rating : (1) Create an object of ratingCompare 
		//				 (2) Call Collections.sort 
		//				 (3) Print Sorted list 
		System.out.println("Sorted by rating"); 
		RatingCompare ratingCompare = new RatingCompare(); 
		Collections.sort(list, ratingCompare); 
		for (MovieComp MovieComp: list) 
			System.out.println(MovieComp.getRating() + " " + 
							MovieComp.getName() + " " + 
							MovieComp.getYear()); 


		// Call overloaded sort method with RatingCompare 
		// (Same three steps as above) 
		System.out.println("\nSorted by name"); 
		NameCompare nameCompare = new NameCompare(); 
		Collections.sort(list, nameCompare); 
		for (MovieComp MovieComp: list) 
			System.out.println(MovieComp.getName() + " " + 
							MovieComp.getRating() + " " + 
							MovieComp.getYear()); 

		// Uses Comparable to sort by year 
		System.out.println("\nSorted by year"); 
		Collections.sort(list); 
		for (MovieComp MovieComp: list) 
			System.out.println(MovieComp.getYear() + " " + 
							MovieComp.getRating() + " " + 
							MovieComp.getName()+" "); 
	} 
} 

