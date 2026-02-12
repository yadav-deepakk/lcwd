
/* -------------------------------------
 *  String are of two types in java
 * -------------------------------------
 *
 * (I) Mutable String
 *    (i) StringBuffer -
 *    (ii) StringBuilder -
 *
 *
 * (II) Immutable String
 *   eg.  String str1 = new String("This is a string1");
 *        String str2 = "This is a string2";
 *
 **/

public class Main {

  public static void mutableStrings() {
    // string buffer
    StringBuffer strbuffer = new StringBuffer();

    // string builder
    StringBuilder strbuilder = new StringBuilder();
  }

  public static void stringMethods() {

    // Immutable
    String str1 = new String("This is a string1");
    String str2 = "This is a string1";
    String str3 = str2;
    String str4 = "   this ";

    // length
    System.out.println("string length: " + str1.length());

    // trim
    System.out.println("after removing spaces from str4 = \"    this  \" the trimmed statement" + str4.trim());

    // startsWith and endsWith
    str4.startsWith(" "); // true
    str4.endsWith(" "); // true
    System.out.println("str4 starts with a space: " + str4.startsWith(" "));
    System.out.println("str4 ends with a space: " + str4.endsWith(" "));

    // character related method.
    str1.charAt(6);
    str1.indexOf('i');
    str1.lastIndexOf('i');
    System.out.println("str1 = " + str1);
    System.out.println("str1: character present at index at 6 is: " + str1.charAt(6));
    System.out.println("str1: first occurance of `i` is: " + str1.indexOf('i'));
    System.out.println("str1: last occurance of `i` is: " + str1.lastIndexOf('i'));

    // toUpperCase and toLowerCase
    str1.toUpperCase();
    str1.toLowerCase();
    System.out.println("str1: UpperCase is: ");
    System.out.println("str1: LowerCases is: ");

    // comparision
    str1.equals(str3);
    str1.equalsIgnoreCase(str3);
    str1.compareTo(str2);
    str1.compareToIgnoreCase(str3);

    // contains
    str1.contains("is");

    // substring
    str2.substring(5, 9);

    // replace
    str3.replace("java", "java, python");

    // split
    String[] str0 = str1.split(" ");
    for (String string : str0) {
      System.out.print(" " + string);
    }

    // concat
    String string1 = str1.concat(str4);
    System.out.println("string1 after concatenation: " + string1);

  }

  public static void main(String[] args) {

    stringMethods();

  }
}
