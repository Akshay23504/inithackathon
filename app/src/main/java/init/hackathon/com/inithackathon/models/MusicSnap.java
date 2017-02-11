package init.hackathon.com.inithackathon.models;


import java.util.List;

public class MusicSnap {

    private String text;
    private List<TopTracks> topTracksList;

    public MusicSnap(String text, List<TopTracks> topTracksList) {
        this.text = text;
        this.topTracksList = topTracksList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TopTracks> getTopTracksList() {
        return topTracksList;
    }

    public void setTopTracksList(List<TopTracks> topTracksList) {
        this.topTracksList = topTracksList;
    }
}
