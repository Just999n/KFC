package src;
 
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Comment {
  private String comment;
  private User author;
  private ArrayList<Comment> replies;

  public Comment(String comment, User author, ArrayList<Comment> replies) {
    this.comment = comment;
    this.author = author;
    this.replies = replies;
  }

  public String getComment() {
    return comment;
  }

  public User getAuthor() {
    return author;
  }

  public ArrayList<Comment> getReplies() {
    return replies;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public void setReplies(ArrayList<Comment> replies) {
    this.replies = replies;
  }

  public void addReplies(Comment comment) {
    replies.add(comment);
  }

  public void print() {
    System.out.println(comment);
    System.out.println("\t- "+author);

    ArrayList<Comment> r1 = replies;
    if(r1 != null) {
      for(Comment r: r1) {
        r.print();
      }
    }else{
      System.out.println(new ArrayList<>());
    }
  }

  public void writeToJson(JSONObject save){
    save.put("comment", comment);
    JSONObject aOne = new JSONObject();
    author.writeToJson(aOne);
    save.put("author", aOne);
    JSONArray saveReplies = new JSONArray();
    if(replies != null){
        for(Comment c:replies){
            JSONObject cOne = new JSONObject();
            c.writeToJson(cOne);
            saveReplies.add(cOne);
        }
    }
    save.put("replies", saveReplies);
  }
}
 
