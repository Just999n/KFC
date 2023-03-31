package src;
import java.util.ArrayList;

public class UserList {
  private ArrayList<Teacher> teachers;
  private ArrayList<Student> students;
  private ArrayList<User> unconfirmed;

  public UserList() {
    teachers = new ArrayList<>();
    students = new ArrayList<>();
    unconfirmed = new ArrayList<>();
  }

  public ArrayList<Teacher> getTeachers() {
    return teachers;
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  public ArrayList<User> getUnconfirmed() {
    return unconfirmed;
  }

  public void addTeacher(Teacher newTeacher) {
    teachers.add(newTeacher);
  }

  public void addStudent(Student newStudent) {
    students.add(newStudent);
  }

  public void addUnconfirmed(User newUser) {
    unconfirmed.add(newUser);
  }
}
