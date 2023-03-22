import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;
    public CourseList(){
        courses = new ArrayList<>();
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void delCourse(Course course){
        courses.remove(course);
    }
}
