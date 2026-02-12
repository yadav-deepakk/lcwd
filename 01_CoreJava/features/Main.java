/*-----------------------------------------
 * lambda expressions
 * streams api
 * time api
 * Optional Class
 * records, sealed, pattern matching
 * virtual threads
 *-----------------------------------------
 **/

@FunctionalInterface
interface Car {
  boolean start(float fuel, boolean key);
}

// Functional Interfaces - Predicate, Consumer, BiConsumer
public class Main {

  public static void main(String[] args) {

    Car car = new Car() {
      @Override
      public boolean start(float fuel, boolean key) {
        return fuel > 0 && key;
      }
    };

    // lambda expressions
    Car car1 = (fuel, key) -> fuel > 0 && key;

  }
}
