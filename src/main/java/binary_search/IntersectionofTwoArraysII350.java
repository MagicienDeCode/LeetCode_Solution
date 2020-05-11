package binary_search;

import java.util.*;

public class IntersectionofTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }

        final Map<Integer, Integer> num1Map = new HashMap<>();
        Arrays.stream(nums1).forEach(i -> {
            num1Map.put(i, num1Map.computeIfAbsent(i, value -> 0) + 1);
        });

        final List<Integer> result = new ArrayList<>();
        Arrays.stream(nums2).forEach(i -> {
            if (num1Map.containsKey(i) && num1Map.get(i) > 0) {
                result.add(i);
                num1Map.put(i, num1Map.get(i) - 1);
            }
        });

        return result.stream().mapToInt(i -> i).toArray();
    }
}
