package org.vivek.busreservation;

public class UserInterface {
	
/*	private static IBus bus;

	private static Map<Integer, Seat> seatMap;
	 
    public static Map<Integer, Seat> getSeatMap() {
        return seatMap;
    }*/
	public static void main(String[] args) {
	/*	Scanner s = new Scanner(System.in);
		System.out.println("Buses are :\nSelect 1 for MorningStar, 2 for SeaBird");
		int n = s.nextInt();
		
		if(n == 1) {
			bus = new MorningStarBus();
			bus.displayBus();
			bus.displaySeats();
			seatMap = bus.getSeats();
		}else if(n == 2) {
			bus = new Seabird();
			bus.displayBus();
			bus.displaySeats();
			seatMap = bus.getSeats();
		} else {
			System.out.println("Incorrect Input. Existing page");
		}*/
		IBus bus1 = new MorningStarBus();
		IBus bus2 = new Seabird();
	
		bus1.setChoice(1);
		Thread t1 = new Thread(new BusReserve(bus1));
		bus1.setChoice(2);
		Thread t2 = new Thread(new BusReserve(bus1));
		bus1.setChoice(1);
		Thread t3 = new Thread(new BusReserve(bus1));
		bus1.setChoice(2);
		Thread t4 = new Thread(new BusReserve(bus1));
		bus1.setChoice(1);
		Thread t5 = new Thread(new BusReserve(bus1));
		bus1.setChoice(2);
		Thread t6 = new Thread(new BusReserve(bus1));
		
		bus2.setChoice(1);
		Thread t7 = new Thread(new BusReserve(bus2));
		bus2.setChoice(1);
		Thread t8 = new Thread(new BusReserve(bus2));
		bus2.setChoice(2);
		Thread t9 = new Thread(new BusReserve(bus2));
		bus2.setChoice(2);
		Thread t10 = new Thread(new BusReserve(bus2));
		bus2.setChoice(1);
		Thread t11 = new Thread(new BusReserve(bus2));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		
	}

}
