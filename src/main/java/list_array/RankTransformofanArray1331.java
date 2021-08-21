package list_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformofanArray1331 {
    public int[] arrayRankTransform(int[] arr) {
        final int[] clone = arr.clone();
        Arrays.sort(clone);
        final Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(clone[i])) {
                map.put(clone[i], rank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            clone[i] = map.get(arr[i]);
        }
        return clone;
    }
}
