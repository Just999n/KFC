/**
 * Course Class
 * @author KFC
 */
import java.util.ArrayList;

public class Course {
    private String title;
    private Languages languages;
    private ArrayList<Module> modules;
    private ArrayList<Comments> comments;

    /**
     * Constructor for the course class.
     * @param title The name of the course in string form.
     * @param languages The language that the class is about as a language object.
     * @param modules An array list of the modules included in the course.
     * @param comments An array list of the comments included for the module.
     */
    public Course(String title, Languages languages, ArrayList<Module> modules, ArrayList<Comments> comments){
        this.title = title;
        this.languages = languages;
        this.modules = modules;
        this.comments = comments;
    }

    /**
     * Accessor for the title of the course.
     * @return The title of the course in string form.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Accessor for the language of the course.
     * @return The language object of the course.
     */
    public Languages getLanguages() {
        return languages;
    }

    /**
     * Accessor for list of modules in the course.
     * @return Array list of modules.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Accesor for list of comments on the course.
     * @return Array list of comments.
     */
    public ArrayList<Comments> getComments() {
        return comments;
    }

    /**
     * Sets the title of the course.
     * @param title Title of the course in string form.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the language the course is on.
     * @param languages Language object of the course.
     */
    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    /**
     * Sets the modules included in the course.
     * @param modules Array list of modules.
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Sets the comments included on the course.
     * @param comments Array list of comments.
     */
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    /**
     * Method to print out the course.
     */
    public void print(){
        System.out.println(title);
        System.out.println(languages);
        System.out.println(comments);
        for(Module m:modules){
            m.print();
        }
    }
}
