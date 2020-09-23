package binary_search;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        final int[] timeArray = new int[1001];
        for (int[] trip : trips) {
            timeArray[trip[1]] += trip[0];
            timeArray[trip[2]] -= trip[0];
        }
        int current = 0;
        for (int t : timeArray) {
            current += t;
            if (current > capacity) {
                return false;
            }
        }
        return true;
    }
}
