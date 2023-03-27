import java.util.ArrayList;
import java.util.Date;

public class Student extends User{
    private ArrayList<Course> courses;
    public Student(ArrayList<Course> courses){
        super("","","","","",null,Type.STUDENT);
        this.courses = courses;
        setType(Type.STUDENT);
    }
    public Student(){
        super("","","","","",null,Type.STUDENT);
        this.courses = null;
    }

    public Student(String name, String password, String firstName, String lastName, String email, Date date, Type student) {
        super(name,password,firstName,lastName,email,date,student);
        this.courses = null;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
