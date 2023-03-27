import java.util.ArrayList;

public class Questions {
    private String question;
    private int correctAnswer;
    private ArrayList<String> options;
    public Questions(String question, int correctAnswer, ArrayList<String> options){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }
    public String getQuestion() {
        return question;
    }
    public void print(){
        System.out.println(question);
        System.out.println(options);
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public ArrayList<String> getOptions() {
        return options;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
