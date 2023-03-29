import org.json.simple.JSONObject;

public class Lessons {
    private String name;
    private String lessonContent;
    public Lessons(String name, String lessonContent){
        this.lessonContent = lessonContent;
        this.name = name;
    }
    public void writeToJson(JSONObject save){
        save.put("name", name);
        save.put("lessonContent", lessonContent);
    }

    public String getName() {
        return name;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void print(){
        System.out.println(name);
        System.out.println(lessonContent);
    }
}
