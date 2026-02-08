/*
 * --------------------------------------------------
 *            Exception Handling
 * --------------------------------------------------
 *  Any unexpected or unwanted event that occurs during the program execution is
 *  known as exception and in java there are two kind of exceptions checked and
 *  unchecked exceptions
 * --------------------------------------------------
 */

public class Main {
  public static void exceptionHandling() {
    // devide by zero exception
    try {
      int num1 = 0;
      int num2 = 12;
      int res = num2 / num1;
      System.out.println("num2/num1 = " + res);
    } catch (Exception e) {
      System.out.println("exception occured: " + e.getMessage());
      e.printStackTrace();
    }

    // array index out of bounds exception
    try {
      int[] arr = new int[] { 12, 21, 33 };
      System.out.println("array 4th element: " + arr[3]);
    } catch (Exception e) {
      System.out.println("exception occured: " + e.getMessage());
      e.printStackTrace();
    }

  }

  public static void checkValidAge(int age) {

    if (age <= 0) {
      throw new IllegalArgumentException("Age is invalid");
    }

  }

  public static void main(String[] args) {

    System.out.println("----- Exception handling -----");
    exceptionHandling();
    checkValidAge(-12);
    System.out.println("------------------------------");

  }

}
