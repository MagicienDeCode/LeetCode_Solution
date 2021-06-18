package easy_easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatrixCellsinDistanceOrder1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        final List<int[]> results = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                results.add(new int[]{i, j});
            }
        }
        results.sort(Comparator.comparingInt(a -> Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)));
        final int[][] resultArray = new int[results.size()][2];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }
}
