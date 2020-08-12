package string_integer;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) {
            return results;
        }
        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);
        results.add(preRow);
        for (int row = 1; row < numRows; row++) {
            final List<Integer> currentLevel = new ArrayList<>();
            currentLevel.add(1);

            for (int index = 1; index < row; index++) {
                currentLevel.add(preRow.get(index) + preRow.get(index - 1));
            }

            currentLevel.add(1);

            results.add(currentLevel);
            preRow = currentLevel;
        }
        return results;
    }
}
