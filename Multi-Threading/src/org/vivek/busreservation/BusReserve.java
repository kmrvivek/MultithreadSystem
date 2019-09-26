package org.vivek.busreservation;

import java.util.Date;

public class BusReserve implements Runnable {
	
    private IBus bus;
    
    public BusReserve(IBus bus) {
		this.bus = bus;
	}
/*
    private int userInput() {
    	System.out.println("Please enter 1 for window seat, 2 for aisle seat, or 0 for exit");
    	Scanner s = new Scanner(System.in);
    	return s.nextInt();
    }
    */
    
    private static synchronized int determineSeatNumber(int choice, IBus bus1) {
    	 
    	switch(choice) {
    		case 1: 
    			int seatNumber = bookWindow(bus1);
    			if(seatNumber == -1) {
    				seatNumber = bookAisle(bus1);
    				if(seatNumber != -1) {
    					System.out.println("No Window seat available, aisle seat is available");
    					return seatNumber;
    				} else {
    					  System.out.println("No window or aisle seats.");
                          return -1;
    				}
    			} 
    			System.out.println("Window seat booked."+bus1.getName());
                return seatNumber;
    		
    		
    		case 2: 
    			 seatNumber = bookAisle(bus1);
    			  if (seatNumber == -1) { // no aisle seat
                      seatNumber = bookWindow(bus1);
                      if (seatNumber != -1) { // window seat available
                          System.out.println("No aisle seat but window seat.");
                          return seatNumber;
                      }
                      else {
                          System.out.println("No window or aisle seats."+bus1.getName());
                          return -1;
                      }
                  }
                  System.out.println("Aisle seat booked.");
                  return seatNumber;
              
    		default: return -1;
    	}
    	
    }
    
   
    private static synchronized int bookWindow(IBus bus1) {  
    	
        int seatNumber = -1;       
      
        for (int i=0; i <= bus1.getSeats().size(); i++) {
            Seat s = bus1.getSeats().get(i);
            // check if each seat is available and seat type is window
            if (s.getAvailable() && s.getSeatType() == 1) {
                s.setAvailable(false);
                seatNumber = s.getSeatNo();
                break;
            }
        }
        return seatNumber;
    }
    
 
    private static synchronized int bookAisle(IBus bus1) {
    	
        int seatNumber = -1;
     
        for (int i=0; i <= bus1.getSeats().size(); i++) {
            Seat s = bus1.getSeats().get(i);
            // check if each seat is available and seat type is aisle
            if (s.getAvailable() && s.getSeatType() == 2) {
                s.setAvailable(false);
                seatNumber = s.getSeatNo();
                break;
            }
        }
        return seatNumber;
    	

    }
    
	@Override
	public void run() {	 
			synchronized (bus) {				
		 		bus.displaySeats();
			 	int maxSeatCount = 0;
			 	System.out.println(Thread.currentThread().getName()+" acquired lock on the booking for "+bus.getName());
		 		
		 			System.out.println(Thread.currentThread().getName()+" booking started for "+bus.getName());
					int seatNumber = determineSeatNumber(bus.getChoice(), bus);
					while(maxSeatCount < 4) {
					if(seatNumber != -1) {
						 printBoardingPass(seatNumber, bus);
					}
					maxSeatCount++;
				  System.out.println("Maximum 4 seats booked");
					}
		 			
			}
	}
	
	 private static synchronized void printBoardingPass(int seatNumber, IBus bus1) {
	        System.out.println("\nDate: " + new Date());
	        Seat s = bus1.getSeats().get(seatNumber);
	        String type = "";
	        switch (s.getSeatType()) {
	            case 1: {
	                type = "window";
	                break;
	            }
	            case 2: {
	                type = "aisle";
	                break;
	            }
	        }
	        System.out.println(Thread.currentThread().getName()+" Boarding pass for " + type + " seat number: "
	                + seatNumber + " And Bus is "+bus1.getName()+"\n");
	    }
	 
}


