package dynamic_programming;

import java.util.Arrays;

public class DungeonGame174 {
    public int calculateMinimumHP(int[][] dungeon) {
        final int[] dynamicProgramming = new int[dungeon[0].length + 1];
        Arrays.fill(dynamicProgramming, Integer.MAX_VALUE);
        dynamicProgramming[dynamicProgramming.length - 1] = 1;
        for (int i = dungeon.length - 1; i >= 0; i--) {
            if (dynamicProgramming[dynamicProgramming.length - 1] == 1 && i != dungeon.length - 1) {
                dynamicProgramming[dynamicProgramming.length - 1] = Integer.MAX_VALUE;
            }
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                dynamicProgramming[j] = Math.max(1, Math.min(
                        dynamicProgramming[j], dynamicProgramming[j + 1]
                ) - dungeon[i][j]);
            }
        }
        return dynamicProgramming[0];
    }
}
