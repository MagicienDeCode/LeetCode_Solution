package priority_queue;

public class JumpGameII45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        final int end = nums.length - 1;
        int currentIndex = 0;
        int count = 0;
        while (true) {
            final int startIndex = currentIndex + 1;
            final int endIndex = currentIndex + nums[currentIndex];
            if (endIndex >= end) {
                return count + 1;
            }
            int maxIndex = endIndex;
            for (int i = startIndex; i <= endIndex; i++) {
                if (i + nums[i] > maxIndex) {
                    maxIndex = i + nums[i];
                    currentIndex = i;
                }
            }
            ++count;
        }
    }
    /*
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1])
        );
        final int end = nums.length - 1;
        priorityQueue.add(new int[]{0, nums[0]});
        int count = 0;
        while (true) {
            final int[] current = priorityQueue.poll();
            final int startIndex = current[0] + 1;
            final int endIndex = current[0] + current[1];
            if (endIndex >= end) {
                return count + 1;
            }
            for (int i = startIndex; i <= endIndex; i++) {
                priorityQueue.add(new int[]{i, nums[i]});
            }
            ++count;
        }
    }
     */
}
