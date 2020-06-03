package string_integer.sort_an_array_912;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        final PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>(
                        points.length,
                        Comparator.comparingInt(point -> point[0] * point[0] + point[1] * point[1])
                );
        for (int[] p : points) {
            priorityQueue.offer(p);
        }
        final int[][] result = new int[k][];
        for (int index = 0; index < k; index++) {
            result[index] = priorityQueue.poll();
        }
        return result;
    }
    /*
    46ms
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points,
                Comparator.comparingInt(point -> point[0] * point[0] + point[1] * point[1]));
        return copyOfRange(points, K);
    }

    private int[][] copyOfRange(int[][] points, int K) {
        final int[][] result = new int[K][];
        System.arraycopy(points, 0, result, 0, K);
        return result;
    }
    */
    /*
    4ms
    public int[][] kClosest(int[][] points, int K) {
        int start = 0;
        int end = points.length - 1;
        while (start < end) {
            final int flag = quickSort(points, start, end);
            if (flag == K) {
                return copyOfRange(points, K);
            } else if (flag < K) {
                start = flag;
            } else {
                end = flag;
            }
        }
        return copyOfRange(points, K);
    }

    private int[][] copyOfRange(int[][] points, int K) {
        final int[][] result = new int[K][];
        System.arraycopy(points, 0, result, 0, K);
        return result;
    }

    private int quickSort(final int[][] arr, final int start, final int end) {
        int left = start;
        int right = end;
        // A[0]
        final int[] pivot = arr[start];
        // <= see Note-1
        while (left <= right) {
            // find the first that makes arr[left] >= pivot (not in the left part), see Note-2
            while (left <= right && compare(pivot, arr[left]) > 0) {
                ++left;
            }
            while (left <= right && compare(pivot, arr[right]) < 0) {
                --right;
            }
            if (left <= right) {
                final int[] temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                ++left;
                --right;
            }
        }
        return left;
    }

    private int compare(int[] point1, int[] point2) {
        return Integer.compare(
                point1[0] * point1[0] + point1[1] * point1[1],
                point2[0] * point2[0] + point2[1] * point2[1]
        );
    }
     */
}
