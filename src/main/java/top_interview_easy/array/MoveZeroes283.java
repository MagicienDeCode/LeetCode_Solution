package top_interview_easy.array;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                if (index != lastNonZeroIndex) {
                    final int temp = nums[index];
                    nums[index] = nums[lastNonZeroIndex];
                    nums[lastNonZeroIndex] = temp;
                }
                ++lastNonZeroIndex;
            }
        }
    }
}

