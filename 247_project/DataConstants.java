import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataConstants {
    public JSONParser parser;
    public Object obj;
    public JSONObject jsonObject;
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
