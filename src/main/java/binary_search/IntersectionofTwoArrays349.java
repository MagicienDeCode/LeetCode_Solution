package binary_search;

import java.util.*;

public class IntersectionofTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersection(nums2, nums1);
        }
        final Set<Integer> nums1Set = new HashSet<>();
        Arrays.stream(nums1).forEach(nums1Set::add);
        final Set<Integer> nums2Set = new HashSet<>();
        Arrays.stream(nums2).forEach(nums2Set::add);
        final List<Integer> result = new ArrayList<>();
        nums1Set.forEach(i -> {
            if (nums2Set.contains(i)) {
                result.add(i);
            }
        });
        return result.stream().mapToInt(i -> i).toArray();
    }
}
