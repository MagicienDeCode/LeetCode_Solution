package string_integer;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int index = 1; index < nums.length; index++) {
            result ^= nums[index];
        }
        return result;
    }
}
