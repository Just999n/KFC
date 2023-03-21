public enum PythonLessons {
  PYTHON_LESSON_1("Lesson 1", "This is the first lesson.", 1),
  PYTHON_LESSON_2("Lesson 2", "This is the second lesson.", 2),
  PYTHON_LESSON_3("Lesson 3","This is the third lesson.", 3);

  final String title;
  final String text;
  final int lessonNumber;

  PythonLessons(String title, String text, int lessonNumber) {
    this.title = title;
    this.text = text;
    this.lessonNumber = lessonNumber;
  }
}
