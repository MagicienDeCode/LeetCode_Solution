package string_integer;

public class MinimumDominoRotationsForEqualRow1007 {
    public int minDominoRotations(int[] a, int[] b) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            final int ab = domino(a, b, i);
            if (ab != -1) {
                min = Math.min(min, ab);
            }
            final int ba = domino(b, a, i);
            if (ba != -1) {
                min = Math.min(min, ba);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int domino(int[] a, int[] b, int target) {
        int count = 0;
        boolean result = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != target) {
                if (b[i] == target) {
                    count++;
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result ? count : -1;
    }
}
