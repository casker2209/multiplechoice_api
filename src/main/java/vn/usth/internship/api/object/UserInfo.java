package vn.usth.internship.api.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import vn.usth.internship.api.security.User;

import java.util.List;


@Document(collection = "UserInfo")
public class UserInfo {
    @Id
    private String id;
    @DBRef
    @Field("User")
    private User user;
    private List<ExamHistory> ExamHistory;

    public void setId(String id) {
        this.id = id;
    }

    public void setExamHistory(List<vn.usth.internship.api.object.ExamHistory> examHistory) {
        ExamHistory = examHistory;
    }

    public void setUser(vn.usth.internship.api.security.User user) {
        user = user;
    }

    public String getId() {
        return id;
    }

    public List<vn.usth.internship.api.object.ExamHistory> getExamHistory() {
        return ExamHistory;
    }

    public vn.usth.internship.api.security.User getUser() {
        return user;
    }
    public UserInfo(){

    }
    public UserInfo(User user,List<ExamHistory> ExamHistory){
        this.user = user;
        this.ExamHistory = ExamHistory;
    }
}
