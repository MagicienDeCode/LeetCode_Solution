package list_array;

public class ChampagneTower799 {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        final double[][] result = new double[101][101];
        result[0][0] = poured;
        for (int i = 0; i <= queryRow; i++) {
            for (int j = 0; j <= i; j++) {
                final double now = (result[i][j] - 1.0) / 2.0;
                if (now > 0) {
                    result[i + 1][j] += now;
                    result[i + 1][j + 1] += now;
                }
            }
        }
        return Math.min(1, result[queryRow][queryGlass]);
    }
}
