
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
import java.util.HashSet;
import java.util.List;
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

    Set<Integer> set1 = new HashSet<>();
    set1.add(23);
    set1.add(94);
    set1.add(24);
    set1.add(59);
    set1.add(36);
    System.out.println("set1: " + set1);

  }

}
