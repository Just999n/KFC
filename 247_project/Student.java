//BY Zhongsheng
import java.util.ArrayList;

public class Student extends User{
    private ArrayList<Course> courses;
    public Student(ArrayList<Course> courses){
        super();
        this.courses = courses;
        setType(Type.STUDENT);
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
