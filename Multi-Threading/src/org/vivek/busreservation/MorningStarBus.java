package org.vivek.busreservation;

import java.util.HashMap;
import java.util.Map;

public class MorningStarBus implements IBus {
	
	public static final String name= "Morning Star";
	private static int numberOfSeats = 20;
	
	private int choice;

	public void setChoice(int choice) {
		this.choice = choice;
	}
	 private static Map<Integer, Seat> seatMap = new HashMap<>();
	 
	 static {
		 for (int i=0; i <= numberOfSeats; i++) {
	            Seat seat = new Seat(i, true);
	            seatMap.put(i, seat);
	        }
	 }
	
	 public String getName() {
			return name;
		}
	 
	@Override
	public void displayBus() {
		System.out.println("You are looking for "+name+" bus");
	}

	@Override
	public void displaySeats() {
		System.out.println(name+" "+seatMap);
	}
	
	@Override
	public Map<Integer, Seat> getSeats(){
		return seatMap;
	}

	@Override
	public int getChoice() {
		return this.choice;
	}
}
