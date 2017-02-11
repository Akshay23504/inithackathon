package init.hackathon.com.inithackathon.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestFieldData {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("created_time")
    private String createdTime;

    public RequestFieldData(String name, Long id, String createdTime) {
        this.name = name;
        this.id = id;
        this.createdTime = createdTime;
    }

    public RequestFieldData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
