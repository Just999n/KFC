import java.util.ArrayList;
import java.util.Date;

public class Student extends User{
    private ArrayList<Course> courses;
    private ArrayList<CourseProgress> courseProgresses;
    //private ArrayList<String>
    public Student(ArrayList<Course> courses){
        super("","","","","",null,Type.STUDENT);
        this.courses = courses;
        setType(Type.STUDENT);
    }
    public Student(){
        super("","","","","",null,Type.STUDENT);
        this.courses = null;
    }

    public ArrayList<CourseProgress> getCourseProgresses() {
        return courseProgresses;
    }

    public void setCourseProgresses(ArrayList<CourseProgress> courseProgresses) {
        this.courseProgresses = courseProgresses;
    }

    public Student(String name, String password, String firstName, String lastName, String email, Date date, Type student) {
        super(name,password,firstName,lastName,email,date,student);
        this.courses = null;
        this.courseProgresses = new ArrayList<>();
    }
    public void print(){
        System.out.println("学生");
    }

    public void setCourses(ArrayList<Course> courses) {
        for(int i = 0;i<courses.size();i++){
            courseProgresses.get(i).setCourse(courses.get(i));
        }
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
