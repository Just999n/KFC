import java.util.ArrayList;

public class Module {
    private ArrayList<Lessons> lessons;
    private String name;
    private Quiz quiz;
    private ArrayList<Comments> comments;
    public Module(ArrayList<Lessons> lessons, String name, Quiz quiz, ArrayList<Comments> comments){
        this.comments = comments;
        this.quiz = quiz;
        this.name = name;
        this.lessons = lessons;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Comments> getComments() {
        return comments;
    }
    public ArrayList<Lessons> getLessons() {
        return lessons;
    }
    public Quiz getQuiz() {
        return quiz;
    }
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }
    public void setLessons(ArrayList<Lessons> lessons) {
        this.lessons = lessons;
    }
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    public void print(){
        System.out.println(name);
        System.out.println(lessons);
        System.out.println(comments);
        ArrayList<Questions> q1 = quiz.getQuestions();
        for(Questions q:q1){
            q.print();
        }
        //System.out.println(quiz.getQuestions());
    }
}
