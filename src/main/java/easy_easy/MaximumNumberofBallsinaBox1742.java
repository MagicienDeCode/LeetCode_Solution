package easy_easy;

public class MaximumNumberofBallsinaBox1742 {
    public int countBalls(int lowLimit, int highLimit) {
        final int[] box = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            box[calculate(i)]++;
        }
        int max = 0;
        for (int b : box) {
            max = Math.max(b, max);
        }
        return max;
    }

    private int calculate(int i) {
        int result = 0;
        while (i > 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }
}
