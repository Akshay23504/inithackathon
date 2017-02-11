package init.hackathon.com.inithackathon.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RequestMusicData {

    @JsonProperty("music")
    public RequestMusic music;
    @JsonProperty("id")
    private Long id;

    public RequestMusicData() {
    }

    public RequestMusicData(RequestMusic music, Long id) {
        this.music = music;
        this.id = id;
    }

    public RequestMusic getMusic() {
        return music;
    }

    public void setMusic(RequestMusic music) {
        this.music = music;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
