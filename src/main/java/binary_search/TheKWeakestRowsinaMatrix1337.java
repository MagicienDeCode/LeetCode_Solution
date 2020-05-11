package binary_search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TheKWeakestRowsinaMatrix1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        final List<Pair<Integer, Integer>> resultList = new ArrayList<>();
        for (int index = 0; index < mat.length; index++) {
            resultList.add(new Pair<>(index, search(mat[index])));
        }
        resultList.sort(Comparator.comparingInt(Pair::getValue));
        return resultList.subList(0, k).stream()
                .mapToInt(Pair::getKey)
                .toArray();
    }

    private int search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == 1) {
            return right + 1;
        }
        if (nums[left] == 1) {
            return right;
        }
        return 0;
    }
}
