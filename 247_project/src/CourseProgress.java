package src;
import java.util.ArrayList;

public class CourseProgress {
  private Course course;
  private ArrayList<Double> grades;
  private int modulesCompleted;

  public CourseProgress(Course course, ArrayList<Double> grades, int
                          modulesCompleted) {
    this.course = course;
    this.grades = grades;
    this.modulesCompleted = modulesCompleted;
  }

  public Course getCourse() {
    return course;
  }

  public ArrayList<Double> getGrades() {
    return grades;
  }

  public int getModulesCompleted() {
    return modulesCompleted;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public void setGrades(ArrayList<Double> grades) {
    this.grades = grades;
  }

  public void setModulesCompleted(int modulesCompleted) {
    this.modulesCompleted = modulesCompleted;
  }

  public void printGrades() {
    ArrayList<Module> modules = course.getModules();
    for(int i = 0;i < modules.size(); i++) {
      System.out.println(modules.get(i).getTitle()+" "+grades.get(i));
    }
  }
}
