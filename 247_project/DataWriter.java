import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter extends DataConstants{
    private String file;
    private JSONArray msg;
    private ArrayList<String> data;
    public DataWriter(String file){
        this.file = file;
    }
    public void write(){
        jsonObject.put("name", "mkyong.com");
        jsonObject.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        jsonObject.put("messages", list);

        try (FileWriter file = new FileWriter("f:\\test.json")) {

            file.write(jsonObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
