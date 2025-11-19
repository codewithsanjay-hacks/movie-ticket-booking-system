package bmsbackend;

public class Movies {

    private int movieid;
    private String moviename;
    private String language;
    private String genere;
    private  int duration;

    public Movies(int movieid, String moviename, String language, String genere, int duration) {
        this.movieid = movieid;
        this.moviename = moviename;
        this.language = language;
        this.genere = genere;
        this.duration = duration;
    }
    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


}
