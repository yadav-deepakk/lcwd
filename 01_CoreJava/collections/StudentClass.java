
public class StudentClass implements Comparable<StudentClass> {
  private String firstName;
  private String lastName;
  private String email;
  private float age;

  public StudentClass() {
  }

  public StudentClass(String firstName, String lastName, String email, float age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public float getAge() {
    return age;
  }

  public void setAge(float age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student[" + this.firstName + " | " + this.age + "]";
  }

  @Override
  public int compareTo(StudentClass other) {
    return (int) (this.age - other.age);
  }

}
