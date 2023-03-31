package src;
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
    public static void write(ArrayList<Student> students, ArrayList<Teacher> teachers){
        JSONArray array = new JSONArray();
        for(Student u:students){
            JSONObject uOne = new JSONObject();
            uOne.put(USER_USER_NAME,u.getUserName());
            uOne.put(USER_FIRST_NAME,u.getFirstName());
            uOne.put(USER_LAST_NAME,u.getLastName());
            uOne.put(USER_EMAIL,u.getEmail());
            uOne.put(USER_PASSWORD,u.getPassword());
            uOne.put(USER_TYPE,u.getType().name().toLowerCase());
            uOne.put(USER_BIRTHDAY,u.getBirthdate().toString());
            ArrayList<CourseProgress> scp = u.getCourseProgresses();
            JSONArray saveSCP = new JSONArray();
            for(CourseProgress scp1:scp){
                JSONObject scpOne = new JSONObject();
                scpOne.put("courseTitle", scp1.getCourse().getTitle());
                scpOne.put("grades", scp1.getGrades());
                scpOne.put("modulesConpleted", scp1.getModulesCompleted());
                saveSCP.add(scpOne);
            }
            uOne.put("CourseProgress", saveSCP);
            array.add(uOne);
        }
        for(Teacher u:teachers){
            JSONObject uOne = new JSONObject();
            uOne.put(USER_USER_NAME,u.getUserName());
            uOne.put(USER_FIRST_NAME,u.getFirstName());
            uOne.put(USER_LAST_NAME,u.getLastName());
            uOne.put(USER_EMAIL,u.getEmail());
            uOne.put(USER_PASSWORD,u.getPassword());
            uOne.put(USER_TYPE,u.getType().name().toLowerCase());
            uOne.put(USER_BIRTHDAY,u.getBirthdate().toString());
            array.add(uOne);
        }
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

            file.write(array.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*jsonObject.put("name", "mkyong.com");
        jsonObject.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        jsonObject.put("messages", list);


*/
        //System.out.print(obj);
    }
    public static void writeCourses(ArrayList<Course> courses){
        JSONArray array = new JSONArray();
        for(Course c:courses){
            JSONObject saveData = new JSONObject();
            c.writeToJson(saveData);
            array.add(saveData);
        }
        try (FileWriter file = new FileWriter("src/course.json")) {

            file.write(array.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
