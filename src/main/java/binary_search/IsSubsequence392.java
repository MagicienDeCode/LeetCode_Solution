package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        final Map<Character, List<Integer>> tmap = new HashMap<>();
        for (int index = 0; index < t.length(); index++) {
            tmap.computeIfAbsent(t.charAt(index), value -> new ArrayList<>()).add(index);
        }
        int indexOft = 0;
        for (int index = 0; index < s.length(); index++) {
            indexOft = binarySearch(tmap.get(s.charAt(index)), indexOft);
            if (indexOft++ == -1) {
                return false;
            }
        }
        return true;
    }

    public int binarySearch(List<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums.get(left) >= target) {
            return nums.get(left);
        }
        if (nums.get(right) >= target) {
            return nums.get(right);
        }
        return -1;
    }
}
