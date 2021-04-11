package vn.usth.internship.api.object;


public class QuestionUser extends Question{
    private String AnswerChosen;
    private boolean IsCorrect;

    public QuestionUser(String A, String B, String C, String D, String question, String QuestionCorrect,String AnswerChosen,boolean IsCorrect) {
        super(A, B, C, D, question, QuestionCorrect);
        AnswerChosen = AnswerChosen;
        IsCorrect = IsCorrect;
    }
    public QuestionUser(Question question,String AnswerChosen,boolean isCorrect) {
        super(question.getA(), question.getB(), question.getC(), question.getD(), question.getQuestion(), question.getQuestionCorrect());
        AnswerChosen = AnswerChosen;
        IsCorrect = isCorrect;
    }
    public String getAnswerChosen() {
        return AnswerChosen;
    }

    public boolean getIsCorrect(){
        return IsCorrect;
    }

    public void setAnswerChosen(String answerChosen) {
        AnswerChosen = answerChosen;
    }

    public void setCorrect(boolean correct) {
        IsCorrect = correct;
    }

}
