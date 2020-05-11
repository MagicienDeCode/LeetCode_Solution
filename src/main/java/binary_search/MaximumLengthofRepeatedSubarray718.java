package binary_search;

public class MaximumLengthofRepeatedSubarray718 {
    /*
    public int findLength(int[] A, int[] B) {
        final StringBuilder stringBuilderA = new StringBuilder();
        final StringBuilder stringBuilderB = new StringBuilder();
        for (int a : A) {
            stringBuilderA.append((char) a);
        }
        for (int b : B) {
            stringBuilderB.append((char) b);
        }
        final String StringA = stringBuilderA.toString();
        final String StringB = stringBuilderB.toString();
        int left = 0;
        int right = Math.min(A.length, B.length);
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isValidLength(StringA, StringB, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValidLength(StringA, StringB, right)) {
            return right;
        }
        return left;
    }

    private boolean isValidLength(String A, String B, int target) {
        final Set<String> stringASet = new HashSet<>();
        for (int index = 0; index <= A.length() - target; index++) {
            stringASet.add(A.substring(index, index + target));
        }
        for (int index = 0; index <= B.length() - target; index++) {
            if (stringASet.contains(B.substring(index, index + target))) {
                return true;
            }
        }
        return false;
    }
     */
    /*
    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        // S(n*n)
        final int[][] dynamicProgramming = new int[A.length + 1][B.length + 1];
        // O(n*n)
        for (int indexA = 0; indexA < A.length; indexA++) {
            for (int indexB = 0; indexB < B.length; indexB++) {
                if (A[indexA] == B[indexB]) {
                    dynamicProgramming[indexA + 1][indexB + 1] =
                            1 + dynamicProgramming[indexA][indexB];
                    maxLength = Math.max(maxLength, dynamicProgramming[indexA + 1][indexB + 1]);
                }
            }
        }
        return maxLength;
    }
    */
   /*
    2*n*n
    public int findLength(int[] A, int[] B) {
        return Math.max(compareStartElement(A, B), compareStartElement(B, A));
    }

    private int compareStartElement(int[] A, int[] B) {
        int maxLength = 0;
        for (int indexA = 0; indexA < A.length; indexA++) {
            int startA = indexA;
            int startB = 0;
            int count = 0;
            while (startA < A.length && startB < B.length) {
                if (A[startA++] == B[startB++]) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                } else {
                    count = 0;
                }
            }
        }
        return maxLength;
    }
     */
    /*
    n * n * n
    time limit exceeded
    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        for (int indexA = 0; indexA < A.length; indexA++) {
            for (int indexB = 0; indexB < B.length; indexB++) {
                if (A[indexA] == B[indexB]) {
                    int startA = indexA + 1;
                    int startB = indexB + 1;
                    int count = 1;
                    maxLength = Math.max(maxLength, count);
                    while (startA < A.length &&
                            startB < B.length &&
                            A[startA] == B[startB]) {
                        count++;
                        maxLength = Math.max(maxLength, count);
                        startA++;
                        startB++;
                    }
                }
            }
        }
        return maxLength;
    }
     */
}
