public enum JavascriptLessons {
  JAVASCRIPT_LESSON_1("Lesson 1", "This is the first lesson.", 0),
  JAVASCRIPT_LESSON_2("Lesson 2", "This is the second lesson.", 1),
  JAVASCRIPT_LESSON_3("Lesson 3","This is the third lesson.", 2);

  final String title;
  final String text;
  final int lessonNumber;

  JavascriptLessons(String title, String text, int lessonNumber) {
    this.title = title;
    this.text = text;
    this.lessonNumber = lessonNumber;
  }
}
