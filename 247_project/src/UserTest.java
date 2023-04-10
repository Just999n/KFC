import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class UserTest {
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
        Date birthday = new Date("2001/1/3");
        User defaultUser = new User("name1", "123456", "fn1", "ln1", "em1", birthday, Type.STUDENT);
        defaultUser.writeToJson(nonempty);
        correctResult.put("userName", "name1");
        correctResult.put("password", "123456");
        correctResult.put("firstName", "fn1");
        correctResult.put("lastName", "ln1");
        correctResult.put("email", "em1");
        correctResult.put("type", Type.STUDENT.name().toLowerCase());
        correctResult.put("birthday", birthday.toString());
        assertEquals(correctResult, nonempty);
    }

    @Test
    public void testWriteToJsonEmpty(){
        JSONObject nonempty = null;
        JSONObject correctResult = null;
        User defaultUser = new User("name1", "123456", "fn1", "ln1", "em1", new Date("2001/1/3"), Type.STUDENT);
        defaultUser.writeToJson(nonempty);
        assertEquals(correctResult, nonempty);
    }
}
