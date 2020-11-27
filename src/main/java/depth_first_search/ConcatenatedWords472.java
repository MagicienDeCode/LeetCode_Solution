package depth_first_search;

import java.util.*;

public class ConcatenatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length <= 1) {
            return Collections.emptyList();
        }
        final Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        final List<String> results = new LinkedList<>();
        for (String word : words) {
            if (dfs(word, set)) {
                results.add(word);
            }
        }
        return results;
    }

    private boolean dfs(String word, Set<String> set) {
        for (int i = 1; i < word.length(); i++) {
            final String now = word.substring(0, i);
            if (set.contains(now)) {
                final String remain = word.substring(now.length());
                if (set.contains(remain) || dfs(remain, set)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    private boolean dfs(String word, int i, Set<String> set, List<String> results) {
        final String now = word.substring(i);
        if (now.length() < 1) {
            return false;
        }
        if (i != 0 && set.contains(now)) {
            results.add(word);
            return true;
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(now.charAt(0));
        for (int j = 1; j < now.length(); j++) {
            if (set.contains(sb.toString())) {
                if (dfs(word, i + j, set, results)) {
                    return true;
                }
            }
            sb.append(now.charAt(j));
        }
        return false;
    }
     */
    /*
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length <= 1) {
            return Collections.emptyList();
        }
        final Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        final List<String> results = new LinkedList<>();
        for (String word : words) {
            set.remove(word);
            if (wordBreak(word, set)) {
                results.add(word);
            }
            set.add(word);
        }
        return results;
    }

    public boolean wordBreak(String s, Set<String> wordSet) {
        if (s.length() == 0) {
            return false;
        }
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
     */
}
