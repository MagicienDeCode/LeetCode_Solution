package binary_search;

import java.util.*;

public class OnlineMajorityElementInSubarray1157 {

    private final int[] arr;
    private final Map<Integer, List<Integer>> map;
    private final Random random;

    public OnlineMajorityElementInSubarray1157(int[] arr) {
        this.arr = arr;
        map = new HashMap<>();
        random = new Random();
        for (int index = 0; index < arr.length; index++) {
            map.computeIfAbsent(arr[index], v -> new ArrayList<>()).add(index);
        }
    }

    public int query(int left, int right, int threshold) {
        final int distance = right - left + 1;
        for (int time = 1; time <= 7; time++) {
            final int r = arr[random.nextInt(distance) + left];
            final List<Integer> list = map.get(r);
            final int leftIndex = firstGreaterEqualThanTarget(list, left);
            final int rightIndex = lastLessEqualThanTarget(list, right);
            if (rightIndex - leftIndex + 1 >= threshold) {
                return r;
            }
        }
        return -1;
    }

    private int firstGreaterEqualThanTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (list.get(left) >= target) {
            return left;
        }
        if (list.get(right) >= target) {
            return right;
        }
        return -1;
    }

    private int lastLessEqualThanTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (list.get(right) <= target) {
            return right;
        }
        if (list.get(left) <= target) {
            return left;
        }
        return -1;
    }

    /*
    // Boyer–Moore majority vote algorithm
    // Time Limit Exceeded
    private final int[] arr;

    public OnlineMajorityElementInSubarray1157(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int major = -1;
        int count = 0;
        for (int index = left; index <= right; index++) {
            if (count == 0) {
                major = arr[index];
                ++count;
            } else {
                count += arr[index] == major ? 1 : -1;
            }
        }
        count = 0;
        for (int index = left; index <= right; index++) {
            if (arr[index] == major) {
                ++count;
            }
        }
        return count >= threshold ? major : -1;
    }
     */
}
