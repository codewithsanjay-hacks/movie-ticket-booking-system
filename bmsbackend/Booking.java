package bmsbackend;

import java.util.List;

public class Booking {

    private int bookingid;
    private int userid;
    private int showid;
    private List<String>seatbooked;
    private double totalprice;


    public Booking(int userid, int bookingid, int showid, List<String> seatbooked, double totalprice) {
        this.userid = userid;
        this.bookingid = bookingid;
        this.showid = showid;
        this.seatbooked = seatbooked;
        this.totalprice = totalprice;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public List<String> getSeatbooked() {
        return seatbooked;
    }

    public void setSeatbooked(List<String> seatbooked) {
        this.seatbooked = seatbooked;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }


}
