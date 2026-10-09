
/*
 *                              (iterables)
 *                                  |
 *                                  |
 *                              (collection)
 *                                  |
 *                                  |
 *   (List)               (Queue)              (Set)
 *      [ArrayList]         [PriorityQueue]      [HashSet]
 *      [LinkedList]      (Deque)                [LinkedHashSet]
 *      [Vector]            [ArrayDeque]       (SortedSet)
 *        [Stack]                                 [TreeSet]
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(12);
    list.add(19);
    list.addFirst(32);
    list.addLast(51);
    list.add(1, 51);
    list.remove(1);
    System.out.println(list);

    Stack<Integer> stack = new Stack<>();
    stack.push(87);
    stack.push(32);
    stack.push(90);
    stack.push(46);
    int top = stack.peek();
    System.out.println("top: " + top);
    System.out.println("stack: " + stack);

    Queue<Integer> queue = new PriorityQueue<>();
    queue.offer(11);
    queue.offer(45);
    queue.offer(23);
    queue.offer(83);
    int peek = queue.peek();
    int poll = queue.poll();
    System.out.println("peek: " + peek);
    System.out.println("poll: " + poll);
    System.out.println("queue: " + queue);

    Set<Integer> set = new HashSet<>();
    set.add(23);
    set.add(94);
    set.add(24);
    set.add(59);
    set.add(36);
    System.out.println("set1: " + set);

    // traversing through iterator, listIterator, foreach, forEach streams
    // iterator
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();

    // listIterator
    ListIterator<Integer> listIterator = list.listIterator(list.size());
    while (listIterator.hasPrevious()) {
      System.out.print(listIterator.previous() + " ");
    }
    System.out.println();

    // foreach loop
    for (int num : set) {
      System.out.print(num + " ");
    }
    System.out.println();

    // forEach(element -> { //code })
    list.forEach(num -> System.out.print(num + " "));

    // comparable and comparators in java
    List<StudentClass> studentList = new ArrayList<>();
    studentList.add(new StudentClass("John", "Smith", "john@email.com", 22.7f));
    studentList.add(new StudentClass("Cameron", "White", "cameronwhite@email.com", 52.1f));
    studentList.add(new StudentClass("james", "anderson", "anderson@email.com", 42.2f));
    studentList.add(new StudentClass("Ali", "Mohammed", "mohammed@email.com", 32.6f));
    studentList.add(new StudentClass("Alisa", "Janardan", "alisa@email.com", 32.6f));

    System.out.println();
    System.out.println("student list before sorting: " + studentList);
    Collections.sort(studentList);
    System.out.println("student list after sorting: " + studentList);

  }

}
