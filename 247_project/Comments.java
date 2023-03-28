/**
 * Comments Class
 * @author KFC
 */
import java.util.ArrayList;

public class Comments {
    private String comment;
    private User author;
    private ArrayList<Comments> replies;

    /**
     * Constructor of the comment object.
     * @param comment The actual comment in string form.
     * @param author The author of the comment as a user object.
     * @param replies A list of replies to the comment.
     */
    public Comments(String comment, User author, ArrayList<Comments> replies){
        this.comment = comment;
        this.author = author;
        this.replies = replies;
    }

    /**
     * Accessor of the comment.
     * @return The comment as a string.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Accessor for the list of replies of the comment.
     * @return
     */
    public ArrayList<Comments> getReplies() {
        return replies;
    }

    /**
     * Accessor for the author of the comment.
     * @return The author as a user object
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the string parameter of the comment.
     * @param comment A string of the comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Sets the author of the comment.
     * @param author The author of the comment as a user object.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Sets the list of replies of the comment.
     * @param replies An array list of the replies.
     */
    public void setReplies(ArrayList<Comments> replies) {
        this.replies = replies;
    }
}
