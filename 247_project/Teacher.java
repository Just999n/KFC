import java.util.ArrayList;
import java.util.Date;

public class Teacher extends User{
    private ArrayList<Course> courses;
    public Teacher(ArrayList<Course> courses){
        super("","","","","",null,Type.TEACHER);
        this.courses = courses;
        setType(Type.TEACHER);
    }
    public Teacher(){
        super("","","","","",null,Type.TEACHER);
        this.courses = null;
    }

    public Teacher(String name, String password, String firstName, String lastName, String email, Date date, Type teacher) {
        super(name,password,firstName,lastName,email,date,teacher);
        this.courses = null;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
}