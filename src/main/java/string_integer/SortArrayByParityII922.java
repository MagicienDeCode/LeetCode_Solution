package string_integer;

public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] nums) {
        int lastOdd = 1;
        for (int index = 0; index < nums.length; index += 2) {
            if (nums[index] % 2 == 1) {
                while (nums[lastOdd] % 2 != 0) {
                    lastOdd += 2;
                }
                final int temp = nums[index];
                nums[index] = nums[lastOdd];
                nums[lastOdd] = temp;
            }
        }
        return nums;
    }
}
