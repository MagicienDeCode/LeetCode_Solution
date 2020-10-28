package list_array;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        final List<String> results = new LinkedList<>();
        if (nums.length == 0) {
            return results;
        }
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            while (end <= nums.length - 2 && nums[end] + 1 == nums[end + 1]) {
                ++end;
            }
            if (start == end) {
                results.add(nums[start] + "");
            } else {
                results.add(nums[start] + "->" + nums[end]);
            }
            start = ++end;
        }
        return results;
    }
}
