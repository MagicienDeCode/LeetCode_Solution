package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences967 {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int level = 1; level < n; ++level) {
            final List<Integer> nextLevel = new ArrayList<>();
            for (Integer i : queue) {
                final int remainder = i % 10;
                final int next = remainder + k;
                final int previous = remainder - k;
                final int newBase = i * 10;
                if (next <= 9) {
                    nextLevel.add(newBase + next);
                }
                if (previous >= 0 && previous != next) {
                    nextLevel.add(newBase + previous);
                }
            }
            queue = nextLevel;
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
    /*
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        final List<Integer> results = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, i, k, results);
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int n, int i, int k, List<Integer> results) {
        if (n == 0) {
            results.add(i);
            return;
        }
        final int remainder = i % 10;
        final int next = remainder + k;
        final int previous = remainder - k;
        final int newBase = i * 10;
        if (next <= 9) {
            dfs(n - 1, newBase + next, k, results);
        }
        if (previous >= 0 && previous != next) {
            dfs(n - 1, newBase + previous, k, results);
        }
    }
     */
}
