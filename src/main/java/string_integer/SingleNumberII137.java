package string_integer;

public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int i : nums) {
            one = one ^ i & (~two);
            two = two ^ i & (~one);
        }
        return one;
    }
}
