package binary_tree;

public class ImplementTriePrefixTree208 {
    private final PrefixTree root = new PrefixTree();

    /**
     * Initialize your data structure here.
     */
    public ImplementTriePrefixTree208() {

    }

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

    /**
     * Remove a word if exists.
     */
    public void remove(final String word) {
        if (search(word)) {
            recursionRemove(word, 0, root);
        }
    }

    private void recursionRemove(final String word,
                                 final int index,
                                 final PrefixTree prefixTree) {
        if (word.length() - 2 >= 0 && index != word.length() - 2) {
            recursionRemove(word, index + 1, prefixTree.getByChar(word.charAt(index)));
        }
        final PrefixTree current = prefixTree.getByChar(word.charAt(index));
        if (index + 1 < word.length()) {
            final PrefixTree next = current.getByChar(word.charAt(index + 1));
            if (next.canDelete()) {
                current.remove(word.charAt(index + 1));
            }
        }
        if (index == 0 && current.canDelete()) {
            prefixTree.remove(word.charAt(0));
        }
    }

    // x -> i -> a -> n -> g
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

        public final boolean canDelete() {
            for (PrefixTree p : links) {
                if (p != null) {
                    return false;
                }
            }
            return true;
        }

        public final void remove(char c) {
            this.links[c - 'a'] = null;
        }
    }

    public static void main(String[] args) {
        final ImplementTriePrefixTree208 solution = new ImplementTriePrefixTree208();
        solution.insert("apple");
        System.out.println(solution.search("apple"));    // true
        System.out.println(solution.search("app"));  // false
        System.out.println(solution.startsWith("app"));  // true
        solution.insert("appxiang");
        solution.remove("apple");
        System.out.println(solution.search("appxiang")); // true
        solution.remove("appxiang");
        System.out.println(solution.startsWith("app"));    // false
        System.out.println(solution.startsWith("a")); // false
    }
}
