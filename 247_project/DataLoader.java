import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader extends DataConstants{
    private String file;
    private JSONArray msg;
    private ArrayList<String> data;
    public DataLoader(String file){
        this.file = file;
        data = new ArrayList<>();
    }
    public void read(){
        parser = new JSONParser();

        try {

            obj = parser.parse(new FileReader(file));

            jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            data.add(jsonObject.toJSONString());
            JSONObject jb = (JSONObject) jsonObject.get("Students");
            JSONArray msg = (JSONArray) jb.get("firstName");
            for (Object o : msg) {
                System.out.println(o);
            }

            /*String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            JSONObject jb = (JSONObject) jsonObject.get("json2");
            System.out.println((String) jb.get("key2"));
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<String> getData() {
        return data;
    }
}
