import java.util.ArrayList;

public class Quiz {
    private ArrayList<Questions> questions;
    public Quiz(ArrayList<Questions> questions){
        this.questions = questions;
    }
    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}
