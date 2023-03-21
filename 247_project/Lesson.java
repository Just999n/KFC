public class Lesson {
  private String language;
  private int moduleNumber;
  private int lessonNumber;

  public Lesson(String language, int moduleNumber, int lessonNumber) {
    this.language = language;
    this.moduleNumber = moduleNumber;
    this.lessonNumber = lessonNumber;
  }

  public String getLanguage() {
    return language;
  }

  public int getModuleNumber() {
    return moduleNumber;
  }

  public int getLessonNumber() {
    return lessonNumber;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setModuleNumber(int moduleNumber) {
    this.moduleNumber = moduleNumber;
  }

  public void setLessonNumber(int lessonNumber) {
    this.lessonNumber = lessonNumber;
  }
  
  public void displayLesson() {
    if(this.language.equalsIgnoreCase("python")) {
      System.out.println(PythonLessons.PYTHON_LESSON_1.title);
      System.out.println();
      System.out.println(PythonLessons.PYTHON_LESSON_1.text);
    } else if (this.language.equalsIgnoreCase("javascript")) {

    } else {
      return;
    }
  }

}
