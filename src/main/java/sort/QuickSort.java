package sort;

import java.util.Arrays;

public class QuickSort {
    // S(1) O(n*log(n)) NOT stable, see Note-3
    public void sort(final int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(final int[] arr, final int start, final int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        // A[0]
        final int pivot = arr[left + (right - left) / 2];
        // <= see Note-1
        while (left <= right) {
            // find the first that makes arr[left] >= pivot (not in the left part), see Note-2
            while (left <= right && arr[left] < pivot) {
                ++left;
            }
            while (left <= right && arr[right] > pivot) {
                --right;
            }
            if (left <= right) {
                final int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                ++left;
                --right;
            }
            quickSort(arr, start, right);
            quickSort(arr, left, end);
        }
    }

    /* Note-1
    [1,2]
    if replace all left <= right by left < right
    pivot = 1
    left = 0, arr[0] =1
    right = 1, arr[1] =2

    at the end of the first loop
    left = 0, arr[0] =1
    right = 0, arr[0] =1

    then we do:
    quickSort(arr, start, right); start = 0 right = 0 ==> [1]
    quickSort(arr, left, end);  left = 0 end = 1 ==> [1,2] ==> !! Stack Overflow !!
     */

    /*
    Note-2

    1. the right way to do partition
    while arr[left] < pivot  arr[right] > pivot
    arr[left] >= pivot  <==> arr[right] <= pivot
    ... <= pivot <= ...


    2. !! Stack Overflow !!
    while arr[left] < pivot   arr[right] >= pivot
    arr[left] >= pivot  <==> arr[right] < pivot
    ... < pivot <= ...
    pivot = 1
    [1,1]
    left = 0
    right = 0
    quickSort(arr, start, right); start = 0 right = 0 ==> [1]
    quickSort(arr, left, end);  left = 0 end = 1 ==> [1,1] ==> !! Stack Overflow !!

    while arr[left] <= pivot   arr[right] > pivot

    while arr[left] <= pivot   arr[right] >= pivot
    arr[left] > pivot  <==> arr[right] < pivot
    ... < pivot < ...
    pivot = 1
    [1,1]
    left = 1
    right = 1
    quickSort(arr, start, right); start = 0 right = 1 ==> [1,1] ==> !! Stack Overflow !!
    quickSort(arr, left, end);  left = 1 end = 1 ==> [1]
     */

    /*
    Note-3
    pivot = 1
    [3(x),1,1,3(y),1]
    ... <= pivot <= ...   while arr[left] < pivot  arr[right] > pivot
    the first element >= 1 is 3(x)
    from the end, the first element <= 1
    after change
    [1,1,1,3(y),3(x)]
     */

    public static void main(String... args) {
        final int[] test = new int[]{25, 1, 45, 10, 7};
        final QuickSort quickSort = new QuickSort();
        quickSort.sort(test);
        Arrays.stream(test).forEach(System.out::println);

        /*
        final int[] arr = new int[]{1, 2};
        int left = 0;
        int right = 0;
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
        ++left;
        --right;
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(left);
        System.out.println(right);
         */
    }
}
