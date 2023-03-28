/**
 * Class to Handle List of Courses
 * @author KFC
 */
import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;

    /**
     * Constructor to create an empty array list. This list
     * will be used to contain courses.
     */
    public CourseList(){
        courses = new ArrayList<>();
    }

    /**
     * Accessor of the list of courses.
     * @return An array list of courses.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses.
     * @param courses An array list containing the courses.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Adds a course to the list of courses.
     * @param course A course object.
     */
    public void addCourse(Course course){
        courses.add(course);
    }

    /**
     * Deletes a course from the list of courses.
     * @param course A course object.
     */
    public void delCourse(Course course){
        courses.remove(course);
    }
}
