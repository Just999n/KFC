/**
 * Lessons Class
 * @author KFC
 */
public class Lessons {
    private String name;
    private String lessonContent;

    /**
     * Constructor of the Lessons class.
     * @param name The name of the lesson.
     * @param lessonContent What the lessons contains.
     */
    public Lessons(String name, String lessonContent){
        this.lessonContent = lessonContent;
        this.name = name;
    }

    /**
     * Accessor for the lesson name.
     * @return Lesson name in string form.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for the content of the lesson.
     * @return Lesson content in string form.
     */
    public String getLessonContent() {
        return lessonContent;
    }

    /**
     * Sets the name of the lesson.
     * @param name The name of the lesson in string form.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the content associated with the lesson.
     * @param lessonContent Lesson content in string form.
     */
    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }
}
