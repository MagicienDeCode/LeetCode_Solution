package easy_easy;

public class SumofUniqueElements1748 {
    public int sumOfUnique(int[] nums) {
        final int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int sum = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
