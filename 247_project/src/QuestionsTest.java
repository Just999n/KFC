import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class QuestionsTest {
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
        ArrayList<String> defaultOptions = new ArrayList<>();
        Questions defaultQuestion = new Questions("question 1", 2, defaultOptions);
        JSONObject nonempty = new JSONObject();
        defaultQuestion.writeToJson(nonempty);
        JSONObject correctResult = new JSONObject();
        JSONArray saveOptions = new JSONArray();
        correctResult.put("question", "question 1");
        correctResult.put("correctAnswer", 2);
        correctResult.put("options", saveOptions);
        assertEquals(correctResult, nonempty);
    }

    @Test
    public void testWriteToJsonEmpty(){
        ArrayList<String> defaultOptions = new ArrayList<>();
        Questions defaultQuestion = new Questions("question 1", 2, defaultOptions);
        JSONObject nonempty = null;
        defaultQuestion.writeToJson(nonempty);
        JSONObject correctResult = null;
        assertEquals(correctResult, nonempty);
    }
}
