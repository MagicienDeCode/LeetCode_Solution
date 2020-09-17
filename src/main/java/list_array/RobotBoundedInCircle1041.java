package list_array;

public class RobotBoundedInCircle1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;
        final int[] deltaX = {0, 1, 0, -1};
        final int[] deltaY = {1, 0, -1, 0};
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                direction = (direction + 1) % 4;
            } else if (c == 'L') {
                direction = (direction + 3) % 4;
            } else {
                x += deltaX[direction];
                y += deltaY[direction];
            }
        }
        return x == 0 && y == 0 || direction > 0;
    }
}
