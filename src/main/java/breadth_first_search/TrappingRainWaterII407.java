package breadth_first_search;

import java.util.PriorityQueue;

public class TrappingRainWaterII407 {
    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int trapRainWater(int[][] heightMap) {
        int result = 0;
        int currentLevel = 0;
        final boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < heightMap.length; i++) {
            priorityQueue.offer(new Node(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            priorityQueue.offer(
                    new Node(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1])
            );
            visited[i][heightMap[0].length - 1] = true;
        }

        for (int j = 0; j < heightMap[0].length; j++) {
            priorityQueue.offer(new Node(0, j, heightMap[0][j]));
            visited[0][j] = true;
            priorityQueue.offer(
                    new Node(heightMap.length - 1, j, heightMap[heightMap.length - 1][j])
            );
            visited[heightMap.length - 1][j] = true;
        }
        while (!priorityQueue.isEmpty()) {
            final Node currentNode = priorityQueue.poll();
            currentLevel = Math.max(currentLevel, currentNode.value);
            for (int index = 0; index < 4; index++) {
                final int nextX = currentNode.x + deltaX[index];
                final int nextY = currentNode.y + deltaY[index];
                if (inBound(heightMap, nextX, nextY) &&
                        !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    if (heightMap[nextX][nextY] < currentLevel) {
                        result += currentLevel - heightMap[nextX][nextY];
                    }
                    priorityQueue.offer(new Node(nextX, nextY, heightMap[nextX][nextY]));
                }
            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int value;

        @Override
        public int compareTo(Node node) {
            return Integer.compare(value, node.value);
        }

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
