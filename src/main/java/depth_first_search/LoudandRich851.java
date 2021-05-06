package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;

public class LoudandRich851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // result array, for index i store the person x who has more money than i and has the lowest quiet.
        final int[] resultArray = new int[quiet.length];
        Arrays.fill(resultArray, -1);
        // directional graph
        final ArrayList<Integer>[] graph = new ArrayList[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
        }
        // foreach person use dfs to find the result
        for (int i = 0; i < quiet.length; i++) {
            dfs(graph, i, quiet, resultArray);
        }
        return resultArray;
    }

    // return the lowest quiet for person at index i
    private int dfs(ArrayList<Integer>[] graph, int index, int[] quiet, int[] resultArray) {
        // return the lowest quiet, if != -1 means that we have already calculated it before.
        if (resultArray[index] != -1) {
            return quiet[resultArray[index]];
        }
        // person index
        int result = index;
        int quietMin = quiet[index];
        for (int neighbor : graph[index]) {
            final int neighborQuiet = dfs(graph, neighbor, quiet, resultArray);
            // if one neighbor's quiet < current quiet
            if (quietMin > neighborQuiet) {
                // take the lowest quiet
                quietMin = neighborQuiet;
                // !! here should take resultArray[neighbor] not directly neighbor,
                // for example: for person 3, result is 7 and person 3 is neighbor of person 6,
                // so for person 6, he will take person 7 (resultArray[3])
                result = resultArray[neighbor];
            }
        }
        // assign person to current index
        resultArray[index] = result;
        // but return the lowest quiet
        return quietMin;
    }
}
