package vn.usth.internship.api.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Question implements Serializable {

    private String question;
    private String QuestionCorrect;
    private String A;
    private String B;
    private String C;
    private String D;




    public String getQuestion() {
        return question;
    }

    public String getQuestionCorrect() {
        return QuestionCorrect;
    }

    public void setQuestion(String question) {
        question = question;
    }

    public void setQuestionCorrect(String questionCorrect) {
        QuestionCorrect = questionCorrect;
    }


    public void setA(String a) {
        A = a;
    }

    public void setB(String b) {
        B = b;
    }

    public void setC(String c) {
        C = c;
    }

    public void setD(String d) {
        D = d;
    }

    public String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public String getC() {
        return C;
    }

    public String getD() {
        return D;
    }

    public Question(String A,String B,String C,String D,String question, String QuestionCorrect){
        this.question = question;
        this.QuestionCorrect = QuestionCorrect;
        this.A = A;this.B = B;this.C = C; this.D = D;

    }
}
