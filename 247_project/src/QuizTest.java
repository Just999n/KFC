import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class QuizTest {
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
        ArrayList<Questions> questionsArrayList = new ArrayList<>();
        JSONObject nonempty = new JSONObject();
        JSONObject correctResult = new JSONObject();
        JSONArray saveQuestionsArrayList = new JSONArray();
        Quiz defaultQuiz = new Quiz(questionsArrayList);
        defaultQuiz.writeToJson(nonempty);
        correctResult.put("questions", saveQuestionsArrayList);
        assertEquals(correctResult, nonempty);
    }

    @Test
    public void testWriteToJsonEmpty(){
        ArrayList<Questions> questionsArrayList = new ArrayList<>();
        JSONObject nonempty = null;
        JSONObject correctResult = null;
        Quiz defaultQuiz = new Quiz(questionsArrayList);
        defaultQuiz.writeToJson(nonempty);
        assertEquals(correctResult, nonempty);
    }
}
