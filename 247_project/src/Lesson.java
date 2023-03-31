package src;

import org.json.simple.JSONObject;

public class Lesson {
  private String title;
  private String content;

  public Lesson(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void writeToJson(JSONObject save){
    save.put("name", title);
    save.put("lessonContent", content);
}

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void print() {
    System.out.println(title);
    System.out.println();
    System.out.println(content);

  }
}
