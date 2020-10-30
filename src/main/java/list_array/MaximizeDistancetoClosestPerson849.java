package list_array;

public class MaximizeDistancetoClosestPerson849 {
    public int maxDistToClosest(int[] seats) {
        int start = 0;
        int end = 0;
        int result = 1;
        while (end < seats.length) {
            while (end < seats.length - 1 && seats[end] == 0) {
                ++end;
            }
            final int currentDistance;
            if ((start == 0 && seats[0] != 1) || (end == seats.length - 1 && seats[end] != 1)) {
                currentDistance = end - start;
            } else {
                currentDistance = (end - start) >> 1;
            }
            result = Math.max(result, currentDistance);
            start = end++;
        }
        return result;
    }

    public static void main(String[] args) {
        final MaximizeDistancetoClosestPerson849 java = new MaximizeDistancetoClosestPerson849();
        // 1
        System.out.println(java.maxDistToClosest(new int[]{1, 0, 0, 1}));
        // 1
        System.out.println(java.maxDistToClosest(new int[]{1, 0}));
        System.out.println(java.maxDistToClosest(new int[]{0, 0}));
        // 3
        System.out.println(java.maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(java.maxDistToClosest(new int[]{0, 0, 0, 1}));
        // 2
        System.out.println(java.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(java.maxDistToClosest(new int[]{1, 0, 0, 0, 0, 1, 0, 1}));
    }
}
