package easy_easy;

public class MinimumTimeVisitingAllPoints1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            final int[] p1 = points[i - 1];
            final int[] p2 = points[i];
            count += Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
        }
        return count;
    }
}
