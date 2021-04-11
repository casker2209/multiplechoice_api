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
    private User User;
    private List<ExamHistory> ExamHistory;

    public void setId(String id) {
        this.id = id;
    }

    public void setExamHistory(List<vn.usth.internship.api.object.ExamHistory> examHistory) {
        ExamHistory = examHistory;
    }

    public void setUser(vn.usth.internship.api.security.User user) {
        User = user;
    }

    public String getId() {
        return id;
    }

    public List<vn.usth.internship.api.object.ExamHistory> getExamHistory() {
        return ExamHistory;
    }

    public vn.usth.internship.api.security.User getUser() {
        return User;
    }
    public UserInfo(){

    }
    public UserInfo(User user,List<ExamHistory> ExamHistory){
        this.User = user;
        this.ExamHistory = ExamHistory;
    }
}
