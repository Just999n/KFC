package src;
import java.util.ArrayList;
import java.util.Date;

public class Student extends User {
  private ArrayList<Course> courses;
  private ArrayList<CourseProgress> courseProgresses;

  public Student(ArrayList<Course> courses) {
    super("", Type.STUDENT, "", "", 
          "", "", null);
    this.courses = courses;
    setType(Type.STUDENT);
  }

  public Student() {
    super("", Type.STUDENT, "", "", 
          "", "", null);
    this.courses = null;
  }

  public Student(String userName, Type type, String firstName, String lastName,
                String email, String password, Date birthdate) {
    super(userName, type, firstName, lastName, email, password, birthdate);
    this.courses = null;
    this.courseProgresses = new ArrayList<>();
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }

  public ArrayList<CourseProgress> getCourseProgresses() {
    return courseProgresses;
  }

  public void setCourses(ArrayList<Course> courses) {
    for(int i = 0;i < courses.size(); i++) {
      courseProgresses.get(i).setCourse(courses.get(i));
    }
    this.courses = courses;
  }

  public void setCourseProgresses(ArrayList<CourseProgress> courseProgresses) {
    this.courseProgresses = courseProgresses;
  }

  public void print() {
    System.out.println("Student");
  }
}
