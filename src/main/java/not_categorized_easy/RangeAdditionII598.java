package not_categorized_easy;

public class RangeAdditionII598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minM = Math.min(minM, op[0]);
            minN = Math.min(minN, op[1]);
        }
        return minM * minN;
    }
    /*
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        final PriorityQueue<Integer> minM = new PriorityQueue<>();
        final PriorityQueue<Integer> minN = new PriorityQueue<>();
        for (int[] op : ops) {
            minM.offer(op[0]);
            minN.offer(op[1]);
        }
        return minM.peek() * minN.peek();
    }
     */
}
