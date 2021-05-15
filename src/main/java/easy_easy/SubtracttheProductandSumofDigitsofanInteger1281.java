package easy_easy;

public class SubtracttheProductandSumofDigitsofanInteger1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            final int temp = n % 10;
            product *= temp;
            sum += temp;
            n /= 10;
        }
        return product - sum;
    }
}
