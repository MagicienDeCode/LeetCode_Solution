package list_array;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        final int[][] results = new int[n][n];
        int number = 1;
        int xStart = 0;
        int xEnd = results.length - 1;
        int yStart = 0;
        int yEnd = results[0].length - 1;
        while (xStart <= xEnd && yStart <= yEnd) {
            // top [xStart] [from yStart to yEnd]
            for (int i = yStart; i <= yEnd; i++) {
                results[xStart][i] = number++;
            }
            // right [from 1+xStart to xEnd] [yEnd]
            for (int i = 1 + xStart; i <= xEnd; i++) {
                results[i][yEnd] = number++;
            }
            if (xStart < xEnd && yStart < yEnd) {
                // bottom [xEnd] [from yEnd-1 to yStart]
                for (int i = yEnd - 1; i >= yStart; i--) {
                    results[xEnd][i] = number++;
                }
                // left [from xEnd-1 to xStart+1] [yStart]
                for (int i = xEnd - 1; i > xStart; i--) {
                    results[i][yStart] = number++;
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
