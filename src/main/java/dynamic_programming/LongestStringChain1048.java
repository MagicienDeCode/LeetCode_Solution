package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain1048 {
    public int longestStrChain(String[] words) {
        final Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int max = 1;
        for (String word : words) {
            int current = 0;
            for (int i = 0; i < word.length(); i++) {
                final StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.deleteCharAt(i);
                final String pre = stringBuilder.toString();
                final int preLength = map.getOrDefault(pre, 0);
                current = Math.max(current, preLength);
            }
            map.put(word, current + 1);
            max = Math.max(max, current + 1);
        }
        return max;
    }
}
