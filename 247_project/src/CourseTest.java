import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CourseTest {
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
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourse.writeToJson(nonempty);
        JSONObject correctResult = new JSONObject();
        correctResult.put("title", "java");
        correctResult.put("languages", Languages.JAVASCRIPT.name().toLowerCase());
        correctResult.put("modules", new JSONArray());
        correctResult.put("comments", new JSONArray());
        assertEquals(correctResult, nonempty, "achieve write");
    }
    @Test
    public void testWriteToJsonEmpty(){
        JSONObject empty = null;
        Course defaultCourse = new Course("java", Languages.JAVASCRIPT, new ArrayList<Module>(), new ArrayList<Comments>());
        defaultCourse.writeToJson(empty);
        JSONObject correctResult = null;
        assertEquals(correctResult, empty);
    }
}
