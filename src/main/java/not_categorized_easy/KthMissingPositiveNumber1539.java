package not_categorized_easy;

public class KthMissingPositiveNumber1539 {
    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int result = -1;
        for (int i = 1; i < arr[arr.length - 1]; i++) {
            if (i == arr[index]) {
                index = index == arr.length - 1 ? index : index + 1;
            } else {
                result = i;
            }
        }
        return result;
    }
}
