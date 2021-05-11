package sliding_window;

public class MaximumPointsYouCanObtainfromCards1423 {
    public int maxScore(int[] cardPoints, int k) {
        final int size = cardPoints.length - k;
        int sum = 0;
        for (int c : cardPoints) {
            sum += c;
        }
        int windowSum = 0;
        for (int i = 0; i < size; i++) {
            windowSum += cardPoints[i];
        }
        int result = sum - windowSum;
        for (int i = size; i < cardPoints.length; i++) {
            windowSum += cardPoints[i] - cardPoints[i - size];
            result = Math.max(result, sum - windowSum);
        }
        return result;
    }
}
