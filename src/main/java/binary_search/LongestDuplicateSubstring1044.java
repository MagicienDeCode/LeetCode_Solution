package binary_search;

import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring1044 {

    private static final int MODULO = 1000000007;

    public String longestDupSubstring(String str) {
        int left = 1;
        int right = str.length() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (rabinKarp(str, mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        final int rightIndex = rabinKarp(str, right);
        final int leftIndex = rabinKarp(str, left);
        if (rightIndex != -1) {
            return str.substring(rightIndex, rightIndex + right);
        }
        if (leftIndex != -1) {
            return str.substring(leftIndex, leftIndex + left);
        }
        return "";
    }

    // given a string and a target length, return index of duplicate substring
    private int rabinKarp(String source, int target) {
        long pow = 1L;
        for (int time = 0; time < target; time++) {
            pow = (pow * 31) % MODULO;
        }

        // hashcode, index
        final Map<Long, Integer> map = new HashMap<>();
        long currentCode = 0L;
        for (int index = 0; index < source.length(); index++) {
            currentCode = (currentCode * 31 + source.charAt(index)) % MODULO;
            if (index < target - 1) {
                continue;
            }
            //    i
            // abab - a
            if (index >= target) {
                currentCode -= (pow * source.charAt(index - target)) % MODULO;
                currentCode += currentCode < 0 ? MODULO : 0;
            }
            if (map.containsKey(currentCode)) {
                final int result = map.get(currentCode);
                final String str1 = source.substring(result, result + target);
                final String str2 = source.substring(index - target + 1, index + 1);
                if (str1.equals(str2)) {
                    return result;
                }
            }
            map.put(currentCode, index - target + 1);
        }
        return -1;
    }
}
