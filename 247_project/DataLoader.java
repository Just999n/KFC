import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class DataLoader extends DataConstants{
    public static ArrayList<User> read(){
        try {
            ArrayList<User> users = new ArrayList<>();
            String name, firstName, lastName, email, password, type, birthday;
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(USER_FILE_NAME);
            Object obj = parser.parse(reader);
            JSONArray msg = (JSONArray)obj;

            for (Object o : msg) {
                JSONObject dataTrans = (JSONObject) o;
                name = (String)dataTrans.get(USER_USER_NAME);
                firstName = (String)dataTrans.get(USER_FIRST_NAME);
                lastName = (String)dataTrans.get(USER_LAST_NAME);
                email = (String)dataTrans.get(USER_EMAIL);
                password = (String)dataTrans.get(USER_PASSWORD);
                type = (String)dataTrans.get(USER_TYPE);
                birthday = (String)dataTrans.get(USER_BIRTHDAY);
                if(type.equals("student")){
                    users.add(new Student(name, password, firstName, lastName, email, new Date(birthday), Type.STUDENT));
                }else{
                    users.add(new Teacher(name, password, firstName, lastName, email, new Date(birthday), Type.TEACHER));
                }
                //System.out.println(o);
                //System.out.println(dataTrans.get("firstName"));
            }
            return users;
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
        return null;
    }
}
