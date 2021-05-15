package easy_easy;

public class NumberofGoodPairs1512 {
    public int numIdenticalPairs(int[] nums) {
        final int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int result = 0;
        for (int c : count) {
            result += c * (c - 1) / 2;
        }
        return result;
    }
}
