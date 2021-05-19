package easy_easy;

public class SignoftheProductofanArray1822 {
    public int arraySign(int[] nums) {
        boolean positive = true;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                positive = !positive;
            }
        }
        return positive ? 1 : -1;
    }
}
