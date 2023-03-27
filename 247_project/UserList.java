import java.util.ArrayList;

public class UserList {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<User> unconfirmed;
    public UserList(){
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        unconfirmed = new ArrayList<>();
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<User> getUnconfirmed() {
        return unconfirmed;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void addUnconfirmed(User pNew){
        unconfirmed.add(pNew);
    }
    public void addStudent(Student newStudent){
        students.add(newStudent);
    }
    public void addTeacher(Teacher newTeacher){
        teachers.add(newTeacher);
    }
    public void logoutStudent(Student e){
        for(Student s:students){
            if(s.equals(e)){
                students.remove(s);
                break;
            }
        }
    }
    public void logoutTeacher(Teacher e){
        for(Teacher s:teachers){
            if(s.equals(e)){
                teachers.remove(s);
                break;
            }
        }
    }
}
