/**
 * Class to Track Course Progress
 * @author KFC
 */
import java.util.ArrayList;

public class CourseProgress {
    private Course course;
    private ArrayList<Double> grades;
    private int modulesCompleted;

    /**
     * Constructor for the course progress object.
     * @param course The course object associated with the progress.
     * @param modulesCompleted An integer number of the modules the user 
     * has completed.
     * @param grades A list of the grades the user has recieved in the 
     * course.
     */
    public CourseProgress(Course course, int modulesCompleted, 
            ArrayList<Double> grades) {
        this.course = course;
        this.grades = grades;
        this.modulesCompleted = modulesCompleted;
    }

    /**
     * Accessor for the course the progress is associated with.
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Accessor for the modules the user has completed in the course.
     * @return The integer number of modules completed.
     */
    public int getModulesCompleted() {
        return modulesCompleted;
    }

    /**
     * Accessor for the list of grades the user has recieved in the course.
     * @return An array list of doubles representing grades.
     */
    public ArrayList<Double> getGrades() {
        return grades;
    }
    
    /**
     * Sets the course associated with the progress.
     * @param course A course object.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Sets the amount of modules completed in the course.
     * @param modulesCompleted An integer value representing the amount of
     * courses completed.
     */
    public void setModulesCompleted(int modulesCompleted) {
        this.modulesCompleted = modulesCompleted;
    }

    /**
     * Sets the list of grades the user has recieved in the course.
     * @param grades An array list of doubles representing grades.
     */
    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }
}
