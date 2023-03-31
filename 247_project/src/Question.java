package src;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Question {
  private String question;
  private int correctAnswer;
  private ArrayList<String> options;

  public Question(String question, int correctAnswer, ArrayList<String> 
                  options) {
    this.question = question;
    this.correctAnswer = correctAnswer;
    this.options = options;
  }

  public void writeToJson(JSONObject save){
    save.put("question", question);
    save.put("correctAnswer", correctAnswer);
    JSONArray saveOptions = new JSONArray();
    for(String o:options){
        saveOptions.add(o);
    }
    save.put("options", saveOptions);
  }

  public String getQuestion() {
    return question;
  }

  public int getCorrectAnswer() {
    return correctAnswer;
  }

  public ArrayList<String> getOptions() {
    return options;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setCorrectAnswer(int correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public void setOptions(ArrayList<String> options) {
    this.options = options;
  }

  public void print() {
    System.out.println(question);
    System.out.println();
    System.out.println(options);
  }
}
