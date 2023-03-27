import java.util.ArrayList;

public class Course {
    private String title;
    private Languages languages;
    private ArrayList<Module> modules;
    private ArrayList<Comments> comments;
    public Course(String title, Languages languages, ArrayList<Module> modules, ArrayList<Comments> comments){
        this.title = title;
        this.languages = languages;
        this.modules = modules;
        this.comments = comments;
    }
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }
    public ArrayList<Comments> getComments() {
        return comments;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Module> getModules() {
        return modules;
    }
    public Languages getLanguages() {
        return languages;
    }
    public void setLanguages(Languages languages) {
        this.languages = languages;
    }
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void print(){
        System.out.println(title);
        System.out.println(languages);
        System.out.println(comments);
        for(Module m:modules){
            m.print();
        }
    }
}
