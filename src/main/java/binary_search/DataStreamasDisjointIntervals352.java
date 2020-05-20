package binary_search;

import java.util.ArrayList;
import java.util.List;

public class DataStreamasDisjointIntervals352 {

    private final List<int[]> intervals;

    public DataStreamasDisjointIntervals352() {
        intervals = new ArrayList<>();
    }

    public void addNum(final int val) {
        switch (intervals.size()) {
            case 0: {
                intervals.add(new int[]{val, val});
                break;
            }
            case 1: {
                final int[] first = intervals.get(0);
                if (val + 1 < first[0]) {
                    intervals.add(0, new int[]{val, val});
                } else if (val + 1 == first[0]) {
                    first[0] = val;
                } else if (first[1] + 1 == val) {
                    first[1] = val;
                } else if (first[1] + 1 < val) {
                    intervals.add(1, new int[]{val, val});
                }
                break;
            }
            default: {
                final int targetPosition = binarySearchLastPositionLessThan(intervals, val);
                if (targetPosition == 0 && val < intervals.get(0)[0]) {
                    if (val + 1 < intervals.get(0)[0]) {
                        intervals.add(0, new int[]{val, val});
                    }
                    if (val + 1 == intervals.get(0)[0]) {
                        intervals.get(0)[0] = val;
                    }
                } else if (targetPosition == intervals.size() - 1) {
                    if (intervals.get(intervals.size() - 1)[1] + 1 == val) {
                        intervals.get(intervals.size() - 1)[1] = val;
                    }
                    if (intervals.get(intervals.size() - 1)[1] + 1 < val) {
                        intervals.add(intervals.size(), new int[]{val, val});
                    }
                } else {
                    final int[] current = intervals.get(targetPosition);
                    final int[] next = intervals.get(targetPosition + 1);
                    if (val - 1 > current[1] && val + 1 < next[0]) {
                        intervals.add(targetPosition + 1, new int[]{val, val});
                    } else if (val - 1 == current[1] && val + 1 < next[0]) {
                        current[1] = val;
                    } else if (val - 1 > current[1] && val + 1 == next[0]) {
                        next[0] = val;
                    } else if (val - 1 == current[1] && val + 1 == next[0]) {
                        current[1] = next[1];
                        intervals.remove(targetPosition + 1);
                    }
                }
            }
        }
    }

    public int[][] getIntervals() {
        final int[][] result = new int[intervals.size()][];
        int index = 0;
        for (int[] ints : intervals) {
            result[index++] = ints;
        }
        return result;
    }

    private int binarySearchLastPositionLessThan(List<int[]> intervals, int target) {
        int left = 0;
        int right = intervals.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (intervals.get(mid)[0] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (intervals.get(right)[0] <= target) {
            return right;
        }
        return left;
    }

    /*
    private final TreeMap<Integer, Integer> intervalsTreeMap;
    public DataStreamasDisjointIntervals352() {
        intervalsTreeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        int key = val;
        int value = val;
        final Map.Entry<Integer, Integer> leftEntry = intervalsTreeMap.floorEntry(val);
        if (leftEntry != null) {
            if (leftEntry.getValue() >= val) {
                return;
            }
            if (leftEntry.getValue() + 1 == val) {
                key = leftEntry.getKey();
                intervalsTreeMap.remove(leftEntry.getKey());
            }
        }
        final Map.Entry<Integer, Integer> rightEntry = intervalsTreeMap.ceilingEntry(val);
        if (rightEntry != null && rightEntry.getKey() - 1 == val) {
            value = rightEntry.getValue();
            intervalsTreeMap.remove(rightEntry.getKey());
        }
        intervalsTreeMap.put(key, value);
    }

    public int[][] getIntervals() {
        final int[][] result = new int[intervalsTreeMap.size()][];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervalsTreeMap.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return result;
    }
    */
}
