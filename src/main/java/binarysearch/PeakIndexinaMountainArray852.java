package binarysearch;

public class PeakIndexinaMountainArray852 {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if ( A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1] ) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if ( A[left] > A[right] && A[left - 1] < A[left]) {
            return left;
        }
        return right;
    }
}
