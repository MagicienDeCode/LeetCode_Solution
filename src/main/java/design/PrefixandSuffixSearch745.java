package design;

import java.util.ArrayList;
import java.util.List;

public class PrefixandSuffixSearch745 {
    private final PrefixTree root = new PrefixTree();

    public PrefixandSuffixSearch745(String[] words) {
        for (int i = 0; i < words.length; i++) {
            final List<String> suffixWords = build(words[i]);
            for (final String w : suffixWords) {
                insert(w, i);
            }
        }
    }

    private List<String> build(final String word) {
        final List<String> results = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.insert(0, word.charAt(i));
            results.add(sb + "#" + word);
        }
        return results;
    }

    public int f(String prefix, String suffix) {
        return search(suffix + "#" + prefix);
    }

    public void insert(final String word, final int index) {
        PrefixTree current = root;
        for (char c : word.toCharArray()) {
            if (current.getByChar(c) == null) {
                current.addChar(c, new PrefixTree());
            }
            current.index = index;
            current = current.getByChar(c);
        }
        current.index = index;
    }

    public int search(final String word) {
        PrefixTree current = root;
        for (char c : word.toCharArray()) {
            if (current.getByChar(c) != null) {
                current = current.getByChar(c);
            } else {
                return -1;
            }
        }
        return current.index;
    }

    private static class PrefixTree {
        private final PrefixTree[] links = new PrefixTree[26];
        private PrefixTree separator = null;
        private int index = -1;

        public void addChar(char c, PrefixTree prefixTree) {
            if (c == '#') {
                separator = prefixTree;
            } else {
                this.links[c - 'a'] = prefixTree;
            }
        }

        public PrefixTree getByChar(char c) {
            if (c == '#') {
                return separator;
            } else {
                return this.links[c - 'a'];
            }
        }
    }
}
