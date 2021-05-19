package easy_easy;

public class FindNUniqueIntegersSumuptoZero1304 {
    public int[] sumZero(int n) {
        final int[] resultArray = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            resultArray[index++] = i;
            resultArray[index++] = -i;
        }
        if (n % 2 != 0) {
            resultArray[index] = 0;
        }
        return resultArray;
    }
}
