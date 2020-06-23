package string_integer;

public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        int flag = nums[0];
        for (int index = 1; index < nums.length; index++) {
            flag ^= nums[index];
        }
        flag = flag & (-flag);
        int r1 = 0;
        int r2 = 0;
        for (int i : nums) {
            if ((i & flag) == 0) {
                r1 = r1 ^ i;
            } else {
                r2 = r2 ^ i;
            }
        }
        return new int[]{r1, r2};
    }
}
