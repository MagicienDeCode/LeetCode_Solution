package bit_operation;

import java.util.*;

public class CreateSortedArraythroughInstructions1649 {

    private static final int MODULO = 1000000007;
    private final int total = 100001;
    private int[] bit;

    public int createSortedArray(int[] instructions) {
        if (instructions.length <= 2) {
            return 0;
        }
        long cost = 0;
        bit = new int[total];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < instructions.length; i++) {
            final int current = instructions[i];
            final int strictlyLess = strictlyLess(current - 1);
            final int strictlyGreater = map.containsKey(current) ? i - strictlyLess - map.get(current) : i - strictlyLess;
            cost += Math.min(strictlyGreater, strictlyLess);
            map.put(current, 1 + map.getOrDefault(current, 0));
            add(current);
        }
        return (int) (cost % MODULO);
    }

    private void add(int index) {
        while (index < total) {
            bit[index] += 1;
            index += index & -index;
        }
    }

    private int strictlyLess(int index) {
        int result = 0;
        while (index > 0) {
            result += bit[index];
            index -= index & -index;
        }
        return result;
    }

    /* 65 / 65 test cases passed, but took too long.
    Status: Time Limit Exceeded
    private static final int MODULO = 1000000007;

    public int createSortedArray(int[] instructions) {
        if (instructions.length <= 2) {
            return 0;
        }
        final List<Integer> list = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();
        list.add(instructions[0]);
        map.put(instructions[0], 1);
        int cost = 0;
        int previousCost = 0;
        int lastInsertPosition = 0;
        for (int i = 1; i < instructions.length; i++) {
            final int current = instructions[i];
            if (current == instructions[i - 1]) {
                cost = (previousCost + cost) % MODULO;
                map.put(current, 1 + map.get(current));
                list.add(lastInsertPosition, current);
                continue;
            }
            final int strictlyLessIndex = findIndexStriclyLessThanTarget(list, current);
            int strictlyGreatThan = 0;
            if (map.containsKey(current)) {
                // [ 1 7 7 7 10 ] 7, less = 1, greater = 1
                strictlyGreatThan = list.size() - strictlyLessIndex - map.get(current);
                map.put(current, 1 + map.get(current));
            } else {
                strictlyGreatThan = list.size() - strictlyLessIndex;
                map.put(current, 1);
            }
            list.add(strictlyLessIndex, current);
            lastInsertPosition = strictlyLessIndex;
            final int currentCost = Math.min(strictlyLessIndex, strictlyGreatThan) % MODULO;
            cost = (currentCost + cost) % MODULO;
            previousCost = currentCost;
        }
        return cost;
    }

    [ 1 7 7 7 10 ]
      0 1 2 3  4   5
    input find(0) => index = 0
    input find(7) => index = 1
    input find(6) => index = 1
    input find(9) => index = 4
    input find(11) => index = 5

    private int findIndexStriclyLessThanTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            final int midIndex = left + (right - left) / 2;
            final int midValue = list.get(midIndex);
            if (midValue < target) {
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        if (list.get(right) < target) {
            return right + 1;
        }
        if (list.get(left) < target) {
            return left + 1;
        }
        return left;
    }
     */
}
