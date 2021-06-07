package list_array;

public class PartitionArrayintoDisjointIntervals915 {
    public int partitionDisjoint(int[] nums) {
        // search a position that max[left] <= min[right]
        final int[] maxLeft = new int[nums.length];
        final int[] minRight = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            maxLeft[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minRight[i] = min;
        }
        for (int i = 1; i < nums.length; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
