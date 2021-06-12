package easy_easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, 1 + map.getOrDefault(a, 0));
        }
        final Set<Integer> set = new HashSet<>();
        for (int v : map.values()) {
            if (set.contains(v)) {
                return false;
            }
            set.add(v);
        }
        return true;
    }
}
