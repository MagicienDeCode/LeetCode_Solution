package dynamic_programming;

public class PartitionArrayforMaximumSum1043 {
    /*
    dp[i] = Max( 从当前位置i 往前 取一个子数组A[j:i] ，将该子数组中的所有元素都 置换为 子数组中最大值后，求该子数组的和tMax *(i-j)， tMax *(i-j) + dp[j]) ，
    其中 i - j<= K && j >= 0
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return 0;
    }
































    /*
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N+1];
        for(int i = 1 ; i <= N; i++){
            int tMax = 0;
            for(int j = i - 1; i - j <= K && j>=0;j--){
                tMax = Math.max(tMax,A[j]);
                dp[i] = Math.max(dp[i],dp[j] + tMax *(i-j));
            }
        }
        return dp[N];
    }
     */
}
