package org.vivek.busreservation;

import java.util.HashMap;
import java.util.Map;

public class Seabird implements IBus {

	public static final String name= "SeaBird";
	private static int numberOfSeats = 30;
	
	private static Map<Integer, Seat> seatMap = new HashMap<Integer, Seat>();
	
	private int choice;
	
	 static {
		 for (int i=0; i <= numberOfSeats; i++) {
	            Seat seat = new Seat(i, true);
	            seatMap.put(i, seat);
	        }
	 }
	 
	@Override
	public void displayBus() {
		System.out.println("You are looking for "+name+" bus");
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void displaySeats() {
			System.out.println(name+" "+seatMap);
	}

	@Override
	public Map<Integer, Seat> getSeats(){
		return seatMap;
	}
	
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	@Override
	public int getChoice() {
		return this.choice;
	}
}
