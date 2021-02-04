package hash_map_set;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence594 {
    public int findLHS(int[] nums) {
        int result = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, 1 + map.getOrDefault(n, 0));
            if (map.containsKey(n + 1)) {
                result = Math.max(result, map.get(n) + map.get(n + 1));
            }
            if (map.containsKey(n - 1)) {
                result = Math.max(result, map.get(n) + map.get(n - 1));
            }
        }
        return result;
    }
}
