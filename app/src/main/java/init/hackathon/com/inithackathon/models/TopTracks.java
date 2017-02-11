package init.hackathon.com.inithackathon.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TopTracks {

    @JsonProperty("name")
    private String name;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("imageURL")
    private String imageUrl;

    public TopTracks() {

    }

    public TopTracks(String name, String uri, String imageUrl) {
        this.name = name;
        this.uri = uri;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
