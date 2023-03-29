import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Course {
    private String title;
    private Languages languages;
    private ArrayList<Module> modules;
    private ArrayList<Comments> comments;
    public Course(String title, Languages languages, ArrayList<Module> modules, ArrayList<Comments> comments){
        this.title = title;
        this.languages = languages;
        this.modules = modules;
        this.comments = comments;
    }
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }
    public ArrayList<Comments> getComments() {
        return comments;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Module> getModules() {
        return modules;
    }
    public Languages getLanguages() {
        return languages;
    }
    public void setLanguages(Languages languages) {
        this.languages = languages;
    }
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void print(){
        System.out.println(title);
        System.out.println(languages);
        for(Comments c1:comments){
            c1.print();
        }
        //System.out.println(comments);
        for(Module m:modules){
            m.print();
        }
    }
    public void writeToJson(JSONObject save){
        save.put("title", title);
        save.put("languages", languages.name().toLowerCase());
        JSONArray saveModule = new JSONArray();
        for(Module m:modules){
            JSONObject mOne = new JSONObject();
            m.writeToJson(mOne);
            saveModule.add(mOne);
        }
        JSONArray saveComments = new JSONArray();
        for(Comments c:comments){
            JSONObject cOne = new JSONObject();
            c.writeToJson(cOne);
            saveComments.add(cOne);
        }
        save.put("modules", saveModule);
        save.put("comments", saveComments);
    }
}
