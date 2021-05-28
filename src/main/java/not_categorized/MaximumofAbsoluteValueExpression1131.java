package not_categorized;

public class MaximumofAbsoluteValueExpression1131 {
    // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
    /*
    arr1[i] - arr1[j] + arr2[i] - arr2[j] + i - j ---> (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)
    arr1[i] - arr1[j] + arr2[i] - arr2[j] - i + j ---> (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j] - j)
    arr1[i] - arr1[j] - arr2[i] + arr2[j] + i - j ---> (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)
    arr1[i] - arr1[j] - arr2[i] + arr2[j] - i + j ---> (arr1[i] - arr2[i] - i) - (arr1[j] - arr2[j] - j)
     */
    /*
    (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)
    (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j] - j)
    (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)
    (arr1[i] - arr2[i] - i) - (arr1[j] - arr2[j] - j)
     */
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int result = 0;
        // abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B).
        for (int k = 0; k < 4; k++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr1.length; i++) {
                final int current = arr1[i] + arr2[i] * deltaX[k] + i * deltaY[k];
                min = Math.min(min, current);
                max = Math.max(max, current);
            }
            result = Math.max(max - min, result);
        }

        return result;
    }

    private final int[] deltaX = {-1, 1, -1, 1};
    private final int[] deltaY = {-1, 1, 1, -1};
}
