package src;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Module {
  private String title;
  private ArrayList<Lesson> lessons;
  private Quiz quiz;
  private ArrayList<Comment> comments;

  public Module(String title, ArrayList<Lesson> lessons, Quiz quiz,
                  ArrayList<Comment> comments) {
    this.title = title;
    this.lessons = lessons;
    this.quiz = quiz;
    this.comments = comments;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<Lesson> getLessons() {
    return lessons;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLessons(ArrayList<Lesson> lessons) {
    this.lessons = lessons;
  }

  public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  public void addLesson(Lesson lesson) {
    lessons.add(lesson);
  }

  public void print() {
    System.out.println(title);

    ArrayList<Lesson> l1 = lessons;
    for(Lesson l : l1) {
      l.print();
    }

    ArrayList<Comment> c1 = comments;
    for(Comment c : c1) {
      c.print();
    }

    ArrayList<Question> q1 = quiz.getQuestions();
    for(Question q : q1) {
      q.print();
    }
  }

  public void writeToJson(JSONObject save){
    JSONArray saveLessons = new JSONArray();
    for(Lesson l:lessons){
        JSONObject lOne = new JSONObject();
        l.writeToJson(lOne);
        saveLessons.add(lOne);
    }
    save.put("lessons", saveLessons);
    save.put("name", title);
    JSONObject qOne = new JSONObject();
    quiz.writeToJson(qOne);
    save.put("quiz", qOne);
    JSONArray saveComments = new JSONArray();
    for(Comment c:comments){
        JSONObject cOne = new JSONObject();
        c.writeToJson(cOne);
        saveComments.add(cOne);
    }
    save.put("comments", saveComments);
  }
}
