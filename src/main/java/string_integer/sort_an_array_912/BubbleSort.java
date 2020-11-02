package string_integer.sort_an_array_912;

import java.util.Arrays;

public class BubbleSort {
    // S(1) O(n*n) stable
    public void sort(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
    /*
        int temp = arr[j + 1];
        arr[j + 1] = arr[j];
        arr[j] = temp;
     */

    public static void main(String... args) {
        final int[] arr = new int[]{25, 1, 45, 10, 7};
        final BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
