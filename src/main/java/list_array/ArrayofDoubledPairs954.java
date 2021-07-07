package list_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayofDoubledPairs954 {
    public boolean canReorderDoubled(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, 1 + map.getOrDefault(a, 0));
        }
        Arrays.sort(arr);
        for (int a : arr) {
            if (map.get(a) == 0) {
                continue;
            }
            final int aa = a < 0 ? a >> 1 : a << 1;
            if (a < 0) {
                if (a % 2 != 0 || map.getOrDefault(aa, 0) <= 0) {
                    return false;
                }
            } else {
                if (map.getOrDefault(aa, 0) <= 0) {
                    return false;
                }
            }
            map.put(a, -1 + map.get(a));
            map.put(aa, -1 + map.get(aa));

        }
        return true;
    }
}
