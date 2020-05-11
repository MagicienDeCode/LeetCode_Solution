package depth_first_search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int target = image[sr][sc];
        if (target == newColor) {
            return image;
        }
        final Queue<Pair<Integer, Integer>> coordinateQueue = new LinkedList<>();
        coordinateQueue.offer(new Pair<>(sr, sc));
        while (!coordinateQueue.isEmpty()) {
            final int currentSize = coordinateQueue.size();
            for (int i = 0; i < currentSize; i++) {
                final Pair<Integer, Integer> current = coordinateQueue.poll();
                final int x = current.getKey();
                final int y = current.getValue();
                if (image[x][y] == target) {
                    image[x][y] = newColor;
                    if (x >= 1) {
                        coordinateQueue.offer(new Pair<>(x - 1, y));
                    }
                    if (y >= 1) {
                        coordinateQueue.offer(new Pair<>(x, y - 1));
                    }
                    if (x + 1 < image.length) {
                        coordinateQueue.offer(new Pair<>(x + 1, y));
                    }
                    if (y + 1 < image[0].length) {
                        coordinateQueue.offer(new Pair<>(x, y + 1));
                    }
                }
            }
        }
        return image;
    }

    /*
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
     */
    // 0ms
    private void dfs(
            final int[][] image,
            final int x,
            final int y,
            final int target,
            final int newColor) {
        if (inBound(image, x, y) && image[x][y] == target) {
            image[x][y] = newColor;
            dfs(image, x - 1, y, target, newColor);
            dfs(image, x, y - 1, target, newColor);
            dfs(image, x + 1, y, target, newColor);
            dfs(image, x, y + 1, target, newColor);
        }
    }

    private boolean inBound(
            final int[][] image,
            final int x,
            final int y) {
        return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
    }

    /*
    1ms
    public void dfs(int[][] image, int x, int y, int target, int newColor) {
        if (image[x][y] == target) {
            image[x][y] = newColor;
            if (x >= 1) {
                dfs(image, x - 1, y, target, newColor);
            }
            if (y >= 1) {
                dfs(image, x, y - 1, target, newColor);
            }
            if (x + 1 < image.length) {
                dfs(image, x + 1, y, target, newColor);
            }
            if (y + 1 < image[0].length) {
                dfs(image, x, y + 1, target, newColor);
            }
        }
    }
     */
}
