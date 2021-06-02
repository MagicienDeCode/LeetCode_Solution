package design;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem1268 {

    private final PrefixTree root = new PrefixTree();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // add words to tree
        for (String p : products) {
            addWord(p);
        }
        final List<List<String>> results = new LinkedList<>();
        final StringBuilder sb = new StringBuilder();
        // for each prefix, do dfs
        for (int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            final List<String> lists = new LinkedList<>();
            // search the level that has exactly the prefix
            final PrefixTree prefixTree = searchByPrefix(sb.toString());
            // if cannot find prefix, return empty list
            if (prefixTree == null) {
                results.add(Collections.emptyList());
                continue;
            }
            // dfs to take the first 3 results
            dfs(lists, prefixTree, new StringBuilder(sb.toString()));
            results.add(lists);
        }
        return results;
    }

    private PrefixTree searchByPrefix(String prefix) {
        PrefixTree current = root;
        for (char c : prefix.toCharArray()) {
            if (current.getByChar(c) != null) {
                current = current.getByChar(c);
            } else {
                return null;
            }
        }
        return current;
    }

    private void dfs(List<String> lists, PrefixTree current, StringBuilder sb) {
        if (lists.size() == 3) {
            return;
        }
        if (current.isEnd) {
            lists.add(sb.toString());
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (current.getByChar(c) != null) {
                sb.append(c);
                dfs(lists, current.getByChar(c), sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void addWord(String word) {
        PrefixTree current = root;
        for (char c : word.toCharArray()) {
            if (current.getByChar(c) == null) {
                current.addChar(c, new PrefixTree());
            }
            current = current.getByChar(c);
        }
        current.isEnd = true;
    }

    private static class PrefixTree {
        final PrefixTree[] links = new PrefixTree[26];
        boolean isEnd = false;

        public PrefixTree getByChar(char c) {
            return links[c - 'a'];
        }

        public void addChar(char c, PrefixTree prefixTree) {
            this.links[c - 'a'] = prefixTree;
        }
    }
}
