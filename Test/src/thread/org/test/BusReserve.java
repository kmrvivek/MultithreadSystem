package thread.org.test;

import java.util.HashMap;
import java.util.Map;

public class BusReserve {
	 
    private static Map<Integer, Seat> seatMap = new HashMap<Integer, Seat>();
 
    public static Map<Integer, Seat> getSeatMap() {
        return seatMap;
    }
 
    public static void main(String[] args) {
        for (int i=1; i <= 60; i++) {
            Seat seat = new Seat(i, true);
            seatMap.put(i, seat);
        }
        new Process(1).start();
        new Process(2).start();
        new Process(1).start();
        new Process(2).start();
        new Process(1).start();
        new Process(2).start();
    }
 
}
 