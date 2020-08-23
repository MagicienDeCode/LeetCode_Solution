package tree;


public class ImplementTriePrefixTree208 {
    private final PrefixTree root = new PrefixTree();

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
        PrefixTree current = root;
        for (int index = 0; index < word.length(); index++) {
            if (current.getByChar(word.charAt(index)) != null) {
                current = current.getByChar(word.charAt(index));
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        PrefixTree current = root;
        for (int index = 0; index < prefix.length(); index++) {
            if (current.getByChar(prefix.charAt(index)) != null) {
                current = current.getByChar(prefix.charAt(index));
            } else {
                return false;
            }
        }
        return true;
    }

    // x -> i -> a -> n -> g
    private static class PrefixTree {
        private static final int SIZE_OF_CHAR = 26;
        private final PrefixTree[] links = new PrefixTree[SIZE_OF_CHAR];

        private boolean isEnd = false;

        public void addChar(char c, PrefixTree prefixTree) {
            this.links[c - 'a'] = prefixTree;
        }

        public PrefixTree getByChar(char c) {
            return this.links[c - 'a'];
        }
    }
}