package design;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs677 {
    private final Map<String, Integer> map = new HashMap<>();
    private final Map<String, Integer> prefixMap = new HashMap<>();

    public void insert(String key, int val) {
        final int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String s = "";
        for (char c : key.toCharArray()) {
            s += c;
            prefixMap.put(s, delta + prefixMap.getOrDefault(s, 0));
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
}
