package notcategorized;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int i : nums) {
            if (i == majority) {
                ++count;
            } else if (--count == 0) {
                count = 1;
                majority = i;
            }
        }
        return majority;
    }
}
