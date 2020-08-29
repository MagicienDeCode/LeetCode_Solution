package string_integer.sort_an_array_912;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting969 {
    public List<Integer> pancakeSort(int[] nums) {
        final List<Integer> result = new LinkedList<>();
        for (int valueToSort = nums.length; valueToSort > 0; valueToSort--) {
            // locate the position for the value to sort in this round
            int index = find(nums, valueToSort);

            // sink the value_to_sort to the bottom,
            // with at most two steps of pancake flipping.
            if (index == valueToSort - 1) {
                continue;
            }
            // 1). flip the value to the head if necessary
            if (index != 0) {
                result.add(index + 1);
                reverse(nums, index);
            }
            // 2). now that the value is at the head, flip it to the bottom
            result.add(valueToSort);
            this.reverse(nums, valueToSort - 1);
        }
        return result;
    }

    private void reverse(int[] nums, int end) {
        int start = 0;
        while (start < end) {
            final int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    private int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
