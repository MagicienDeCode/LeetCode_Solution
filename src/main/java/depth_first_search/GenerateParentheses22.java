package depth_first_search;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        final String[] strs = new String[n * 2];
        for (int i = 0; i < strs.length; i += 2) {
            strs[i] = "(";
        }
        final List<String> results = new LinkedList<>();
        dfs(strs, 1, n, results);
        return results;
    }

    private void dfs(String[] strs, int startIndex, int restRight, List<String> results) {
        if (startIndex == strs.length - 1) {
            strs[startIndex] = ")".repeat(restRight);
            buildAndAdd(strs, results);
            return;
        }

        final int maxRight = startIndex / 2 + 1 - (strs.length / 2 - restRight);
        for (int i = 0; i <= maxRight; i++) {
            strs[startIndex] = ")".repeat(i);
            dfs(strs, startIndex + 2, restRight - i, results);
            strs[startIndex] = "";
        }
    }

    private void buildAndAdd(String[] strs, List<String> results) {
        final StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if (!s.isEmpty()) {
                sb.append(s);
            }
        }
        results.add(sb.toString());
    }
}
