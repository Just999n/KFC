package src;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Quiz {
  private ArrayList<Question> questions;

  public Quiz(ArrayList<Question> questions) {
    this.questions = questions;
  }

  public ArrayList<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(ArrayList<Question> questions) {
    this.questions = questions;
  }

  public void writeToJson(JSONObject save){
    JSONArray saveQuestions = new JSONArray();
    for(Question q:questions){
        JSONObject qOne = new JSONObject();
        q.writeToJson(qOne);
        saveQuestions.add(qOne);
    }
    save.put("questions", saveQuestions);
  }
}
