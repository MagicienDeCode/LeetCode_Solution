package easy_easy;

public class RichestCustomerWealth1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int a : account) {
                sum += a;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    /*
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }
     */
}
