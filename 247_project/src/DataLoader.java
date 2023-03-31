package src;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
                    Student newStudent = new Student(name, Type.STUDENT, firstName, lastName, email, password, new Date(birthday));
                    JSONArray cp = (JSONArray) dataTrans.get("CourseProgress");
                    ArrayList<CourseProgress> newCP = new ArrayList<>();
                    for(Object cp1:cp){
                        JSONObject jsonObject1 = (JSONObject) cp1;
                        JSONArray grades = (JSONArray) jsonObject1.get("grades");
                        //System.out.println("jsonarray: "+grades);
                        ArrayList<Double> newGrades = new ArrayList<>(grades);
                        //System.out.println("array: "+newGrades);
                        newCP.add(new CourseProgress(null, newGrades, Integer.parseInt(jsonObject1.get("modulesConpleted").toString())));
                    }
                    newStudent.setCourseProgresses(newCP);
                    users.add(newStudent);
                }else{
                    users.add(new Teacher(name, Type.TEACHER, firstName, lastName, email, password, new Date(birthday)));
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
    public static ArrayList<Course> readGetCourse(){
        try{
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/course.json");
            Object obj = parser.parse(reader);
            JSONArray msg = (JSONArray)obj;
            ArrayList<Course> newCourse = new ArrayList<>();
            for(Object o:msg){
                JSONObject dataTrans = (JSONObject) o;
                String title = (String) dataTrans.get("title");
                String language = (String) dataTrans.get("languages");
                Language languageResult;
                if(language.equals(Language.JAVASCRIPT.name().toLowerCase())){
                    languageResult = Language.JAVASCRIPT;
                }else{
                    languageResult = Language.PYTHON;
                }
                ArrayList<Module> newModules = new ArrayList<>();
                JSONArray modules = (JSONArray) dataTrans.get("modules");
                for(Object m:modules){
                    JSONObject module = (JSONObject) m;
                    JSONArray lessons = (JSONArray) module.get("lessons");
                    ArrayList<Lesson> newLessons = new ArrayList<>();
                    for(Object l:lessons){
                        JSONObject lesson = (JSONObject) l;
                        String lessonName = (String) lesson.get("name");
                        String lessonContent = (String) lesson.get("lessonContent");
                        Lesson newLesson = new Lesson(lessonName, lessonContent);
                        newLessons.add(newLesson);
                    }
                    String moduleName = (String) module.get("name");
                    JSONObject quiz = (JSONObject) module.get("quiz");
                    JSONArray questions = (JSONArray) quiz.get("questions");
                    ArrayList<Question> newQuestions = new ArrayList<>();
                    for(Object q:questions){
                        JSONObject question = (JSONObject) q;
                        String questionContent = (String) question.get("question");
                        int correctAnswer = Integer.parseInt(question.get("correctAnswer").toString());
                        ArrayList<String> newOptions = new ArrayList<>();
                        JSONArray options = (JSONArray) question.get("options");
                        for(Object op:options){
                            newOptions.add((String) op);
                        }
                        Question newQuestion = new Question(questionContent, correctAnswer, newOptions);
                        newQuestions.add(newQuestion);
                    }
                    Quiz newQuiz = new Quiz(newQuestions);
                    //暂定
                    JSONArray comments = (JSONArray) module.get("comments");
                    ArrayList<Comment> newComments = new ArrayList<>();
                    for(Object c:comments){
                        JSONObject comment = (JSONObject) c;
                        ArrayList<Comment> newReplies = new ArrayList<>();
                        JSONArray replies = (JSONArray) comment.get("replies");
                        for(Object r:replies){
                            JSONObject repliesComment = (JSONObject) r;
                            newReplies.add(readGetComments(repliesComment, null));
                        }
                        newComments.add(readGetComments(comment, newReplies));
                    }
                    newModules.add(new Module(moduleName, newLessons, newQuiz, newComments));
                }
                JSONArray courseComments = (JSONArray) dataTrans.get("comments");
                ArrayList<Comment> newCourseComments = new ArrayList<>();
                for(Object cc:courseComments){
                    JSONObject courseComment = (JSONObject) cc;
                    ArrayList<Comment> courseNewReplies = new ArrayList<>();
                    JSONArray courseReplies = (JSONArray) courseComment.get("replies");
                    for(Object cr:courseReplies){
                        JSONObject courseRepliesComment = (JSONObject) cr;
                        courseNewReplies.add(readGetComments(courseRepliesComment, null));
                    }
                    newCourseComments.add(readGetComments(courseComment, courseNewReplies));
                }
                newCourse.add(new Course(title, languageResult, newModules, newCourseComments));
            }
            return newCourse;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Comment readGetComments(JSONObject comment, ArrayList<Comment> replies){
        String commentContent = (String) comment.get("comment");
        JSONObject author = (JSONObject) comment.get("author");
        Date birthday = new Date(author.get("birthday").toString());
        String firstName = (String) author.get("firstName");
        String lastName = (String) author.get("lastName");
        String password = (String) author.get("password");
        String userName = (String) author.get("userName");
        String type = (String) author.get("type");
        Type typeResult;
        if(type.equals(Type.STUDENT.name().toLowerCase())){
            typeResult = Type.STUDENT;
        }else{
            typeResult = Type.TEACHER;
        }
        String email = (String) author.get("email");
        User newAuthor = new User(userName,typeResult,firstName,lastName,email,password,birthday);
        return new Comment(commentContent, newAuthor, replies);
    }
}
