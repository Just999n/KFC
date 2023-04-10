import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CourseListTest {
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
    public void testAddCourseNonempty(){
        CourseList defaultCourseList = new CourseList();
        ArrayList<Course> correctResult = new ArrayList<>();
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourseList.addCourse(defaultCourse);
        correctResult.add(defaultCourse);
        assertEquals(correctResult, defaultCourseList.getCourses());
    }

    @Test
    public void testAddCourseEmpty(){
        CourseList defaultCourseList = new CourseList();
        ArrayList<Course> correctResult = new ArrayList<>();
        Course emptyCourse = null;
        defaultCourseList.addCourse(emptyCourse);
        correctResult.add(emptyCourse);
        assertEquals(correctResult, defaultCourseList.getCourses());
    }

    @Test
    public void testDelCourseExisting(){
        CourseList defaultCourseList = new CourseList();
        ArrayList<Course> correctResult = new ArrayList<>();
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourseList.addCourse(defaultCourse);
        correctResult.add(defaultCourse);
        defaultCourseList.delCourse(defaultCourse);
        correctResult.remove(defaultCourse);
        assertEquals(correctResult, defaultCourseList.getCourses());
    }

    @Test
    public void testDelCourseNotExisting(){
        CourseList defaultCourseList = new CourseList();
        ArrayList<Course> correctResult = new ArrayList<>();
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourseList.addCourse(defaultCourse);
        correctResult.add(defaultCourse);
        Course defaultDelCourse = new Course("python", Languages.PYTHON, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourseList.delCourse(defaultDelCourse);
        correctResult.remove(defaultDelCourse);
        assertEquals(correctResult, defaultCourseList.getCourses());
    }

    @Test
    public void testDelCourseEmpty(){
        CourseList defaultCourseList = new CourseList();
        ArrayList<Course> correctResult = new ArrayList<>();
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourseList.addCourse(defaultCourse);
        correctResult.add(defaultCourse);
        Course emptyCourse = null;
        defaultCourseList.delCourse(emptyCourse);
        correctResult.remove(emptyCourse);
        assertEquals(correctResult, defaultCourseList.getCourses());
    }
}
