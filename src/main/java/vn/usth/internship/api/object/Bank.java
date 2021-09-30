package vn.usth.internship.api.object;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Bank")
public class Bank {
    @Id
    private String id;
    private String name;
    private String description;
    private List<Question> questionList;
    public void setName(String name) {
        name = name;
    }

    public void setId(String id) {
        id = id;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void setQuestionList(List<Question> question) {
        this.questionList= question;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public String getId() {
        return id;
    }

    public BankInfo getInfo(){
        return new BankInfo(this.id,this.name,this.description);
    }
    public BankContent getContent(){
        return new BankContent(this.id,this.questionList);
    }

    public Bank(String id,String name,String description,List<Question> questionList){
        this.id = id;
        this.description = description;
        this.name = name;
        this.questionList = questionList;
    }}
