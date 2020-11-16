package string_integer;

public class LongestMountaininArray845 {
    public int longestMountain(int[] a) {
        int max = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                while (left > 0 && a[left] > a[left - 1]) {
                    --left;
                }
                while (right < a.length - 1 && a[right] > a[right - 1]) {
                    ++right;
                }
                max = Math.max(max, right - left);
            }
        }
        return max;
    }
}
