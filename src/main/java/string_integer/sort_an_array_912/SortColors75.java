package string_integer.sort_an_array_912;

public class SortColors75 {
    public void sortColors(int[] nums) {
        int position0 = 0;
        int position2 = nums.length - 1;
        int index = 0;
        while (index <= position2) {
            if (nums[index] == 0) {
                swap(nums, position0++, index++);
            } else if (nums[index] == 1) {
                ++index;
            } else {
                swap(nums, position2--, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
