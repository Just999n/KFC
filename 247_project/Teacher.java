//BY Zhongsheng
import java.util.ArrayList;

public class Teacher extends User{
    private ArrayList<Course> courses;
    public Teacher(ArrayList<Course> courses){
        super();
        this.courses = courses;
        setType(Type.TEACHER);
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
}
