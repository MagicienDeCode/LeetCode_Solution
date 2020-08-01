package top_interview_easy.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                final int old = map.get(nums[index]);
                if (index - old <= k) {
                    return true;
                }
            }
            map.put(nums[index], index);
        }
        return false;
    }
}
