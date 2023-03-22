import java.util.ArrayList;

public class CourseProgress {
    private Course course;
    private ArrayList<Double> grades;
    private int modulesConpleted;
    public CourseProgress(Course course, int modulesConpleted, ArrayList<Double> grades){
        this.course = course;
        this.grades = grades;
        this.modulesConpleted = modulesConpleted;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getModulesConpleted() {
        return modulesConpleted;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public void setModulesConpleted(int modulesConpleted) {
        this.modulesConpleted = modulesConpleted;
    }
}
