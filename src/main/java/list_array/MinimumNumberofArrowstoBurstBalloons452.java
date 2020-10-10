package list_array;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons452 {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int result = 1;
        int endIndex = points[0][1];
        for (int[] point : points) {
            if (point[0] <= endIndex) {
                endIndex = Math.min(endIndex, point[1]);
            } else {
                ++result;
                endIndex = point[1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final MinimumNumberofArrowstoBurstBalloons452 java = new MinimumNumberofArrowstoBurstBalloons452();
        System.out.println(
                java.findMinArrowShots(
                        new int[][]{{10, 6}, {2, 8}, {1, 6}, {7, 12}}
                )
        );
        System.out.println(
                java.findMinArrowShots(
                        new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}
                )
        );
    }
}
