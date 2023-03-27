import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataConstants {
    public JSONParser parser;
    public Object obj;
    public JSONObject jsonObject;
    protected static final String USER_FILE_NAME = "src/users.json";
    protected static final String USER_ID = "id";
    protected static final String USER_USER_NAME = "userName";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_BIRTHDAY = "birthday";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_TYPE = "type";
    public DataConstants(){
        parser = null;
        obj = null;
        jsonObject = null;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public JSONParser getParser() {
        return parser;
    }

    public Object getObj() {
        return obj;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setParser(JSONParser parser) {
        this.parser = parser;
    }
}
