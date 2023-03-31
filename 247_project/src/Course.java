package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Course {
  private String title;
  private Language language;
  private ArrayList<Module> modules;
  private ArrayList<Comment> comments;

  public Course(String title, Language language, ArrayList<Module> modules,
                  ArrayList<Comment> comments) {
    this.title = title;
    this.language = language;
    this.modules = modules;
    this.comments = comments;
  }

  public String getTitle() {
    return title;
  }

  public Language getLanguage() {
    return language;
  }

  public ArrayList<Module> getModules() {
    return modules;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public void setModules(ArrayList<Module> modules) {
    this.modules = modules;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  public void print() {
    System.out.println(title);
    System.out.println(language);

    for(Comment c : comments) {
      c.print();
    }

    for(Module m : modules) {
      m.print();
    }
  }

  public void writeToJson(JSONObject save){
    save.put("title", title);
    save.put("languages", language.name().toLowerCase());
    JSONArray saveModule = new JSONArray();
    for(Module m:modules){
        JSONObject mOne = new JSONObject();
        m.writeToJson(mOne);
        saveModule.add(mOne);
    }
    JSONArray saveComments = new JSONArray();
    for(Comment c:comments){
        JSONObject cOne = new JSONObject();
        c.writeToJson(cOne);
        saveComments.add(cOne);
    }
    save.put("modules", saveModule);
    save.put("comments", saveComments);
  }
}
