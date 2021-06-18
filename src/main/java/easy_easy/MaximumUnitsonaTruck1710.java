package easy_easy;

import java.util.Arrays;

public class MaximumUnitsonaTruck1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int count = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                truckSize -= boxType[0];
                count += boxType[0] * boxType[1];
            } else {
                count += boxType[1] * truckSize;
                break;
            }
        }
        return count;
    }
}
