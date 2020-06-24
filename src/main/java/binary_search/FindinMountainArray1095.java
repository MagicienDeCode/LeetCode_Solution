package binary_search;

interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindinMountainArray1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        final int length = mountainArr.length();
        final int topIndex = topIndex(length, mountainArr);
        final int index0Val = mountainArr.get(0);
        final int topIndexVal = mountainArr.get(topIndex);
        final int indexMaxVal = mountainArr.get(length - 1);
        if (index0Val <= target && target <= topIndexVal) {
            final int result =
                    findInAscending(mountainArr, topIndex, target);
            if (result != -1) {
                return result;
            }
        }
        if (topIndexVal >= target && target >= indexMaxVal) {
            return findInDescending(mountainArr, topIndex, length - 1, target);
        }
        return -1;
    }

    private int findInAscending(
            MountainArray mountainArray,
            int end,
            int target
    ) {
        int left = 0;
        int right = end;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            final int midVal = mountainArray.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (mountainArray.get(left) == target) {
            return left;
        }
        if (mountainArray.get(right) == target) {
            return right;
        }
        return -1;
    }

    private int findInDescending(
            MountainArray mountainArray,
            int start,
            int end,
            int target
    ) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            final int midVal = mountainArray.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (mountainArray.get(left) == target) {
            return left;
        }
        if (mountainArray.get(right) == target) {
            return right;
        }
        return -1;
    }

    private int topIndex(
            int length,
            MountainArray mountainArray
    ) {
        int left = 0;
        int right = length;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            final int midMinus1 = mountainArray.get(mid - 1);
            final int midVal = mountainArray.get(mid);
            final int midPlus1 = mountainArray.get(mid + 1);
            if (midMinus1 < midVal && midVal > midPlus1) {
                return mid;
            } else if (midMinus1 < midVal && midVal < midPlus1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        final int leftMinus1 = mountainArray.get(left - 1);
        final int leftVal = mountainArray.get(left);
        final int rightVal = mountainArray.get(right);
        if (leftMinus1 < leftVal && leftVal > rightVal) {
            return left;
        }
        return right;
    }
}
