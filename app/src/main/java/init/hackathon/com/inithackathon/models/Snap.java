package init.hackathon.com.inithackathon.models;

import java.util.List;

public class Snap {

    private String text;
    private List<MovieTemp> movieTempList;

    public Snap(String text, List<MovieTemp> movieTempList) {
        this.text = text;
        this.movieTempList = movieTempList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MovieTemp> getMovieTempList() {
        return movieTempList;
    }

    public void setMovieTempList(List<MovieTemp> movieTempList) {
        this.movieTempList = movieTempList;
    }
}
