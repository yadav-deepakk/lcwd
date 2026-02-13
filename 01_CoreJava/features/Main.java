
/*-----------------------------------------
 * lambda expressions
 * streams api
 * time api
 * Optional Class
 * records, sealed, pattern matching
 * virtual threads
 *-----------------------------------------
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@FunctionalInterface
interface RunnableCar {
  boolean start(float fuel, boolean key);
}

// Functional Interfaces - Predicate, Consumer, BiConsumer
public class Main {

  public static void main(String[] args) {
    RunnableCar car = new RunnableCar() {
      @Override
      public boolean start(float fuel, boolean key) {
        return fuel > 0 && key;
      }
    };

    // Lambda Expressions
    RunnableCar car1 = (fuel, key) -> fuel > 0 && key;

    // Streams API
    // map, filter, reduce,
    // count, min, max, sorted
    // groupBy
    List<Integer> list1 = new ArrayList<>();
    list1.add(12);
    list1.add(51);
    list1.add(13);
    list1.add(49);
    list1.add(87);
    Set<Integer> res = list1.stream().filter(x -> x % 2 == 0).map(y -> y * 2).collect(Collectors.toSet());
    System.out.println("res: " + res);
    int sum = list1.stream().filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b);
    System.out.println("sum: " + sum);
    System.out.println("count: " + list1.stream().count());
    System.out.println("max: " + list1.stream().max(Integer::compareTo));
    System.out.println("min: " + list1.stream().min(Integer::compareTo));

    // Optional
    Optional<Integer> optionalValue = Optional.of(null);
    if (optionalValue.isPresent()) {
      System.out.println("value is non null" + optionalValue.get());
    } else {
      System.out.println("value is null");
    }

    // Method Refereces
    // 1)Static 2)Non-Static 3)Constructor

  }
}
