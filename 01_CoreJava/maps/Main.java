
/*
 *                    (Map)
 *
 *                                          (SortedMap)
 *
 *   [Hashtable]      [HashMap]             (NavigableMap)
 *
 *                    [LinkedHashMap]       [TreeMap]
 *
 * -------------------
 * */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {

    // Hashtable
    Map<String, String> hashtable = new Hashtable<>();
    hashtable.put("1101", "Ramesh");
    hashtable.put("1102", "Suresh");
    hashtable.put("1104", "Rajesh");
    hashtable.put("1105", "Dinesh");
    hashtable.put("1106", "Vishesh");
    hashtable.put("1107", "Dinesh");
    System.out.println("Value of 1105: " + hashtable.get("1105"));
    System.out.println("Replacing 1105" + hashtable.replace("1105", "David"));
    System.out.println("Keyset: " + hashtable.keySet());
    System.out.println("Values: " + hashtable.values());
    System.out.println("Hashtable: " + hashtable);

    // HashMap
    Map<String, String> mangoMap = new HashMap<>();
    mangoMap.put("101", "Alphanso");
    mangoMap.put("102", "Totapuri");
    mangoMap.put("103", "Kesar");
    mangoMap.put("104", "Langda");
    mangoMap.put("105", "Hapush");
    mangoMap.put("106", "Dashahari");
    System.out.println("HashMap: " + mangoMap);

    // TreeMap
    Map<String, String> featureMap = new TreeMap<>();
    featureMap.put("F1101", "Password Login");
    featureMap.put("F1102", "OAuth Login");
    featureMap.put("F1103", "Login with phone number");
    featureMap.put("F1104", "Reset Password");
    System.out.println("\n---------- Feature Map ------------");
    featureMap.forEach((key, value) -> System.out.println(key + " :: " + value));
    System.out.println();

  }
}
