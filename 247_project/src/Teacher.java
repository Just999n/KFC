package src;
import java.util.ArrayList;
import java.util.Date;

public class Teacher extends User {
  private ArrayList<Course> courses;

  public Teacher(ArrayList<Course> courses) {
    super("", Type.TEACHER, "", "", 
          "", "", null);
    this.courses = courses;
    setType(Type.TEACHER);
  }

  public Teacher() {
    super("", Type.TEACHER, "", "", 
          "", "", null);
    this.courses = null;
  }

  public Teacher(String userName, Type type, String firstName, String lastName,
                String email, String password, Date birthdate) {
    super(userName, type, firstName, lastName, email, password, birthdate);
    this.courses = null;
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }

  public void setCourses(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public void print() {
    System.out.println("Teacher");
  }
}
