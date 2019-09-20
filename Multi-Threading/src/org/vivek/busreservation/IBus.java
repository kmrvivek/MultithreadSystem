package org.vivek.busreservation;

import java.util.Map;

public interface IBus {
	
	public void displayBus();
	
	public void displaySeats();
	
	public Map<Integer, Seat> getSeats();
	
	public String getName();
	
	public void setChoice(int choice);

	public int getChoice();
}
