package binary_search;

public class CountofRangeSum327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final long[] sums = new long[nums.length + 1];
        for (int index = 0; index < nums.length; index++) {
            sums[index + 1] = sums[index] + nums[index];
        }
        final long[] temps = new long[sums.length];
        return mergeSort(sums, temps, 0, sums.length - 1, lower, upper);
    }


    private int mergeSort(
            final long[] arr,
            final long[] temp,
            final int start,
            final int end,
            final int lower,
            final int upper
    ) {
        if (start >= end) {
            return 0;
        }
        final int mid = start + ((end - start) >> 1);
        return mergeSort(arr, temp, start, mid, lower, upper) +
                mergeSort(arr, temp, mid + 1, end, lower, upper) +
                merge(arr, temp, start, end, lower, upper);
    }

    private int merge(
            final long[] arr,
            final long[] temp,
            final int start,
            final int end,
            final int lower,
            final int upper
    ) {
        final int mid = start + ((end - start) >> 1);
        int left = start;
        int right = mid + 1;
        int tempIndex = start;

        int count = 0;
        int currentIndex = left;
        while (currentIndex <= mid) {
            final int min = searchFirstPositionGt(arr, arr[currentIndex] + lower, mid + 1, end);
            final int max = searchLastPositionLt(arr, arr[currentIndex] + upper, mid + 1, end);
            if (min != -1 && max != -1) {
                count += max - min + 1;
            }
            ++currentIndex;
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

    public int searchFirstPositionGt(
            final long[] nums,
            final long target,
            final int start,
            final int end
    ) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        }
        if (nums[right] >= target) {
            return right;
        }
        return -1;
    }

    public int searchLastPositionLt(
            final long[] nums,
            final long target,
            final int start,
            final int end
    ) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] <= target) {
            return right;
        }
        if (nums[left] <= target) {
            return left;
        }
        return -1;
    }

    /*
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final List<Long> sums = new ArrayList<>();
        sums.add(0L);
        int count = 0;
        long currentSum = 0L;
        for (int num : nums) {
            currentSum += num;
            final int min = searchFirstPositionGreaterThan(sums, currentSum - upper);
            final int max = searchLastPositionLessThan(sums, currentSum - lower);
            if (min != -1 && max != -1) {
                count += max - min + 1;
            }
            sums.add(searchInsert(sums, currentSum), currentSum);
        }
        return count;
    }

    private int searchInsert(List<Long> nums, long target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= nums.get(left)) {
            return left;
        } else if (target <= nums.get(right)) {
            return right;
            // return left +1;
        } else {
            return right + 1;
        }
    }

    // [7] 7 7
    public int searchFirstPositionGreaterThan(List<Long> nums, long target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums.get(left) >= target) {
            return left;
        }
        if (nums.get(right) >= target) {
            return right;
        }
        return -1;
    }

    public int searchLastPositionLessThan(List<Long> nums, long target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums.get(right) <= target) {
            return right;
        }
        if (nums.get(left) <= target) {
            return left;
        }
        return -1;
    }
     */
}
