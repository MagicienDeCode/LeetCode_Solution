package list_array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> results = new LinkedList<>();
        if (matrix.length == 0) {
            return results;
        }
        int xStart = 0;
        int xEnd = matrix.length - 1;
        int yStart = 0;
        int yEnd = matrix[0].length - 1;
        while (xStart <= xEnd && yStart <= yEnd) {
            // top [xStart] [from yStart to yEnd]
            for (int i = yStart; i <= yEnd; i++) {
                results.add(matrix[xStart][i]);
            }
            // right [from 1+xStart to xEnd] [yEnd]
            for (int i = 1 + xStart; i <= xEnd; i++) {
                results.add(matrix[i][yEnd]);
            }
            if (xStart < xEnd && yStart < yEnd) {
                // bottom [xEnd] [from yEnd-1 to yStart]
                for (int i = yEnd - 1; i >= yStart; i--) {
                    results.add(matrix[xEnd][i]);
                }
                // left [from xEnd-1 to xStart+1] [yStart]
                for (int i = xEnd - 1; i > xStart; i--) {
                    results.add(matrix[i][yStart]);
                }
            }
            ++xStart;
            ++yStart;
            --xEnd;
            --yEnd;
        }
        return results;
    }
}
