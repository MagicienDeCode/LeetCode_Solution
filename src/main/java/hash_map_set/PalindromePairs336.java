package hash_map_set;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairs336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        final Map<String, Integer> map = new HashMap<>();
        final List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            final String current = words[i];
            if (current.isEmpty()) {
                for (int j = 0; j < words.length; j++) {
                    final String str = words[j];
                    if (i != j && isPalindrome(str, 0, str.length() - 1)) {
                        results.add(List.of(i, j));
                        results.add(List.of(j, i));
                    }
                }
                continue;
            }
            final StringBuilder sb = new StringBuilder(current);
            final String reversed = sb.reverse().toString();
            if (map.containsKey(reversed)) {
                final int j = map.get(reversed);
                if (i != j) {
                    results.add(List.of(i, j));
                }
            }
            for (int j = 1; j < reversed.length(); j++) {
                if (isPalindrome(reversed, 0, j - 1)) {
                    final String str = reversed.substring(j);
                    if (map.containsKey(str)) {
                        results.add(List.of(i, map.get(str)));
                    }
                }
                if (isPalindrome(reversed, j, reversed.length() - 1)) {
                    final String str = reversed.substring(0, j);
                    if (map.containsKey(str)) {
                        results.add(List.of(map.get(str), i));
                    }
                }
            }
        }
        return results;
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    /*
    public List<List<Integer>> palindromePairs(String[] words) {
        final List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindromic(words[i] + words[j])) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

    private boolean isPalindromic(String s) {
        final char[] chars = s.toCharArray();
        int left = chars.length % 2 == 1 ? chars.length / 2 : chars.length / 2 - 1;
        int right = chars.length / 2;
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }
     */
}
