package easy_easy;

public class FindNumberswithEvenNumberofDigits1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            int d = 0;
            while (n > 0) {
                n /= 10;
                d++;
            }
            count += d % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}
