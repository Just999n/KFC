import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Questions> questions;
    public Quiz(ArrayList<Questions> questions){
        this.questions = questions;
    }
    public ArrayList<Questions> getQuestions() {
        return questions;
    }
    public void writeToJson(JSONObject save){
        JSONArray saveQuestions = new JSONArray();
        for(Questions q:questions){
            JSONObject qOne = new JSONObject();
            q.writeToJson(qOne);
            saveQuestions.add(qOne);
        }
        save.put("questions", saveQuestions);
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}
