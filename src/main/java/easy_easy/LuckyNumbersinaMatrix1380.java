package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersinaMatrix1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        final List<Integer> list = new LinkedList<>();
        final int[] maxCols = new int[matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            int max = 0;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[col]);
            }
            maxCols[col] = max;
        }

        for (int[] ints : matrix) {
            int minIndex = 0;
            int min = ints[0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }
            if (maxCols[minIndex] == min) {
                list.add(min);
            }
        }
        return list;
    }
}
