package sliding_window;

import java.util.Arrays;

public class LongestSubstringwithAtLeastKRepeatingCharacters395 {

    private int getMaxUniqueLetters(String s) {
        final boolean hash[] = new boolean[26];
        int result = 0;
        for (char c : s.toCharArray()) {
            if (!hash[c - 'a']) {
                ++result;
                hash[c - 'a'] = true;
            }
        }
        return result;
    }

    public int longestSubstring(String s, int k) {
        final char[] chars = s.toCharArray();
        final int[] hash = new int[26];
        final int uniqueLetters = getMaxUniqueLetters(s);
        int result = 0;
        for (int currentUnique = 1; currentUnique <= uniqueLetters; currentUnique++) {
            // reset map
            Arrays.fill(hash, 0);
            int start = 0;
            int end = 0;
            int unique = 0;
            int countAtLeastK = 0;
            while (end < chars.length) {
                // end++
                if (unique <= currentUnique) {
                    final int index = chars[end] - 'a';
                    if (hash[index] == 0) {
                        ++unique;
                    }
                    hash[index]++;
                    if (hash[index] == k) {
                        countAtLeastK++;
                    }
                    ++end;
                } else {
                    final int index = chars[start] - 'a';
                    if (hash[index] == k) {
                        --countAtLeastK;
                    }
                    hash[index]--;
                    if (hash[index] == 0) {
                        unique--;
                    }
                    ++start;
                }
                if (unique == currentUnique && unique == countAtLeastK) {
                    result = Math.max(end - start, result);
                }
            }
        }
        return result;
    }
}
