package binary_search;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarraywithSumatLeastK862 {
    public int shortestSubarray(int[] ints, int k) {
        int result = ints.length + 1;
        final int[] sums = new int[ints.length + 1];
        for (int index = 1; index < sums.length; index++) {
            sums[index] = sums[index - 1] + ints[index - 1];
        }
        final Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        for (int index = 1; index < sums.length; index++) {
            while (!deque.isEmpty() && sums[index] - sums[deque.getFirst()] >= k) {
                result = Math.min(result, index - deque.pollFirst());
            }
            while (!deque.isEmpty() && sums[index] <= sums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.offer(index);
        }
        return result == ints.length + 1 ? -1 : result;
    }
    /*
    public int shortestSubarray(int[] ints, int k) {
        int result = ints.length + 1;
        final int[] sums = new int[ints.length + 1];
        for (int index = 1; index < sums.length; index++) {
            sums[index] = sums[index - 1] + ints[index - 1];
        }
        final List<Pair<Integer, Integer>> sortedList = new ArrayList<>();
        sortedList.add(new Pair<>(0, 0));
        for (int index = 1; index < sums.length; index++) {
            final int position = findLast(sortedList, sums[index] - k);
            if (position != -1) {
                for (int p = 0; p <= position; p++) {
                    result = Math.min(result, index - sortedList.get(p).getValue());
                }
                if (position > 0) {
                    sortedList.subList(0, position).clear();
                }
            }
            sortedList.add(
                    insertPosition(sortedList, sums[index]),
                    new Pair<>(sums[index], index)
            );
        }
        return result == ints.length + 1 ? -1 : result;
    }

    // binary search last element.first <= target , return position
    private int findLast(
            List<Pair<Integer, Integer>> sortedList,
            int target
    ) {
        int left = 0;
        int right = sortedList.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (sortedList.get(mid).getKey() <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (sortedList.get(right).getKey() <= target) {
            return right;
        }
        if (sortedList.get(left).getKey() <= target) {
            return left;
        }
        return -1;
    }

    // binary search insert position
    private int insertPosition(
            List<Pair<Integer, Integer>> sortedList,
            int target
    ) {
        int left = 0;
        int right = sortedList.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (sortedList.get(mid).getKey() <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (sortedList.get(left).getKey() >= target) {
            return left;
        }
        if (sortedList.get(right).getKey() >= target) {
            return right;
        }
        return right + 1;
    }
     */
}
