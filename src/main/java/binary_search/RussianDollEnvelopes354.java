package binary_search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RussianDollEnvelopes354 {
    public int maxEnvelopes(int[][] envelopes) {
        final List<Pair<Integer, Integer>> envelopeList = new ArrayList<>();
        for (int[] envelope : envelopes) {
            envelopeList.add(new Pair<>(envelope[0], envelope[1]));
        }
        envelopeList.sort((p1, p2) -> {
            if (p1.getKey().equals(p2.getKey())) {
                return Integer.compare(p2.getValue(), p1.getValue());
            }
            return Integer.compare(p1.getKey(), p2.getKey());
        });
        final List<Integer> hListSortByWThenSortByDescendingH =
                envelopeList.stream().map(Pair::getValue).collect(Collectors.toList());
        return lengthOfLIS(hListSortByWThenSortByDescendingH);
    }

    private int lengthOfLIS(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        final List<Integer> result = new ArrayList<>();
        result.add(nums.get(0));
        for (int index = 1; index < nums.size(); index++) {
            final int firstIndex
                    = binarySearchFirstPositionGreaterEqualThanTarget(result, nums.get(index));
            if (firstIndex != -1) {
                result.remove(firstIndex);
                result.add(firstIndex, nums.get(index));
            } else {
                result.add(nums.get(index));
            }
        }
        return result.size();
    }

    private int binarySearchFirstPositionGreaterEqualThanTarget(List<Integer> result, int target) {
        int left = 0;
        int right = result.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (result.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (result.get(left) >= target) {
            return left;
        }
        if (result.get(right) >= target) {
            return right;
        }
        return -1;
    }
}
