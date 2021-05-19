package easy_easy;

public class MaximumProductofTwoElementsinanArray1464 {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int n : nums) {
            if (n == max1) {
                max2 = max1;
            }
            if (n > max1) {
                max2 = max1;
                max1 = n;
            }
            if (n > max2 && n < max1) {
                max2 = n;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
