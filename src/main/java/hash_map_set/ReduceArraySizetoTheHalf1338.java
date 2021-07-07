package hash_map_set;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceArraySizetoTheHalf1338 {
    public int minSetSize(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        final List<Integer> entries =
                map.values().stream()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());
        final int half = arr.length >> 1;
        int count = 0;
        int current = 0;
        for (int e : entries) {
            current += e;
            ++count;
            if (current >= half) {
                return count;
            }
        }
        return count;
    }
}
