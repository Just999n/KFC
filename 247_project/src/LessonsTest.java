import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LessonsTest {
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
        Lessons defaultLesson = new Lessons("lessons1", "lessons content1");
        correctResult.put("name", "lessons1");
        correctResult.put("lessonContent", "lessons content1");
        defaultLesson.writeToJson(nonempty);
        assertEquals(correctResult, nonempty);
    }

    @Test
    public void testWriteToJsonEmpty(){
        JSONObject nonempty = null;
        JSONObject correctResult = null;
        Lessons defaultLesson = new Lessons("lessons1", "lessons content1");
        defaultLesson.writeToJson(nonempty);
        assertEquals(correctResult, nonempty);
    }
}
