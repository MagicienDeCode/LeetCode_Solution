package depth_first_search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters1239 {
    public int maxLength(List<String> arr) {
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int i, String s) {
        final Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (s.length() != set.size()) {
            return 0;
        }

        int best = s.length();
        for (int j = i; j < arr.size(); j++) {
            best = Math.max(best, dfs(arr, j + 1, s + arr.get(j)));
        }
        return best;
    }
}
