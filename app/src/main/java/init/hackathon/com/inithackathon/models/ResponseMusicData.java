package init.hackathon.com.inithackathon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseMusicData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("topTracks")
    private List<TopTracks> topTracksList;

    @JsonProperty("imageURL")
    private String imageUrl;

    public ResponseMusicData() {

    }

    public ResponseMusicData(String name, String id, List<TopTracks> topTracksList, String imageUrl) {
        this.name = name;
        this.id = id;
        this.topTracksList = topTracksList;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TopTracks> getTopTracksList() {
        return topTracksList;
    }

    public void setTopTracksList(List<TopTracks> topTracksList) {
        this.topTracksList = topTracksList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
