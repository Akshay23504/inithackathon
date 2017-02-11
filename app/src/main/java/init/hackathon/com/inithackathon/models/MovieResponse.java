package init.hackathon.com.inithackathon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResponse {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("results")
    private List<Movie> results;
    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
