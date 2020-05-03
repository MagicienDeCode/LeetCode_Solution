package notcategorized;

public class MaximumNestingDepthofTwoValidParenthesesStrings1111 {
    public int[] maxDepthAfterSplit(final String seq) {
        final int[] result = new int[seq.length()];
        int leftCount = 0;
        int rightCount = 0;
        for (int index = 0; index < seq.length(); index++) {
            if (seq.charAt(index) == '(') {
                if (leftCount <= rightCount) {
                    result[index] = 0;
                    leftCount++;
                } else {
                    result[index] = 1;
                    rightCount++;
                }
            } else {
                if (rightCount <= leftCount) {
                    result[index] = 0;
                    rightCount++;
                } else {
                    result[index] = 1;
                    leftCount++;
                }
            }
        }
        return result;
    }
}
