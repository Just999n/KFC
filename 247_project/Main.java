import java.util.Scanner;

public class Main {
  private Scanner keyboard;
  public static void main(String[] ags) {
    chooseCourse();

    System.out.println();

    Lesson l1 = new Lesson("python", 1, 1);

    l1.displayLesson();
  }

  public static void chooseCourse() {
    System.out.println();
    System.out.println("Welcome to the Language Learning System!");
    System.out.println();
    System.out.println("Pick a course to study:\n  1. Javascript\n  2. Python");
  }
}
