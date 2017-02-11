package init.hackathon.com.inithackathon.models;

/**
 * Created by Akshay on 10-02-2017.
 */

public class MovieTemp {

    private String name;
    private String description;
    private Integer imageName;

    public MovieTemp(String name, String description, Integer imageNames) {
        this.name = name;
        this.description = description;
        this.imageName = imageNames;
    }

    public Integer getImageName() {
        return imageName;
    }

    public void setImageName(Integer imageName) {
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
