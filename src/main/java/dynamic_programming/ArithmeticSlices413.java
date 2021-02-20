package dynamic_programming;

public class ArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] a) {
        int result = 0;
        int consecutive = 0;

        for (int i = 2; i < a.length; i++) {
            if (a[i - 2] - a[i - 1] == a[i - 1] - a[i]) {
                ++consecutive;
                result += consecutive;
            } else {
                consecutive = 0;
            }
        }

        return result;
    }
}
