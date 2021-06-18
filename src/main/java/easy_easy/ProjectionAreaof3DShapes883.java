package easy_easy;

public class ProjectionAreaof3DShapes883 {
    public int projectionArea(int[][] grid) {
        int top = 0;
        int front = 0;
        int side = 0;
        final int[] fronts = new int[grid.length];
        final int[] sides = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int fMax = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
                fMax = Math.max(fMax, grid[i][j]);
                sides[j] = Math.max(sides[j], grid[i][j]);
            }
            fronts[i] = fMax;
        }
        int result = top;
        for (int f : fronts) {
            result += f;
        }
        for (int s : sides) {
            result += s;
        }
        return result;
    }
}
