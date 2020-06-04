package binary_search;

public class ReversePairs493 {
    public int reversePairs(int[] nums) {
        final int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(final int[] arr, final int[] temp, final int start, final int end) {
        if (start >= end) {
            return 0;
        }
        final int mid = start + ((end - start) >> 1);
        final int left = mergeSort(arr, temp, start, mid);
        final int right = mergeSort(arr, temp, mid + 1, end);
        return left + right + merge(arr, temp, start, end);
    }

    private int merge(final int[] arr, final int[] temp, final int start, final int end) {
        final int mid = start + ((end - start) >> 1);
        int left = start;
        int right = mid + 1;
        int tempIndex = start;
        int count = 0;
        for (int index = start; index <= mid; index++) {
            final int result = targetGreaterThanTwoTimesPosition(arr, arr[index], mid + 1, end);
            if (result != -1) {
                count += result;
            }
        }
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }
        while (right <= end) {
            temp[tempIndex++] = arr[right++];
        }
        /*
        for(int i = start; i<=end;i++){
            arr[i] = temp[i];
        }
         */
        if (end + 1 - start >= 0) {
            System.arraycopy(temp, start, arr, start, end + 1 - start);
        }
        return count;
    }

    private int targetGreaterThanTwoTimesPosition(
            int[] intArray,
            int target,
            int start,
            int end
    ) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (target > 2 * (long) intArray[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target > 2 * (long) intArray[right]) {
            return right + 1 - start;
        }
        if (target > 2 * (long) intArray[left]) {
            return left + 1 - start;
        }
        return -1;
    }
    /*
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        final List<Integer> sortedList = new ArrayList<>();
        sortedList.add(nums[nums.length - 1]);
        for (int index = nums.length - 2; index >= 0; index--) {
            final int position = targetGreaterThanTwoTimesPosition(sortedList, nums[index]);
            if (position != -1) {
                count += position;
            }
            sortedList.add(binarySearchIndex(sortedList, nums[index]), nums[index]);
        }
        return count;
    }

    private int binarySearchIndex(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size() - 1;
        if (sortedList.size() == 1) {
            if (target <= sortedList.get(0)) {
                return 0;
            }
            return 1;
        }
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (sortedList.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= sortedList.get(left)) {
            return left;
        }
        if (target <= sortedList.get(right)) {
            return right;
        }
        return right + 1;
    }

    private int targetGreaterThanTwoTimesPosition(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (target > 2 * (long) sortedList.get(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target > 2 * (long) sortedList.get(right)) {
            return right + 1;
        }
        if (target > 2 * (long) sortedList.get(left)) {
            return left + 1;
        }
        return -1;
    }
     */
}
