package top_interview_easy.array;

public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int current = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[current] != nums[index]) {
                ++current;
                nums[current] = nums[index];
            }
        }
        return current + 1;
    }
}
