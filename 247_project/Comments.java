import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Comments {
    private String comment;
    private User author;
    private ArrayList<Comments> replies;
    public Comments(String comment, User author, ArrayList<Comments> replies){
        this.comment = comment;
        this.author = author;
        this.replies = replies;
    }
    public void writeToJson(JSONObject save){
        save.put("comment", comment);
        JSONObject aOne = new JSONObject();
        author.writeToJson(aOne);
        save.put("author", aOne);
        JSONArray saveReplies = new JSONArray();
        if(replies != null){
            for(Comments c:replies){
                JSONObject cOne = new JSONObject();
                c.writeToJson(cOne);
                saveReplies.add(cOne);
            }
        }
        save.put("replies", saveReplies);
    }
    public void addReplies(Comments comments){
        replies.add(comments);
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public ArrayList<Comments> getReplies() {
        return replies;
    }
    public User getAuthor() {
        return author;
    }
    public void print(){
        System.out.println(comment);
        System.out.println(author);
        ArrayList<Comments> r1 = replies;
        if(r1 != null) {
            for (Comments r : r1) {
                r.print();
            }
        }else{
            System.out.println(new ArrayList<>());
        }
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public void setReplies(ArrayList<Comments> replies) {
        this.replies = replies;
    }
}
