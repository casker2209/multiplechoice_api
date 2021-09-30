package vn.usth.internship.api.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Question implements Serializable {

    private String question;
    private List<String> QuestionCorrect;
    private List<String> answer;



    public String getQuestion() {
        return question;
    }

    public List<String> getQuestionCorrect() {
        return QuestionCorrect;
    }

    public void setQuestion(String question) {
        question = question;
    }

    public void setQuestionCorrect(List<String> questionCorrect) {
        QuestionCorrect = questionCorrect;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public Question(String question, List<String> QuestionCorrect,List<String> answer){
        this.question = question;
        this.QuestionCorrect = QuestionCorrect;
        this.answer = answer;

    }
}
