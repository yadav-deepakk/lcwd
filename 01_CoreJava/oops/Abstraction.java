interface Animal {
  void eat();

  void walk();

  void sleep();
}

abstract class Human implements Animal {
  private String eyeColor;
  private String hairColor;
  private float height;
  private float weight;

  abstract void study();
}

class Student extends Human {

  public void printLine(String arg) {
    System.out.println(arg);
  }

  @Override
  public void eat() {
    this.printLine("Unimplemented method 'eat'");
  }

  @Override
  public void walk() {
    this.printLine("Unimplemented method 'walk'");
  }

  @Override
  public void sleep() {
    this.printLine("Unimplemented method 'sleep'");
  }

  @Override
  void study() {
    this.printLine("Unimplemented method 'study'");
  }

}

public class Abstraction {
  public static void main(String[] args) {
    Student s = new Student();
    System.out.println();
  }
}
