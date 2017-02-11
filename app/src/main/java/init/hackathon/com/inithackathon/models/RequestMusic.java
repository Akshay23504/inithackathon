package init.hackathon.com.inithackathon.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMusic {

    @JsonProperty("data")
    public List<RequestFieldData> fieldDataList;

    public RequestMusic() {

    }

    public RequestMusic(List<RequestFieldData> fieldDataList) {
        this.fieldDataList = fieldDataList;
    }

    public List<RequestFieldData> getFieldDataList() {
        return fieldDataList;
    }

    public void setFieldDataList(List<RequestFieldData> fieldDataList) {
        this.fieldDataList = fieldDataList;
    }
}
