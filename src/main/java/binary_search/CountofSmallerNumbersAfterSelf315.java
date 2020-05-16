package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountofSmallerNumbersAfterSelf315 {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        final int[] result = new int[nums.length];
        final List<Integer> sortedList = new ArrayList<>();
        result[result.length - 1] = 0;
        sortedList.add(nums[nums.length - 1]);
        for (int index = nums.length - 2; index >= 0; index--) {
            final int insertPosition = binarySearchIndex(sortedList, nums[index]);
            result[index] = insertPosition;
            sortedList.add(insertPosition, nums[index]);
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private int binarySearchIndex(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size() - 1;
        if (sortedList.size() == 1) {
            if (target <= sortedList.get(0)) {
                return 0;
            }
            return 1;
        }
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (sortedList.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= sortedList.get(left)) {
            return left;
        }
        if (target <= sortedList.get(right)) {
            return right;
        }
        return right + 1;
    }
}
