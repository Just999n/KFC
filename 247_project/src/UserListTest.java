import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class UserListTest {
    @BeforeClass
    public static void oneTimeSetup() {

    }

    @AfterClass
    public static void oneTimeTearDown() {

    }

    @BeforeEach
    public void setup() {
        //runs before each test
    }

    @AfterEach
    public void tearDown() {
        //runs after each test
    }

    @Test
    public void testAddUnconfirmedNonempty(){
        UserList defaultUserList = new UserList();
        ArrayList<User> userArrayList = new ArrayList<>();
        User defaultUser = new User("name1", "123456", "fn1", "ln1", "em1", new Date("2001/1/21"), Type.STUDENT);
        userArrayList.add(defaultUser);
        defaultUserList.addUnconfirmed(defaultUser);
        assertEquals(userArrayList, defaultUserList.getUnconfirmed());
    }

    @Test
    public void testAddUnconfirmedEmpty(){
        UserList defaultUserList = new UserList();
        ArrayList<User> userArrayList = new ArrayList<>();
        User defaultUser = null;
        userArrayList.add(defaultUser);
        defaultUserList.addUnconfirmed(defaultUser);
        assertEquals(userArrayList, defaultUserList.getUnconfirmed());
    }

    @Test
    public void testAddStudentNonempty(){
        UserList defaultUserList = new UserList();
        ArrayList<Student> userArrayList = new ArrayList<>();
        Student defaultUser = new Student("name1", "123456", "fn1", "ln1", "em1", new Date("2001/1/21"), Type.STUDENT);
        userArrayList.add(defaultUser);
        defaultUserList.addStudent(defaultUser);
        assertEquals(userArrayList, defaultUserList.getStudents());
    }

    @Test
    public void testAddStudentEmpty(){
        UserList defaultUserList = new UserList();
        ArrayList<Student> userArrayList = new ArrayList<>();
        Student defaultUser = null;
        userArrayList.add(defaultUser);
        defaultUserList.addStudent(defaultUser);
        assertEquals(userArrayList, defaultUserList.getStudents());
    }

    @Test
    public void testAddTeacherNonempty(){
        UserList defaultUserList = new UserList();
        ArrayList<Teacher> userArrayList = new ArrayList<>();
        Teacher defaultUser = new Teacher("name1", "123456", "fn1", "ln1", "em1", new Date("2001/1/21"), Type.STUDENT);
        userArrayList.add(defaultUser);
        defaultUserList.addTeacher(defaultUser);
        assertEquals(userArrayList, defaultUserList.getTeachers());
    }

    @Test
    public void testAddTeacherEmpty(){
        UserList defaultUserList = new UserList();
        ArrayList<Teacher> userArrayList = new ArrayList<>();
        Teacher defaultUser = null;
        userArrayList.add(defaultUser);
        defaultUserList.addTeacher(defaultUser);
        assertEquals(userArrayList, defaultUserList.getTeachers());
    }
}
