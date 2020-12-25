package breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverseII1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.isEmpty()) {
            return new int[0];
        }
        int maxLevel = 0;
        int count = 0;
        final List<List<Integer>> tempLists = new ArrayList<>();
        tempLists.add(new ArrayList<>());
        for (int i = 0; i < nums.size(); i++) {
            final List<Integer> currentLevels = nums.get(i);
            for (int j = 0; j < currentLevels.size(); j++) {
                final int target = i + j;
                if (target > maxLevel) {
                    tempLists.add(new ArrayList<>());
                    ++maxLevel;
                    tempLists.get(target).add(currentLevels.get(j));
                } else {
                    tempLists.get(target).add(currentLevels.get(j));
                }
                ++count;
            }
        }
        final int[] result = new int[count];
        int index = 0;
        for (List<Integer> temp : tempLists) {
            Collections.reverse(temp);
            for (int n : temp) {
                result[index++] = n;
            }
        }
        return result;
    }
    // time limit exceeded
    /*
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.isEmpty()) {
            return new int[0];
        }
        int maxLevel = 1;
        int count = 0;
        int maxCol = 1;
        for (int i = 0; i < nums.size(); i++) {
            final List<Integer> currentLevels = nums.get(i);
            for (int j = 0; j < currentLevels.size(); j++) {
                maxLevel = Math.max(maxLevel, i + j + 1);
                ++count;
                maxCol = Math.max(maxCol, j);
            }
        }
        final int[] result = new int[count];
        int index = 0;
        for (int level = 0; level < maxLevel; level++) {
            // calculate head
            int row = level < nums.size() ? level : nums.size() - 1;
            int col = level < nums.size() ? 0 : level - nums.size() + 1;
            while (row >= 0 && col <= maxCol) {
                final List<Integer> currentLevels = nums.get(row);
                if (col <= currentLevels.size() - 1) {
                    result[index++] = currentLevels.get(col);
                }
                row--;
                col++;
            }
        }
        return result;
    }
     */
}
