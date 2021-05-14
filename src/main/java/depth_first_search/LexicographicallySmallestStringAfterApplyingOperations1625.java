package depth_first_search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations1625 {

    private final char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final Map<Character, Integer> charMap = Map.of(
            '0', 0,
            '1', 1,
            '2', 2,
            '3', 3,
            '4', 4,
            '5', 5,
            '6', 6,
            '7', 7,
            '8', 8,
            '9', 9
    );

    String result = "magiciendecode.fr";

    public String findLexSmallestString(String s, int a, int b) {
        dfs(s, a, b, new HashSet<>());
        return result;
    }

    private void dfs(String s, int a, int b, Set<String> visited) {
        if (s.compareTo(result) < 0) {
            result = s;
        }
        visited.add(s);
        final String applyA = applyA(s, a);
        final String applyB = applyB(s, b);
        if (!visited.contains(applyA)) {
            dfs(applyA, a, b, visited);
        }
        if (!visited.contains(applyB)) {
            dfs(applyB, a, b, visited);
        }
    }

    private String applyB(String s, int b) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        // for each index
        for (int i = 0; i < s.length(); i++) {
            // calculate next index (currentIndex + b)% length and set char
            stringBuilder.setCharAt((i + b) % s.length(), s.charAt(i));
        }
        return stringBuilder.toString();
    }

    private String applyA(String s, int a) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        // for each odd index
        for (int i = 1; i < s.length(); i += 2) {
            // calculate next char, (number of currentIndex + a) % 10
            final char nextChar = chars[(charMap.get(stringBuilder.charAt(i)) + a) % 10];
            // update nextChar to currentIndex
            stringBuilder.setCharAt(i, nextChar);
        }
        return stringBuilder.toString();
    }
}
