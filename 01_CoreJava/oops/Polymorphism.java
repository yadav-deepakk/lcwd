
// Early binding and Late binding
// 1. Method Overloading
class Mathematics {
  public long addition(int a, int b) {
    return a + b;
  }

  public long addition(int a, int b, int c) {
    return a + b + c;
  }

  public long addition(int... arr) {
    long sum = 0;
    for (int n : arr) {
      sum = sum + n;
    }
    return sum;
  }

}

// 2. Method Overriding
class Vehical {
  private String brandName;

  public void start() {
    System.out.println("Vehical is starting!");
  }

  @Override
  public String toString() {
    return "Vehical [brandName=" + brandName + "]";
  }
}

class Scooter extends Vehical {
  @Override
  public void start() {
    System.out.println("Scooter is starting with a key and kickstart");
  }

}

public class Polymorphism {
  public static void main(String[] args) {

    Mathematics m = new Mathematics();
    long sum1 = m.addition(new int[] { 1, 5, 12, 3 });
    long sum2 = m.addition(1, 2, 6);
    long sum3 = m.addition(55, 11);
    System.out.println("sum1: " + sum1 + "\nsum2: " + sum2 + "\nsum3: " + sum3);

    Scooter v = new Scooter();
    v.start();

  }
}
