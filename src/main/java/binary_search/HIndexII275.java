package binary_search;

public class HIndexII275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (citations[citations.length - mid] >= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (citations[citations.length - right] >= right) {
            return right;
        }
        if (left == 0) {
            return 0;
        }
        if (citations[citations.length - left] >= left) {
            return left;
        }
        return -1;
    }
}
