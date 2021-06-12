package easy_easy;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualbyReversingSubarrays1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int t : target) {
            map.put(t, 1 + map.getOrDefault(t, 0));
        }
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) - 1);
        }
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
