package depth_first_search;

import java.util.*;

public class LetterCombinationsofaPhoneNumber17 {
    private static final Map<Character, List<String>> map = Map.of(
            '1', Collections.emptyList(),
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.isEmpty()) {
            return results;
        }
        for (char d : digits.toCharArray()) {
            final List<String> currentResult = new ArrayList<>();
            for (String s : map.get(d)) {
                if (results.isEmpty()) {
                    currentResult.add(s);
                } else {
                    for (String pre : results) {
                        currentResult.add(pre + s);
                    }
                }
            }
            results = currentResult;
        }
        return results;
    }

    /*
    public List<String> letterCombinations(String digits) {
        final List<String> results = new ArrayList<>();
        if (digits.isEmpty()) {
            return results;
        }
        final StringBuilder subsets = new StringBuilder();
        dfs(digits.toCharArray(), 0, results, subsets);
        return results;
    }

    private void dfs(char[] charArray, int startIndex, List<String> results, StringBuilder subsets) {
        if (subsets.length() == charArray.length) {
            results.add(subsets.toString());
        } else {
            for (String s : map.get(charArray[startIndex])) {
                subsets.append(s);
                dfs(charArray, 1 + startIndex, results, subsets);
                subsets.deleteCharAt(subsets.length() - 1);
            }
        }
    }
     */
}
