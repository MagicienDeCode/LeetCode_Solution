package hash_map_set;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> valueIndexMap = new HashMap<>();
        valueIndexMap.put(nums[0], 0);
        for (int index = 1; index < nums.length; index++) {
            if (valueIndexMap.containsKey(target - nums[index])) {
                return new int[]{valueIndexMap.get(target - nums[index]), index};
            }
            valueIndexMap.put(nums[index], index);
        }
        return null;
    }
}