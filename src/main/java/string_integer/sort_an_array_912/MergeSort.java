package string_integer.sort_an_array_912;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    // S(n) O(log(n)*n) stable,
    public void sort(final int[] arr) {
        final int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(final int[] arr, final int[] temp, final int start, final int end) {
        if (start >= end) {
            return;
        }
        final int mid = start + ((end - start) >> 1);
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);
        merge(arr, temp, start, end);
    }

    private void merge(final int[] arr, final int[] temp, final int start, final int end) {
        final int mid = start + ((end - start) >> 1);
        int left = start;
        int right = mid + 1;
        int tempIndex = start;
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
    }

    public static void main(String... args) {
        final int[] arr = new int[]{25, 1, 45, 10, 7};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        // DualPivotQuicksort.sort
        Arrays.sort(arr);
        /*
        default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, c);
        ListIterator<E> i = this.listIterator();
        Object[] var4 = a;
        int var5 = a.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Object e = var4[var6];
            i.next();
            i.set(e);
        }
         */
        final List<Integer> test = List.of(1, 2, 3);
        // Immutable object is passed where mutable is expected
        // Collections.sort(test);
        System.out.println(Collections.binarySearch(test, 10));
    }
}
