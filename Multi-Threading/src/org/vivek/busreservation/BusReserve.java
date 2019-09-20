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
    
    private int determineSeatNumber(int choice) {
    	 
    	switch(choice) {
    		case 1: 
    			int seatNumber = bookWindow();
    			if(seatNumber == -1) {
    				seatNumber = bookAisle();
    				if(seatNumber != -1) {
    					System.out.println("No Window seat available, aisle seat is available");
    					return seatNumber;
    				} else {
    					  System.out.println("No window or aisle seats.");
                          return -1;
    				}
    			} 
    			System.out.println("Window seat booked."+bus.getName());
                return seatNumber;
    		
    		
    		case 2: 
    			 seatNumber = bookAisle();
    			  if (seatNumber == -1) { // no aisle seat
                      seatNumber = bookWindow();
                      if (seatNumber != -1) { // window seat available
                          System.out.println("No aisle seat but window seat.");
                          return seatNumber;
                      }
                      else {
                          System.out.println("No window or aisle seats."+bus.getName());
                          return -1;
                      }
                  }
                  System.out.println("Aisle seat booked.");
                  return seatNumber;
              
    		default: return -1;
    	}
    	
    }
    
   
    private synchronized int bookWindow() {  
    	
        int seatNumber = -1;       
        if(bus == null) {
        	try {
				Thread.currentThread().wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        for (int i=0; i <= bus.getSeats().size(); i++) {
            Seat s = bus.getSeats().get(i);
            // check if each seat is available and seat type is window
            if (s.getAvailable() && s.getSeatType() == 1) {
                s.setAvailable(false);
                seatNumber = s.getSeatNo();
                break;
            }
        }
        return seatNumber;
    }
    
 
    private synchronized int bookAisle() {
    	
        int seatNumber = -1;
        if(bus == null) {
        	try {
				Thread.currentThread().wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        for (int i=0; i <= bus.getSeats().size(); i++) {
            Seat s = bus.getSeats().get(i);
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
		if(bus == null) {
		try {
			Thread.currentThread().wait(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
			
		 		bus.displaySeats();
			 	int maxSeatCount = 0;
			 	System.out.println(Thread.currentThread().getName()+" acquired lock on the booking for "+bus.getName());
		 		
		 			System.out.println(Thread.currentThread().getName()+" booking started for "+bus.getName());
					int seatNumber = determineSeatNumber(this.bus.getChoice());
					if(seatNumber != -1) {
						 printBoardingPass(seatNumber);
					}
				
				  //System.out.println("Maximum 4 seats booked");
		 			
	 	
	}
	
	 private void printBoardingPass(int seatNumber) {
	        System.out.println("\nDate: " + new Date());
	        Seat s = this.bus.getSeats().get(seatNumber);
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
	                + seatNumber + " And Bus is "+this.bus.getName()+"\n");
	    }
	 
}


