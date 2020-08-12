package string_integer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        final int[] results = new int[rowIndex + 1];
        results[0] = 1;
        for (int row = 1; row <= rowIndex; row++) {
            for (int index = row; index >= 1; index--) {
                results[index] += results[index - 1];
            }
        }
        return Arrays.stream(results).boxed().collect(Collectors.toList());
    }
}
