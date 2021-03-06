package vn.usth.internship.api.object;

public class ExamInfo {
    String id;
    String name;
    String description;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExamInfo(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
