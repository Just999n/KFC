import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ModuleTest {
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
    public void testWriteToJsonNonempty(){
        JSONObject nonempty = new JSONObject();
        JSONObject correctResult = new JSONObject();
        JSONObject saveQuiz = new JSONObject();
        JSONArray saveLessons = new JSONArray();
        JSONArray saveComments = new JSONArray();
        ArrayList<Lessons> lessonsArrayList = new ArrayList<>();
        ArrayList<Comments> commentsArrayList = new ArrayList<>();
        Module defaultModule = new Module(lessonsArrayList, "module1", null, commentsArrayList);
        defaultModule.writeToJson(nonempty);
        correctResult.put("name", "module1");
        correctResult.put("lessons", saveLessons);
        correctResult.put("comments", saveComments);
        correctResult.put("quiz", saveQuiz);
        assertEquals(correctResult, nonempty);
    }

    @Test
    public void testWriteToJsonEmpty(){
        JSONObject empty = null;
        JSONObject correctResult = null;
        ArrayList<Lessons> lessonsArrayList = new ArrayList<>();
        ArrayList<Comments> commentsArrayList = new ArrayList<>();
        Module defaultModule = new Module(lessonsArrayList, "module1", null, commentsArrayList);
        defaultModule.writeToJson(empty);
        assertEquals(correctResult, empty);
    }

    @Test
    public void testAddLessonsNonempty(){
        ArrayList<Lessons> lessonsArrayList = new ArrayList<>();
        ArrayList<Lessons> correctResult = new ArrayList<>();
        Module defaultModule = new Module(lessonsArrayList, "module1", null, null);
        Lessons defaultLesson = new Lessons("lessons1", "lessons content1");
        defaultModule.addLessons(defaultLesson);
        correctResult.add(defaultLesson);
        assertEquals(correctResult, defaultModule.getLessons());
    }

    @Test
    public void testAddLessonsEmpty(){
        ArrayList<Lessons> lessonsArrayList = new ArrayList<>();
        ArrayList<Lessons> correctResult = new ArrayList<>();
        Module defaultModule = new Module(lessonsArrayList, "module1", null, null);
        Lessons defaultLesson = null;
        defaultModule.addLessons(defaultLesson);
        correctResult.add(defaultLesson);
        assertEquals(correctResult, defaultModule.getLessons());
    }
}
