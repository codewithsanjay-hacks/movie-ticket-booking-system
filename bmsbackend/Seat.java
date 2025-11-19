package bmsbackend;

public class Seat {
    private int seatid;
    private int showid;
    private String seatnumber;
    private  boolean   isbookeddd;

    public Seat(String seatnumber, int seatid, int showid, boolean isbooked) {
        this.seatnumber = seatnumber;
        this.seatid = seatid;
        this.showid = showid;




        this.isbookeddd = isbookeddd;
    }

    public int getSeatid() {
        return seatid;
    }

    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber;
    }

    public boolean isIsbooked() {
        return isbookeddd;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbookeddd = isbooked;
    }


}
