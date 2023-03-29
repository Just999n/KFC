import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    public void writeToJson(JSONObject save){
        JSONArray saveLessons = new JSONArray();
        for(Lessons l:lessons){
            JSONObject lOne = new JSONObject();
            l.writeToJson(lOne);
            saveLessons.add(lOne);
        }
        save.put("lessons", saveLessons);
        save.put("name", name);
        JSONObject qOne = new JSONObject();
        quiz.writeToJson(qOne);
        save.put("quiz", qOne);
        JSONArray saveComments = new JSONArray();
        for(Comments c:comments){
            JSONObject cOne = new JSONObject();
            c.writeToJson(cOne);
            saveComments.add(cOne);
        }
        save.put("comments", saveComments);
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
    public void addLessons(Lessons lesson){
        lessons.add(lesson);
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
        ArrayList<Lessons> l1 = lessons;
        for(Lessons l:l1){
            l.print();
        }
        //quiz.print();
        //System.out.println(lessons);
        ArrayList<Comments> c1 = comments;
        for(Comments c:c1){
            c.print();
        }
        //System.out.println(comments);
        ArrayList<Questions> q1 = quiz.getQuestions();
        for(Questions q:q1){
            q.print();
        }
        //System.out.println(quiz.getQuestions());
    }
}
