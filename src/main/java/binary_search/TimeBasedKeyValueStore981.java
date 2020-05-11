package binary_search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore981 {

    private final Map<String, List<Pair<String, Integer>>> timeBasedKeyValueMap;

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore981() {
        timeBasedKeyValueMap = new HashMap<>();
    }
    /*
    public void set(String key, String value, int timestamp) {
        timeBasedKeyValueMap.computeIfAbsent(key, list -> new ArrayList<>())
        .add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        final List<Pair<String, Integer>> list = timeBasedKeyValueMap.get(key);
        if (list.get(0).getValue() > timestamp) {
            return "";
        }
        for (int index = list.size() - 1; index >= 0; index--) {
            if (list.get(index).getValue() <= timestamp) {
                return list.get(index).getKey();
            }
        }
        return "";
    }
    */


    public void set(String key, String value, int timestamp) {
        timeBasedKeyValueMap.computeIfAbsent(key, list -> new ArrayList<>())
                .add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        return binarySearchGet(timeBasedKeyValueMap.get(key), timestamp);
    }



    /*
    If the timestamps for all TimeMap.set operations are !NOT! strictly increasing.
    or use TreeMap
    public void set(String key, String value, int timestamp) {
        binarySearchSet(timeBasedKeyValueMap
        .computeIfAbsent(key, list -> new ArrayList<>()), timestamp, value);
    }

    public String get(String key, int timestamp) {
        return binarySearchGet(timeBasedKeyValueMap.get(key), timestamp);
    }
     */

    private void binarySearchSet(List<Pair<String, Integer>> list, int target, String value) {
        if (list.size() == 0) {
            list.add(new Pair<>(value, target));
            return;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() == target) {
                list.add(mid + 1, new Pair<>(value, target));
                return;
            } else if (list.get(mid).getValue() < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (list.get(right).getValue() <= target) {
            list.add(right + 1, new Pair<>(value, target));
        } else if (list.get(left).getValue() <= target) {
            list.add(left + 1, new Pair<>(value, target));
        } else {
            list.add(left, new Pair<>(value, target));
        }
    }

    private String binarySearchGet(List<Pair<String, Integer>> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() == target) {
                return list.get(mid).getKey();
            } else if (list.get(mid).getValue() < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (list.get(right).getValue() <= target) {
            return list.get(right).getKey();
        }
        if (list.get(left).getValue() <= target) {
            return list.get(left).getKey();
        }
        return "";
    }

    public static void main(String... args) {
        final TimeBasedKeyValueStore981 test = new TimeBasedKeyValueStore981();
        test.set("foo", "bar", 1);
        System.out.println(test.get("foo", 1));
        System.out.println(test.get("foo", 3));
        test.set("foo", "bar2", 4);
        System.out.println(test.get("foo", 4));
        System.out.println(test.get("foo", 5));
    }
}
