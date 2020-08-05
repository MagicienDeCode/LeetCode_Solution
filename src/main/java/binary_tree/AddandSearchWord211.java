package binary_tree;

public class AddandSearchWord211 {
    private final PrefixTree root = new PrefixTree();

    /**
     * Inserts a word into the trie.
     */
    public void addWord(String word) {
        PrefixTree current = root;
        for (int index = 0; index < word.length(); index++) {
            if (current.getByChar(word.charAt(index)) == null) {
                current.addChar(word.charAt(index), new PrefixTree());
            }
            current = current.getByChar(word.charAt(index));
        }
        current.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, PrefixTree prefixTree) {
        PrefixTree current = prefixTree;
        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) == '.') {
                final String newString = word.substring(index + 1);
                for (char cc = 'a'; cc <= 'z'; cc++) {
                    if (current.getByChar(cc) != null &&
                            search(newString, current.getByChar(cc))) {
                        return true;
                    }
                }
                return false;
            } else if (current.getByChar(word.charAt(index)) != null) {
                current = current.getByChar(word.charAt(index));
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    private static class PrefixTree {
        private static final int SIZE_OF_CHAR = 26;
        private final PrefixTree[] links = new PrefixTree[SIZE_OF_CHAR];

        private boolean isEnd = false;

        public final void addChar(final char c, final PrefixTree prefixTree) {
            this.links[c - 'a'] = prefixTree;
        }

        public final PrefixTree getByChar(final char c) {
            return this.links[c - 'a'];
        }
    }
}
