package string_integer;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray525 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        final Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, -1);
        for (int index = 0; index < nums.length; index++) {
            sum += 2 * nums[index] - 1;
            if (dpMap.containsKey(sum)) {
                max = Math.max(max, index - dpMap.get(sum));
            } else {
                dpMap.put(sum, index);
            }
        }
        return max;
    }
}
