package hash_map_set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        final int[] rowSum = new int[matrix.length];
        final Map<Integer, Integer> hashMap = new HashMap<>();
        for (int col = 0; col < matrix[0].length; col++) {
            Arrays.fill(rowSum, 0);
            for (int currentCol = col; currentCol >= 0; currentCol--) {
                hashMap.clear();
                hashMap.put(0, 1);
                int currentSum = 0;
                for (int row = 0; row < matrix.length; row++) {
                    rowSum[row] += matrix[row][currentCol];
                    currentSum += rowSum[row];
                    if (hashMap.containsKey(currentSum - target)) {
                        count += hashMap.get(currentSum - target);
                    }
                    hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1);
                }
            }
        }
        return count;
    }
}
