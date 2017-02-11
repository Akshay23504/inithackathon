package init.hackathon.com.inithackathon.models;


import java.util.List;

public class MovieSnap {

    private String text;
    private List<ResponseMovieData> responseMovieData;

    public MovieSnap(String text, List<ResponseMovieData> responseMovieData) {
        this.text = text;
        this.responseMovieData = responseMovieData;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<ResponseMovieData> getResponseMovieData() {
        return responseMovieData;
    }

    public void setResponseMovieData(List<ResponseMovieData> responseMovieData) {
        this.responseMovieData = responseMovieData;
    }
}
