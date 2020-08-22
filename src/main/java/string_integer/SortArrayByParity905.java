package string_integer;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        int lastNonOdd = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] % 2 == 0) {
                if (index != lastNonOdd) {
                    final int temp = nums[index];
                    nums[index] = nums[lastNonOdd];
                    nums[lastNonOdd] = temp;
                }
                ++lastNonOdd;
            }
        }
        return nums;
    }
}
