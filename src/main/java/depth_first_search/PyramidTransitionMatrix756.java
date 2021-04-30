package depth_first_search;

import java.util.List;

public class PyramidTransitionMatrix756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        final int[][] pyramid = new int[8][8];
        // if BCD, the depth is 2, so depth = bottom.length() - 1
        final int depth = bottom.length() - 1;
        // convert char to int, then fill the bottom of pyramid
        for (int i = 0; i < bottom.length(); i++) {
            pyramid[depth][i] = bottom.charAt(i) - 'A';
        }
        // 3 dimensional array to store allowed
        final boolean[][][] candidates = new boolean[7][7][7];
        // A -> 0, B -> 1, c -> 2 ...
        for (String a : allowed) {
            candidates[a.charAt(0) - 'A'][a.charAt(1) - 'A'][a.charAt(2) - 'A'] = true;
        }
        // dfs to solve pyramid
        return dfs(pyramid, depth, 0, candidates);
    }

    private boolean dfs(int[][] pyramid, int depth, int index, boolean[][][] candidates) {
        // end condition, if we can reach the top of pyramid, return true
        if (depth == 0 && index == 0) {
            return true;
        }
        // depth == index means that we finish this level, now go to level - 1
        if (depth == index) {
            return dfs(pyramid, depth - 1, 0, candidates);
        }
        // foreach index, we retrieve the itself and the int after it.
        final int first = pyramid[depth][index];
        final int second = pyramid[depth][index + 1];
        // check whether we could find the third char(represent by int) in candidates
        for (int i = 0; i < 7; i++) {
            if (candidates[first][second][i]) {
                // if found, set it to the position [level - 1][index]
                pyramid[depth - 1][index] = i;
                // then dfs, if return true, it means we could reach the top, else try other possibility
                if (dfs(pyramid, depth, index + 1, candidates)) {
                    return true;
                }
            }
        }
        return false;
    }
}
