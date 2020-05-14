package binary_search;

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] numsA, int[] numsB) {
        if (numsA.length > numsB.length) {
            return findMedianSortedArrays(numsB, numsA);
        }
        if (numsA.length == 0) {
            if (numsB.length % 2 == 1) {
                return numsB[numsB.length >> 1] * 0.1;
            }
            return (numsB[numsB.length >> 1] + numsB[(numsB.length >> 1) - 1]) / 2.0;
        }
        final int indexA = binarySearchIndexA(numsA, numsB);
        final int indexB = ((numsA.length + numsB.length + 1) >> 1) - indexA;
        final int maxOfLeftAB = indexA == 0 ? numsB[indexB - 1] :
                indexB == 0 ? numsA[indexA - 1] :
                        Math.max(numsA[indexA - 1], numsB[indexB - 1]);
        if ((numsA.length + numsB.length) % 2 == 1) {
            return maxOfLeftAB * 1.0;
        }
        final int minOfRightAB = indexA == numsA.length ? numsB[indexB] :
                indexB == numsB.length ? numsA[indexA] :
                        Math.min(numsA[indexA], numsB[indexB]);
        return (maxOfLeftAB + minOfRightAB) / 2.0;
    }

    private int binarySearchIndexA(int[] numsA, int[] numsB) {
        int left = 0;
        int right = numsA.length;
        final int halfOfAB = (numsA.length + numsB.length + 1) >> 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            final int indexB = halfOfAB - mid;
            if (indexB >= 1 && numsB[indexB - 1] > numsA[mid]) {
                left = mid;
            } else if (mid >= 1 && numsA[mid - 1] > numsB[indexB]) {
                right = mid;
            } else {
                return mid;
            }
        }
        final int indexB = halfOfAB - left;
        // Cut 3  indexA = 0
        // 1 2 Cut  indexB = ( 1 + 2 + 1 ) / 2 - 0 = 2
        if (left == 0 && numsA[0] >= numsB[indexB - 1]) {
            return left;
        }
        if (left == 0 && numsA[0] < numsB[indexB - 1]) {
            return right;
        }
        if (Math.max(numsA[left - 1], numsB[indexB - 1]) <= Math.min(numsA[left], numsB[indexB])) {
            return left;
        }
        return right;
    }
}
