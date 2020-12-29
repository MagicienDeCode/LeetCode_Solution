package depth_first_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ConcatenatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // prefix tree root
        final PrefixTree root = new PrefixTree();
        // determine if we have iterated a char
        final boolean[] contains = new boolean[26];
        Arrays.sort(words, Comparator.comparing(String::length));
        final List<String> results = new LinkedList<>();

        for (String w : words) {
            // if visited words can NOT cover the current word, skip the verification
            boolean hasAllChars = true;
            for (char c : w.toCharArray()) {
                if (!contains[c - 'a']) {
                    hasAllChars = false;
                    break;
                }
            }
            if (hasAllChars && isValid(root, w, 0, 0)) {
                results.add(w);
            }
            // insert word to prefix tree
            insert(root, w, contains);
        }
        return results;
    }

    private boolean isValid(
            final PrefixTree root,
            final String word,
            int startIndex,
            int count
    ) {
        if (startIndex == word.length()) {
            return count > 1;
        }
        PrefixTree current = root;
        for (int i = startIndex; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (current.getByChar(c) != null) {
                current = current.getByChar(c);
                if (current.isEnd && isValid(root, word, i + 1, count + 1)) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private void insert(final PrefixTree root, final String words, final boolean[] contains) {
        PrefixTree current = root;
        for (char c : words.toCharArray()) {
            contains[c - 'a'] = true;
            if (current.getByChar(c) == null) {
                current.addChar(c, new PrefixTree());
            }
            current = current.getByChar(c);
        }
        current.isEnd = true;
    }

    static class PrefixTree {
        private final PrefixTree[] links = new PrefixTree[26];
        private boolean isEnd;

        public void addChar(char c, PrefixTree prefixTree) {
            this.links[c - 'a'] = prefixTree;
        }

        public PrefixTree getByChar(char c) {
            return this.links[c - 'a'];
        }
    }

      /* Time Limit Exceeded
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
