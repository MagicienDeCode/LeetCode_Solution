package array.sort_an_array_912;

import java.util.Arrays;

public class InsertionSort {
    // S(1) O(n*n) stable
    public void sort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int lastPosition = i - 1;
            final int current = arr[i];
            while (lastPosition >= 0 && arr[lastPosition] > current) {
                arr[lastPosition + 1] = arr[lastPosition];
                lastPosition--;
            }
            arr[lastPosition + 1] = current;
        }
    }
    /*
    25 --- 1 45 10 7
    1 25 --- 45 10 7
    1 25 45 --- 10 7
    *****current=10*****
    1 25 45 [] 7
    1 25 45 45 7
    1 25 25 45 7
    1 10 25 45 --- 7
    *****current=7*****
    1 10 25 45 []
    1 10 25 45 45
    1 10 25 25 45
    1 10 10 25 45
    1 7 10 25 45
     */

    public static void main(String... args) {
        final int[] arr = new int[]{25, 1, 45, 10, 7};
        final InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
