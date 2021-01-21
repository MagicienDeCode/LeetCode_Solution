package list_array;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs1679 {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(k - i)) {
                if (map.get(k - i) > 0) {
                    map.put(k - i, map.get(k - i) - 1);
                    ++result;
                }
            } else {
                map.put(i, 1 + map.getOrDefault(i, 0));
            }
        }
        return result;
    }
}
