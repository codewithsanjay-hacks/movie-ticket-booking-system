package bmsbackend;

public class Show {

    private int showid;
    private int movieid;
    private int theaterid;
    private String timing;
    private int availableseat;


    public Show(int showid, int movieid, int theaterid, String timing, int availableseat) {
        this.showid = showid;
        this.movieid = movieid;
        this.theaterid = theaterid;
        this.timing = timing;
        this.availableseat = availableseat;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public int getAvailableseat() {
        return availableseat;
    }

    public void setAvailableseat(int availableseat) {
        this.availableseat = availableseat;
    }



}
