package easy_easy;

public class SumofAllOddLengthSubarrays1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length; j++) {
                if (j + i <= arr.length) {
                    for (int k = 0; k < i; k++) {
                        sum += arr[j + k];
                    }
                }
            }
        }
        return sum;
    }
}
