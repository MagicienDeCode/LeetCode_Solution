package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final List<Integer> result = new ArrayList<>();
        int index = search(arr, k, x);
        while (k > 0) {
            k--;
            result.add(arr[index++]);
        }
        return result;
    }

    private int search(int[] nums, int k, int target) {
        int left = 0;
        int right = nums.length - k;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (target - nums[mid] > nums[mid + k - 1] - target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target - nums[left] <= nums[right + k - 1] - target) {
            return left;
        }
        return right;
    }
    /*
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (x < arr[0]) {
            return arrList.subList(0, k);
        }
        if (x > arr[arr.length - 1]) {
            return arrList.subList(arr.length - k, arr.length);
        }
        int startIndex = searchClosestXIndex(arr, x);
        int endIndex = startIndex;
        int count = k - 1;
        while (count > 0) {
            count--;
            if (endIndex == arr.length - 1 ||
                    (startIndex > 0 && x - arr[startIndex - 1] <= arr[endIndex + 1] - x)) {
                startIndex--;
            } else {
                endIndex++;
            }
        }
        return arrList.subList(startIndex, endIndex + 1);
    }

    public int searchClosestXIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return target - nums[left] <= nums[right] - target ? left : right;
    }
     */
}
