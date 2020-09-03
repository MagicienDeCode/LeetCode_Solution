package top_interview_easy.array;

public class ContainsDuplicateIII220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k == 0) {
            return false;
        }
        var start = 0;
        var end = 0;
        while (start < nums.length - 1) {
            if (end - start == k || end == nums.length - 1) {
                end = ++start;
                continue;
            }
            ++end;
            if (Math.abs((long) nums[start] - (long) nums[end]) <= t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final ContainsDuplicateIII220 java = new ContainsDuplicateIII220();
        // false
        System.out.println(java.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        // true
        System.out.println(java.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        // true
        System.out.println(java.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }
}
