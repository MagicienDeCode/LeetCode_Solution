package design;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendarI729 {
     /*
         final TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(10);
        System.out.println("lower: " + treeSet.lower(5));
        System.out.println("floor: " + treeSet.floor(5));
        System.out.println("ceiling: " + treeSet.ceiling(5));
        System.out.println("higher: " + treeSet.higher(5));
        lower: 1
        floor: 5
        ceiling: 5
        higher: 10
     */
    final TreeSet<int[]> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));

    public boolean book(int start, int end) {
        final int[] current = new int[]{start, end};
        final int[] lower = treeSet.floor(current);
        final int[] higher = treeSet.ceiling(current);
        if ((lower == null || current[0] >= lower[1]) && (higher == null || current[1] <= higher[0])) {
            treeSet.add(current);
            return true;
        } else {
            return false;
        }
    }

    /*
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public boolean book(int start, int end) {
        final Integer previous = treeMap.floorKey(start);
        final Integer next = treeMap.ceilingKey(start);
        if ((previous == null || start >= treeMap.get(previous)) && (next == null || end <= next)) {
            treeMap.put(start, end);
            return true;
        } else {
            return false;
        }
    }
     */
}
