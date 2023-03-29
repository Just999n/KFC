import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LMSApplicationFacede {
    private UserList users;
    private Student nowStudent;
    private Teacher nowTeacher;
    private User nowUser;
    private CourseList courseList;
    public LMSApplicationFacede(){
        users = new UserList();
        ArrayList<User> t = DataLoader.read();
        courseList = new CourseList();
        courseList.setCourses(DataLoader.readGetCourse());
        assert t != null;
        for(User u:t){
            if(u.getType() == Type.STUDENT){
                Student pNew = (Student) u;
                pNew.setCourses(courseList.getCourses());
                users.addStudent(pNew);
            }else{
                Teacher pNew = (Teacher) u;
                pNew.setCourses(courseList.getCourses());
                users.addTeacher(pNew);
            }
            users.addUnconfirmed(u);
        }
        nowStudent = null;
        nowTeacher = null;
        nowUser = null;
    }
    public void Login(String name, String password, String firstName, String lastName, String email, Date birthdate, Type type){
        //User pNew = new User(name, password, firstName, lastName, email, birthdate, type);
        if(type == Type.STUDENT){
            nowStudent = new Student(name, password, firstName, lastName, email, birthdate, type);
            nowTeacher = null;
            users.addStudent(nowStudent);
            users.addUnconfirmed(nowStudent);
        }else{
            nowTeacher = new Teacher(name, password, firstName, lastName, email, birthdate, type);
            nowStudent = null;
            users.addTeacher(nowTeacher);
            users.addUnconfirmed(nowTeacher);
        }
        //users.addUnconfirmed(pNew);
    }
    public void mainLoop(Scanner scan){
        String name, password, fn, ln, bir, ema, type;
        Type choose;
        while(true){
            System.out.println("------------Main Menu------------");
            System.out.println("1.Create an account.");
            System.out.println("2.Login account.");
            System.out.println("3.View course title.");
            System.out.println("4.Exit current account.");
            System.out.println("5.Exit system.");
            System.out.print("Please choose: ");
            name = scan.nextLine();
            if(name.equals("1")){
                System.out.print("Please enter user name:");
                name = scan.nextLine();
                System.out.print("Please enter password: ");
                password = scan.nextLine();
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
                Login(name, password,fn, ln, ema, new Date(bir),choose);
            } else if (name.equals("2")) {
                System.out.print("Please enter user name:");
                name = scan.nextLine();
                System.out.print("Please enter password: ");
                password = scan.nextLine();
                if(!inUsers(name, password)){
                    System.out.println("No one has been found.");
                }
            } else if (name.equals("3")) {
                courseLoop(courseList.getCourses(), scan);

            } else if (name.equals("4")) {
                nowStudent = null;
                nowTeacher = null;
            }else if(name.equals("5")){
                break;
            }else{
                System.out.println("Invalid input.");
            }
        }
        DataWriter.write(users.getStudents(), users.getTeachers());
        DataWriter.writeCourses(courseList.getCourses());
    }
    public void courseLoop(ArrayList<Course> courses, Scanner scan){
        String choose = "";
        while(true){
            System.out.println("----course menu----");
            for(int i = 0;i<courses.size();i++){
                System.out.print(i+1+"."+courses.get(i).getTitle());
                if(nowTeacher == null && nowStudent != null){
                    ArrayList<CourseProgress> courseProgresses = nowStudent.getCourseProgresses();
                    for(CourseProgress cp:courseProgresses){
                        //System.out.println("测试1 "+cp.getModulesConpleted()+" "+courses.get(i).getModules().size()+" "+cp.getCourse().getTitle()+" "+courses.get(i).getTitle());
                        if(cp.getCourse().getTitle().equals(courses.get(i).getTitle()) && cp.getModulesConpleted() == courses.get(i).getModules().size()){
                            System.out.print(" Have completed");
                        }
                    }
                }
                System.out.println();
            }
            if(nowStudent != null && nowTeacher == null){
                System.out.println("Enter \"grade\" to view your score.");
                System.out.println("Enter \"print\" to print the certificate");

            }
            System.out.println("Enter the number to view the corresponding course title.");
            System.out.println("Enter -1 to exit the current screen.");
            System.out.print("Pleases choose: ");
            choose = scan.nextLine();
            if(choose.equals("-1")){
                break;
            }
            if(nowStudent != null && nowTeacher == null && choose.equals("grade")){
                for (Course cours : courses) {
                    if (nowTeacher == null && nowStudent != null) {
                        ArrayList<CourseProgress> courseProgresses = nowStudent.getCourseProgresses();
                        for (CourseProgress cp : courseProgresses) {
                            if (cp.getCourse().getTitle().equals(cours.getTitle()) && cp.getModulesConpleted() == cours.getModules().size()) {
                                cp.printGrades();
                                break;
                            }
                        }
                    }
                }
                continue;
            }
            if(nowStudent != null && nowTeacher == null && choose.equals("print")){
                for (Course cours : courses) {
                    if (nowTeacher == null && nowStudent != null) {
                        ArrayList<CourseProgress> courseProgresses = nowStudent.getCourseProgresses();
                        for (CourseProgress cp : courseProgresses) {
                            if (cp.getCourse().getTitle().equals(cours.getTitle()) && cp.getModulesConpleted() == cours.getModules().size()) {
                                System.out.println(cours.getTitle() + " Certificate of course completion.");
                            }
                        }
                    }
                }
                continue;
            }
            if(Integer.parseInt(choose)>=courses.size()){
                System.out.println("Invalid input.");
                continue;
            }
            moduleLoop(scan, courses.get(Integer.parseInt(choose)-1));
        }
    }
    public void moduleLoop(Scanner scan, Course course){
        String choose;
        ArrayList<Module> modules = course.getModules();
        while(true){
            System.out.println("----module menu----");
            for(int i = 0;i<modules.size();i++){
                System.out.println(i+1+"."+modules.get(i).getName());
            }
            System.out.println("Enter the number to view the corresponding course module title.");
            System.out.println("Enter -1 to exit the current screen.");
            System.out.print("Pleases input: ");
            choose = scan.nextLine();
            if(choose.equals("-1")){
                break;
            }
            if(Integer.parseInt(choose)>=modules.size()){
                System.out.println("Invalid input.");
                continue;
            }
            moduleContentLoop(modules.get(Integer.parseInt(choose)-1), scan);
        }
    }
    public void moduleContentLoop(Module module, Scanner scan){
        String choose;
        ArrayList<Lessons> lessons = module.getLessons();
        for(Lessons l:lessons){
            l.print();
        }
        while(true){
            System.out.println("----module content menu----");
            System.out.println("1.Add a problem to the current module(Required identity permission is the teacher).");
            System.out.println("2.Add lessons to the current module(Required identity permission is the teacher).");
            System.out.println("3.View the problem");
            System.out.println("4.Start testing(Required identity permissions are students).");
            System.out.println("5.To comment(Required identity permissions are students).");
            System.out.println("6.View lessons(Required identity permissions are students).");
            System.out.println("7.Exit the current screen.");
            System.out.print("Pleases choose: ");
            choose = scan.nextLine();
            if(choose.equals("1")){
                if(nowStudent != null && nowTeacher == null){
                    System.out.println("Lack of authority");
                    continue;
                }
                Quiz quiz = module.getQuiz();
                ArrayList<Questions> questions = quiz.getQuestions();
                System.out.print("Please enter a description of the problem: ");
                String questionContent = scan.nextLine();
                System.out.print("Please confirm the correct answer to the question: ");
                String correct = scan.nextLine();
                System.out.println("Enter four answers in turn.");
                ArrayList<String> answer = new ArrayList<>();
                for(int i = 0;i<4;i++){
                    String oneAnswer = scan.nextLine();
                    answer.add(oneAnswer);
                }
                Questions question = new Questions(questionContent, Integer.parseInt(correct), answer);
                questions.add(question);
                module.setQuiz(quiz);
            }
            if(choose.equals("2")){
                if(nowStudent != null && nowTeacher == null){
                    System.out.println("Lack of authority");
                    continue;
                }
                System.out.print("Input lesson name: ");
                String lessonName = scan.nextLine();
                System.out.print("Input lesson lesson content: ");
                String lessonContent = scan.nextLine();
                module.addLessons(new Lessons(lessonName, lessonContent));
            }
            if(choose.equals("3")){
                ArrayList<Questions> questions = module.getQuiz().getQuestions();
                for(Questions q:questions) {
                    q.print();
                }
            }
            if(choose.equals("4")){
                if(nowStudent == null && nowTeacher != null){
                    System.out.println("Please log in the student account first");
                    continue;
                }
                ArrayList<Questions> questions = module.getQuiz().getQuestions();
                int correctNum = 0;
                for(Questions q:questions){
                    q.print();
                    System.out.print("Input answer: ");
                    String input = scan.nextLine();
                    if(Integer.parseInt(input) == q.getCorrectAnswer()){
                        System.out.println("Answer correctly");
                        correctNum++;
                    }else{
                        System.out.println("Unfortunately, wrong answer");
                    }
                }
                ArrayList<CourseProgress> courseProgresses = nowStudent.getCourseProgresses();
                boolean flag = false;
                int i = 0;
                for(i = 0;i<courseProgresses.size();i++){
                    ArrayList<Module> modules = courseProgresses.get(i).getCourse().getModules();
                    for(Module m:modules){
                        if(m.getName().equals(module.getName())){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                ArrayList<Double> grades = courseProgresses.get(i).getGrades();
                grades.add((double) (correctNum/ questions.size()));
                courseProgresses.get(i).setGrades(grades);
                nowStudent.setCourseProgresses(courseProgresses);
            }
            if(choose.equals("5")){
                if(nowStudent == null && nowTeacher != null){
                    System.out.println("Please log in the student account first");
                    continue;
                }
                toComments(module, scan);
            }
            if(choose.equals("6")){
                if(nowStudent == null && nowTeacher != null){
                    System.out.println("Please log in the student account first");
                    continue;
                }
                for(Lessons l:lessons){
                    l.print();
                }
            }
            if(choose.equals("7")){
                return;
            }
        }
    }
    public void toComments(Module module, Scanner scan){
        String choose, content;
        ArrayList<Comments> comments = module.getComments();
        for(Comments c:comments){
            c.print();
        }
        while(true){
            System.out.print("Type in the person you want to respond to(Or enter quit to exit the reply screen): ");
            choose = scan.nextLine();
            if(choose.equals("quit")){
                break;
            }
            for(Comments c:comments){
                if(choose.equals(c.getAuthor().getUserName())){
                    System.out.print("Input reply content: ");
                    content = scan.nextLine();
                    c.addReplies(new Comments(content, nowStudent, null));
                    break;
                }
            }
        }
    }
    public boolean inUsers(String name, String password){
        ArrayList<Teacher> t = users.getTeachers();
        ArrayList<Student> s = users.getStudents();
        nowTeacher = null;
        nowStudent = null;
        for(Teacher t1:t){
            if(t1.getUserName().equals(name) && t1.getPassword().equals(password)){
                nowTeacher = t1;
                nowStudent = null;
                return true;
            }
        }
        for(Student s1:s){
            if(s1.getUserName().equals(name) && s1.getPassword().equals(password)){
                nowStudent = s1;
                nowTeacher = null;
                return true;
            }
        }
        return false;
    }
    public void setUsers(UserList users) {
        this.users = users;
    }
    public UserList getUserList() {
        return users;
    }
}
