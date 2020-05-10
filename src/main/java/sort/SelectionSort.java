package sort;

import java.util.Arrays;

public class SelectionSort {
    // S(1) O(n*n) NOT stable
    // [ 7, 10, 7, 2, 30 ] the first 7 will exchange with 2. This makes it after the second 7
    public void sort(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[minIndex] ^ arr[i];
                arr[i] = arr[minIndex] ^ arr[i];
                arr[minIndex] = arr[minIndex] ^ arr[i];
            }
        }
    }

    public static void main(String... args) {
        final int[] arr = new int[]{25, 1, 45, 10, 7};
        final SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
