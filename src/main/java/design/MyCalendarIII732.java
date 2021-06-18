package design;

import java.util.TreeMap;

public class MyCalendarIII732 {

    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public int book(int start, int end) {
        map.put(start, 1 + map.getOrDefault(start, 0));
        map.put(end, -1 + map.getOrDefault(end, 0));
        int max = 0;
        int count = 0;
        for (int v : map.values()) {
            count += v;
            max = Math.max(max, count);
        }
        return max;
    }
}
