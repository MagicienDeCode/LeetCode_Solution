package easy_easy;

public class PartitionArrayIntoThreePartsWithEqualSum1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        final int partSum = sum / 3;
        int count = 0;
        int current = 0;
        int count0 = 0;
        for (int a : arr) {
            if (a == 0) {
                ++count0;
            }
            current += a;
            if (current == partSum) {
                current = 0;
                ++count;
            }
        }
        return count >= 3 || count0 == arr.length;
    }
}