import java.util.Date;

class Animal {
  private Integer height;
  private Integer weight;

  public Animal() {
    System.out.println("Animal constructor is called.");
  }

  public void eat(String food) {
    System.out.println("Animal is eating " + food);
  }

  public void sleep(Integer hours) {
    System.out.println("Animal is sleeping for " + hours);
  }

}

class Human extends Animal {
  private String name;
  private String eyeColor;
  private String hairColor;
  private Date dob;

  public Human() {
    System.out.println("Human constructor is called.");
  }

  public void walk() {
    System.out.println("Humans can walk!");
  }

}

class Student extends Human {
  private Long regNumber;
  private String majorSubject;

  public Student() {
    System.out.println("Student constructor is called!");
  }

  public void study(String subject, float hour) {
    System.out.println("Student is studying " + subject + "for " + hour);
  }
}

public class Inheritance {
  public static void main(String[] args) {
    Student vimal = new Student();
    vimal.sleep(8);
  }
}
