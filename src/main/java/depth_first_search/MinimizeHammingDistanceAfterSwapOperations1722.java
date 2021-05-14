package depth_first_search;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        final int[] unionFindArray = new int[100001];
        for (int i = 1; i < unionFindArray.length; i++) {
            unionFindArray[i] = i;
        }
        for (int[] allow : allowedSwaps) {
            unionFindArray[unionFind(unionFindArray, allow[0])] = unionFind(unionFindArray, allow[1]);
        }
        int count = 0;
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            final int value = unionFind(unionFindArray, i);
            if (map.containsKey(value)) {
                final Map<Integer, Integer> originalValueCountMap = map.get(value);
                originalValueCountMap.put(source[i], originalValueCountMap.getOrDefault(source[i], 0) + 1);
            } else {
                final Map<Integer, Integer> originalValueCountMap = new HashMap<>();
                originalValueCountMap.put(source[i], 1);
                map.put(value, originalValueCountMap);
            }
        }
        for (int i = 0; i < target.length; i++) {
            final int value = unionFind(unionFindArray, i);
            if (map.containsKey(value) && map.get(value).containsKey(target[i]) && map.get(value).get(target[i]) > 0) {
                ++count;
                final Map<Integer, Integer> originalValueCountMap = map.get(value);
                originalValueCountMap.put(target[i], originalValueCountMap.get(target[i]) - 1);
            }
        }
        return source.length - count;
    }

    private int unionFind(int[] array, int target) {
        return array[target] == target ? target : unionFind(array, array[target]);
    }
}
