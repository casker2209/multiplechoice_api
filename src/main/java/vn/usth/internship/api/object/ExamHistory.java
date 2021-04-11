package vn.usth.internship.api.object;

import java.util.List;

public class ExamHistory {
    private List<QuestionUser> QuestionUser;
    private String ExamId;
    private String ExamName;

    public List<vn.usth.internship.api.object.QuestionUser> getQuestionUser() {
        return QuestionUser;
    }

    public String getExamId() {
        return ExamId;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamId(String examId) {
        ExamId = examId;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public void setQuestionUser(List<vn.usth.internship.api.object.QuestionUser> questionUser) {
        QuestionUser = questionUser;
    }
    public ExamHistory(List<QuestionUser> QuestionUser,String ExamId,String ExamName){
        this.QuestionUser = QuestionUser;
        this.ExamId = ExamId;
        this.ExamName = ExamName;
    }
}
