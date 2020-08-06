package string_integer;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesinanArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        final List<Integer> results = new LinkedList<>();
        for (int num : nums) {
            final int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                results.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return results;
    }
}
