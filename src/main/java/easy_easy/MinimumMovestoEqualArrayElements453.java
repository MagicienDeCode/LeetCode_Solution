package easy_easy;

public class MinimumMovestoEqualArrayElements453 {
    /*
    Increasing n - 1 smaller elements by 1 = decreasing only the max element by 1
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int count = 0;
        for (int n : nums) {
            count += n - min;
        }
        return count;
    }
}
