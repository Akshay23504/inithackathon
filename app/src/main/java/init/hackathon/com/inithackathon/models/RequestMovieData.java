package init.hackathon.com.inithackathon.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestMovieData {
    @JsonProperty("movies")
    public RequestMovie movie;
    @JsonProperty("id")
    private Long id;

    public RequestMovieData() {
    }

    public RequestMovieData(RequestMovie movie, Long id) {
        this.movie = movie;
        this.id = id;
    }

    public RequestMovie getMovie() {
        return movie;
    }

    public void setMovie(RequestMovie movie) {
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
