package list_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        final List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((k1, k2) -> Integer.compare(map.get(k2), map.get(k1)));
        final int[] result = new int[k];
        for (int index = 0; index < k; index++) {
            result[index] = keyList.get(index);
        }
        return result;
    }
}
