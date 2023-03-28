import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LMSApplicationFacade {
    private UserList users;
    private User nowUser;
    private CourseList courseList;
    public LMSApplicationFacade(){
        users = new UserList();
        ArrayList<User> t = DataLoader.read();
        assert t != null;
        for(User u:t){
            if(u.getType() == Type.STUDENT){
                users.addStudent((Student) u);
            }else{
                users.addTeacher((Teacher) u);
            }
        }
        courseList = new CourseList();
        nowUser = null;
    }
    public User Login(String name, String password, String firstName, String lastName, String email, Date birthdate, Type type){
        User pNew = new User(name, password, firstName, lastName, email, birthdate, type);
        if(type == Type.STUDENT){
            users.addStudent((Student) pNew);
        }else{
            users.addTeacher((Teacher) pNew);
        }
        //users.addUnconfirmed(pNew);
        return pNew;
    }
    public void mainLoop(Scanner scan){
        String name, password, fn, ln, bir, ema, type;
        Type choose;
        while(true){
            System.out.println("----Account registration or login interface----");
            System.out.print("Please enter user name(Enter \"quit\" to quit): ");
            name = scan.nextLine();
            if(name.equals("quit")){
                break;
            }
            System.out.print("Please enter password: ");
            password = scan.nextLine();
            nowUser = inUsers(name, password);
            if(nowUser == null){
                System.out.println("create new user.");
                System.out.print("Please enter first name: ");
                fn = scan.nextLine();
                System.out.print("Please enter last name: ");
                ln = scan.nextLine();
                System.out.print("Please enter birthday: ");
                bir = scan.nextLine();
                System.out.print("Please enter email: ");
                ema = scan.nextLine();
                System.out.print("1.student\n2.teacher\nPlease choose type: ");
                type = scan.nextLine();
                if(type.equals("1")){
                    choose = Type.STUDENT;
                }else{
                    choose = Type.TEACHER;
                }
                nowUser = Login(name, password,fn, ln, ema, new Date(bir),choose);
            }
            userLoop(scan);
            nowUser = null;
        }
        DataWriter.write(users.getStudents());
    }
    public void userLoop(Scanner scan){
        String choose;
        while(true){
            System.out.println("--------User operation interface--------");
            System.out.println("1.View personal data.");
            System.out.println("2.Edit personal data.");
            System.out.println("3.View course.");
            System.out.println("4.Exit current user.");
            System.out.print("Please choose: ");
            choose = scan.nextLine();
            switch (choose) {
                case "1":
                    System.out.println(nowUser);
                    break;
                case "2":
                    nowUser.editData(scan);
                    break;
                case "3":
                    courseLoop(scan);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
    public void courseLoop(Scanner scan){
        ArrayList<Course> courses = null;
        String choose;
        if(nowUser.getType() == Type.STUDENT){
            Student t = (Student) nowUser;
            courses = t.getCourses();
        }
        if(nowUser.getType() == Type.TEACHER){
            Teacher t = (Teacher) nowUser;
            courses = t.getCourses();
        }
        while(true) {
            for (int i = 0; i < Objects.requireNonNull(courses).size(); i++) {
                System.out.println(i + ". " + courses.get(i) + " language: " + courses.get(i).getLanguages());
            }
            System.out.print("Enter -1 to exit the course view and enter the index value to view the course details: ");
            choose = scan.nextLine();
            if(choose.equals("-1")){
                return;
            }
            int num = Integer.getInteger(choose);
            courses.get(num).print();
        }
    }
    public User inUsers(String name, String password){
        ArrayList<Teacher> t = users.getTeachers();
        ArrayList<Student> s = users.getStudents();
        ArrayList<User> u = users.getUnconfirmed();
        for(Teacher t1:t){
            if(t1.getUserName().equals(name) && t1.getPassword().equals(password)){
                return t1;
            }
        }
        for(Student s1:s){
            if(s1.getUserName().equals(name) && s1.getPassword().equals(password)){
                return s1;
            }
        }
        for(User u1:u){
            if(u1.getUserName().equals(name) && u1.getPassword().equals(password)){
                return u1;
            }
        }
        return null;
    }
    public void setUsers(UserList users) {
        this.users = users;
    }
    public UserList getUserList() {
        return users;
    }
}
