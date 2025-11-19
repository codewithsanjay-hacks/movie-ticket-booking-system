package bmsbackend;

public class Theater {


    private int theaterID;
    private  String name;
    private String cityname;

    public Theater(int theaterID, String name, String cityname) {
        this.theaterID = theaterID;
        this.name = name;
        this.cityname = cityname;
    }
    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

}
