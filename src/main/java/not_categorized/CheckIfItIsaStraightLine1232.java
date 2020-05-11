package not_categorized;

public class CheckIfItIsaStraightLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        // y = k * x + b , k = deltaY / deltaX
        final int x1 = coordinates[0][0];
        final int y1 = coordinates[0][1];
        final int x2 = coordinates[1][0];
        final int y2 = coordinates[1][1];
        final int deltaX = x1 - x2 == 0 ? 1 : x1 - x2;
        final int deltaY = y1 - y2;
        final int k = deltaY / deltaX;
        final int b = y1 - k * x1;
        for (int index = 2; index < coordinates.length; index++) {
            if (coordinates[index][1] != coordinates[index][0] * k + b) {
                return false;
            }
        }
        return true;
    }
}
