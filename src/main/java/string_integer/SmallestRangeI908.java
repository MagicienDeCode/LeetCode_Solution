package string_integer;

public class SmallestRangeI908 {
    /*
    aim = min => max(b) - min(b)
    the smallest max(b) = max(a) - k
    the largest min(b) = min(b) + k
    aim = max(a) - k - min(a) - k
     */
    public int smallestRangeI(int[] a, int k) {
        int min = a[0];
        int max = a[0];
        for (int x : a) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
