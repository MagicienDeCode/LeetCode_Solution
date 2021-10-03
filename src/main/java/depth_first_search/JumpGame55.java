package depth_first_search;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        final int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return true;
    }
    /*
    Time Limit Exceeded
    public boolean canJump(int[] nums) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        final Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int current = queue.poll();
                if (current >= nums.length - 1) {
                    return true;
                }
                final int max = nums[current] + current;
                for (int j = current + 1; j <= max; j++) {
                    if (!set.contains(j)) {
                        queue.offer(j);
                        set.add(j);
                    }
                }
            }
        }
        return false;
    }
     */
}
