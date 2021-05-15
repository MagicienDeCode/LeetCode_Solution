package easy_easy;

public class ShuffletheArray1470 {
    public int[] shuffle(int[] nums, int n) {
        final int[] results = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            results[index++] = nums[i];
            results[index++] = nums[i + n];
        }
        return results;
    }
}
