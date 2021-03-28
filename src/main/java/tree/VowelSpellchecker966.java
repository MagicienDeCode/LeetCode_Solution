package tree;

import java.util.Set;

public class VowelSpellchecker966 {

    private final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    private final PrefixTree root = new PrefixTree();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (String w : wordlist) {
            insert(w);
        }
        final String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = check(queries[i], root);
        }
        return result;
    }

    private String check(String query, PrefixTree tree) {
        final StringBuilder stringBuilder = new StringBuilder();
        PrefixTree current = tree;
        for (int i = 0; i < query.length(); i++) {
            final char q = query.charAt(i);
            // exact match
            if (current.getByChar(q) != null) {
                current = current.getByChar(q);
                stringBuilder.append(q);
                continue;
            }
            // case insensitive
            if (q <= 'Z') {
                final char lower = (char) (q + 32);
                if (current.getByChar(lower) != null) {
                    current = current.getByChar(lower);
                    stringBuilder.append(lower);
                    continue;
                }
            } else {
                final char upper = (char) (q - 32);
                if (current.getByChar(upper) != null) {
                    current = current.getByChar(upper);
                    stringBuilder.append(upper);
                    continue;
                }
            }
            // vowel
            if (VOWELS.contains(q)) {
                final String newQuery = query.substring(i + 1);
                for (char v : VOWELS) {
                    if (current.getByChar(v) != null) {
                        final String result = check(newQuery, current.getByChar(v));
                        if (result.length() == newQuery.length()) {
                            stringBuilder.append(v).append(result);
                            break;
                        }
                    }
                }
            }
            break;
        }
        final String result = stringBuilder.toString();
        return result.length() == query.length() ? result : "";
    }

    private void insert(String word) {
        PrefixTree current = root;
        for (char c : word.toCharArray()) {
            if (current.getByChar(c) == null) {
                current.addChar(c, new PrefixTree());
            }
            current = current.getByChar(c);
        }
        current.isEnd = true;
    }

    static class PrefixTree {
        private final PrefixTree[] lower = new PrefixTree[26];
        private final PrefixTree[] upper = new PrefixTree[26];

        private boolean isEnd = false;

        public final void addChar(final char c, final PrefixTree prefixTree) {
            if (c <= 'Z') {
                this.upper[c - 'A'] = prefixTree;
            } else {
                this.lower[c - 'a'] = prefixTree;
            }
        }

        public final PrefixTree getByChar(final char c) {
            if (c <= 'Z') {
                return this.upper[c - 'A'];
            } else {
                return this.lower[c - 'a'];
            }
        }
    }
}
