
/*
 * -----------------------------------
 * `class` and `object`
 * `class` - class is a blueprint to create an object
 * it consists of properties behaviours/methods.
 *
 * `object` - Instances of a class representing a real-
 * world entity is known as object.
 * -----------------------------------
 *
 *
 * -----------------------------------
 * OOPs - Object Oriented Programming
 * -----------------------------------
 *  1) Polymorphism
 *  Polymorphism is a term made from `poly` and `merons`.
 *  One thing present in many forms is known as polymorphism
 *   - i) early binding (method overloading)
 *   - ii) late binding (method overriding)
 *
 *  2) Inheritance
 *  It is a way through which child/sub class can aquire
 *  behaviors and properties of parent/super class.
 *    - i) Single level - single parent class is used to
 *    inherit the properties to derive child
 *    - ii) Multi level - a class is derived using a derived
 *    class
 *    - iii) Hierarchial - multiple child classes inherting the
 *    properties and methods of a single parent creating a
 *    hierarchy
 *
 *  4) Encapsulation
 *  Binding all members into a single unit class is known as
 *  encapsulation
 *
 *  3) Abstraction
 *  Hiding the behaviors by only giving the abstract declarations
 *  is known as Abstraction. This is acheived using interfaces and
 *  abstract classes in java.
 *
 * -----------------------------------
 */

import java.util.Date;

class Student {
  private Integer studentId;
  private String name;
  private String email;
  private Date dob;

  public Student() {
  }

  public Student(Integer studentId, String name, String email, Date dob) {
    this.studentId = studentId;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "Student [ student id: " + this.studentId + ", name: " + this.name + " ]";
  }

  public void study(String subject) {
    System.out.println("Student is studying: " + subject);
  }

}

public class Main {
  public static void main(String[] args) {
    System.out.println("OOPs programming in java: ");
    System.out.println("Classes and Objects");

    Student student1 = new Student();
    student1.setStudentId(1001);
    student1.setName("John");
    student1.setEmail("john@smith.com");
    Date dob = new Date(1999, 0, 1);
    student1.setDob(dob);
    System.out.println(student1);
    student1.study("");
  }
}
