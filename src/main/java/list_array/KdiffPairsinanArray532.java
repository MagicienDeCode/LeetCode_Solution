package list_array;

import java.util.HashMap;

public class KdiffPairsinanArray532 {
    /*
    0 <= i, j < nums.length
    i != j
    a <= b
    b - a == k
     */
    public int findPairs(int[] nums, int k) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int result = 0;
        if (k == 0) {
            for (int n : map.values()) {
                result += n > 1 ? 1 : 0;
            }
        } else {
            for (int n : map.keySet()) {
                if (map.containsKey(n + k)) {
                    ++result;
                }
            }
        }
        return result;
    }
}
