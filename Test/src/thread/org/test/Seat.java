package thread.org.test;

public class Seat {
    
    private int seatNo;
    private boolean available;
    private static final int windowSeat = 1;
    private static final int aisleSeat = 2;
 
    public Seat(int seatNo, boolean available) {
        this.seatNo = seatNo;
        this.available = available;
    }
 
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
 
    public int getSeatNo() {
        return seatNo;
    }
 
    public void setAvailable(boolean available) {
        this.available = available;
    }
 
    public boolean getAvailable() {
        return available;
    }
 
    public int getSeatType() {
        if (seatNo%2 == 0) {
            return aisleSeat;
        }
        else {
            return windowSeat;
        }
    }
 
}
