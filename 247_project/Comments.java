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
    public void setAuthor(User author) {
        this.author = author;
    }
    public void setReplies(ArrayList<Comments> replies) {
        this.replies = replies;
    }
}
