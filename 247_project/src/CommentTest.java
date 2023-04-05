//by Zhongsheng Li
package src;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class CommentTest {
  private Comment comment;
  private User author;
  private ArrayList<Comment> replies;

  @Before
  public void setUp() {
    author = new User("John", "Doe");
    replies = new ArrayList<>();
    Comment reply = new Comment("This is a reply", author, null);
    replies.add(reply);
    comment = new Comment("This is a comment", author, replies);
  }

  @Test
  public void testGetComment() {
    assertEquals("This is a comment", comment.getComment());
  }

  @Test
  public void testGetAuthor() {
    assertEquals(author, comment.getAuthor());
  }

  @Test
  public void testGetReplies() {
    assertEquals(replies, comment.getReplies());
  }

  @Test
  public void testSetComment() {
    comment.setComment("New comment");
    assertEquals("New comment", comment.getComment());
  }

  @Test
  public void testSetAuthor() {
    User newAuthor = new User("Jane", "Doe");
    comment.setAuthor(newAuthor);
    assertEquals(newAuthor, comment.getAuthor());
  }

  @Test
  public void testSetReplies() {
    ArrayList<Comment> newReplies = new ArrayList<>();
    comment.setReplies(newReplies);
    assertEquals(newReplies, comment.getReplies());
  }

  @Test
  public void testAddReplies() {
    Comment newReply = new Comment("Another reply", author, null);
    comment.addReplies(newReply);
    assertEquals(2, comment.getReplies().size());
  }

  @Test
  public void testPrint() {
    // Redirect stdout to a StringBuilder
    StringBuilder sb = new StringBuilder();
    System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
      public void flush() {
        sb.append(new String(toByteArray()));
      }
    }));

    comment.print();

    assertEquals("This is a comment\n\t- John Doe\n\tThis is a reply\n\t\t- John Doe\n", sb.toString());
  }

  @Test
  public void testWriteToJson() {
    JSONObject expected = new JSONObject();
    expected.put("comment", "This is a comment");

    JSONObject authorJson = new JSONObject();
    authorJson.put("firstName", "John");
    authorJson.put("lastName", "Doe");
    expected.put("author", authorJson);

    JSONArray repliesJson = new JSONArray();
    JSONObject replyJson = new JSONObject();
    replyJson.put("comment", "This is a reply");
    JSONObject replyAuthorJson = new JSONObject();
    replyAuthorJson.put("firstName", "John");
    replyAuthorJson.put("lastName", "Doe");
    replyJson.put("author", replyAuthorJson);
    repliesJson.add(replyJson);
    expected.put("replies", repliesJson);

    JSONObject actual = new JSONObject();
    comment.writeToJson(actual);

    assertEquals(expected.toJSONString(), actual.toJSONString());
  }
}
