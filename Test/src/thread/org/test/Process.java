package thread.org.test;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Process extends Thread {
	 
    private int maxSeatCount;
    private Map<Integer, Seat> seatMap;
    private int choice;
 
    public Process(int choice) {
        this.choice = choice;
    }
 
    private int promptForSeatChoice() {
        System.out.print("Please enter 1 for window, " +
                "2 for aisle, or 0 to exit: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
 
    private int determineSeatNumber(int choice) {
        switch (choice) {
            case 1: {
                int seatNumber = bookWindow();
                if (seatNumber == -1) { // no window seat
                    seatNumber = bookAisle();
                    if (seatNumber != -1) { // aisle seat available
                        System.out.println("No window seat but aisle seat."+Thread.currentThread().getName());
                        return seatNumber;
                    }
                    else {
                        System.out.println("No window or aisle seats."+Thread.currentThread().getName());
                        return -1;
                    }
                }
                System.out.println("Window seat booked."+Thread.currentThread().getName());
                return seatNumber;
            }
            case 2: {
                int seatNumber = bookAisle();
                if (seatNumber == -1) { // no aisle seat
                    seatNumber = bookWindow();
                    if (seatNumber != -1) { // window seat available
                        System.out.println("No aisle seat but window seat."+Thread.currentThread().getName());
                        return seatNumber;
                    }
                    else {
                        System.out.println("No window or aisle seats."+Thread.currentThread().getName());
                        return -1;
                    }
                }
                System.out.println("Aisle seat booked."+Thread.currentThread().getName());
                return seatNumber;
            }
            default: return -1;
        }
    }
 
    @Override
    public void run() {
        seatMap = BusReserve.getSeatMap();
        while (maxSeatCount < 4) { // check max 4
//            int choice = promptForSeatChoice();
//            if (choice == 0) {
//                System.exit(0);
//            } else {
//                while (choice > 2) { // prompt for input
//                    choice = promptForSeatChoice();
//                }
                int seatNumber = determineSeatNumber(choice);
                if (seatNumber != -1) {
                    ++maxSeatCount; // increment max count
                    printBoardingPass(seatNumber);
                }
//            }
        }
        System.out.println("Maximum 4 seats");
    }
 
    private synchronized int bookWindow() {
        int seatNumber = -1;
 
        for (int i=1; i <= seatMap.size(); i++) {
            Seat s = seatMap.get(i);
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
 
        for (int i=1; i <= seatMap.size(); i++) {
            Seat s = seatMap.get(i);
            // check if each seat is available and seat type is aisle
            if (s.getAvailable() && s.getSeatType() == 2) {
                s.setAvailable(false);
                seatNumber = s.getSeatNo();
                break;
            }
        }
 
        return seatNumber;
    }
 
    private void printBoardingPass(int seatNumber) {
        System.out.println("\nDate: " + new Date());
        Seat s = seatMap.get(seatNumber);
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
                + seatNumber + "\n");
    }
 
}
 
