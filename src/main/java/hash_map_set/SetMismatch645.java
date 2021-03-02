package hash_map_set;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch645 {
    public int[] findErrorNums(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int twice = 0;
        int missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    twice = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{twice, missing};
    }
}
