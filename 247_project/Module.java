/**
 * Module Class
 * @author KFC
 */

import java.util.ArrayList;

public class Module {
    private ArrayList<Lessons> lessons;
    private String name;
    private Quiz quiz;
    private ArrayList<Comments> comments;

    /**
     * Construcor of the Module class.
     * @param lessons The lesson being selected.
     * @param name The name of the module.
     * @param quiz The quiz associated with the module.
     * @param comments Comments associatec with the module.
     */
    public Module(ArrayList<Lessons> lessons, String name, Quiz quiz, ArrayList<Comments> comments){
        this.comments = comments;
        this.quiz = quiz;
        this.name = name;
        this.lessons = lessons;
    }

    /**
     * Sets the name of the method.
     * @param name The name in string form.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for the module name.
     * @return The name of the module in string form.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for the comments on the module.
     * @return A array list of comments.
     */
    public ArrayList<Comments> getComments() {
        return comments;
    }

    /**
     * Accessor for the list of lessons in the module.
     * @return An array list of lessons.
     */
    public ArrayList<Lessons> getLessons() {
        return lessons;
    }

    /**
     * Accessor for the module's quiz.
     * @return A quiz object.
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Sets the list of comments for the module.
     * @param comments The list of comments.
     */
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    /**
     * Sets the list of lessons for the module.
     * @param lessons The list of lessons.
     */
    public void setLessons(ArrayList<Lessons> lessons) {
        this.lessons = lessons;
    }

    /**
     * Sets the quiz object associated with the module.
     * @param quiz The quiz object.
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * Method used to print the module out.
     */
    public void print(){
        System.out.println(name);
        System.out.println(lessons);
        System.out.println(comments);
        ArrayList<Questions> q1 = quiz.getQuestions();
        for(Questions q:q1){
            q.print();
        }
        //System.out.println(quiz.getQuestions());
    }
}
