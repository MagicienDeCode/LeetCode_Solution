package binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdvantageShuffle870 {
    public int[] advantageCount(int[] a, int[] b) {
        Arrays.sort(a);
        final List<Integer> sortedA = Arrays.stream(a).boxed().collect(Collectors.toList());
        final int[] result = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            final int index = binarySearchFirstIndexGreaterThanTarget(sortedA, b[i]);
            final int removeIndex = index == -1 ? 0 : index;
            result[i] = sortedA.get(removeIndex);
            sortedA.remove(removeIndex);
        }
        return result;
    }

    private int binarySearchFirstIndexGreaterThanTarget(List<Integer> sortedA, int target) {
        int left = 0;
        int right = sortedA.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (sortedA.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (sortedA.get(left) > target) {
            return left;
        }
        if (sortedA.get(right) > target) {
            return right;
        }
        return -1;
    }
}
