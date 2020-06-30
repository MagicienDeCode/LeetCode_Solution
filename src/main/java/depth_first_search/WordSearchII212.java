package depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII212 {
    final HashSet<String> result = new HashSet<>();
    final TriePrefixTree208 prefixTree = new TriePrefixTree208();

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) {
            prefixTree.insert(w);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (prefixTree.root.getByChar(board[i][j]) != null) {
                    dfs(board,
                            i,
                            j,
                            prefixTree.root.getByChar(board[i][j]),
                            String.valueOf(board[i][j]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    private void dfs(
            final char[][] board,
            final int x,
            final int y,
            final TriePrefixTree208.PrefixTree current,
            final String str) {
        if (current.isEnd) {
            result.add(str);
            prefixTree.remove(str);
        }
        final char value = board[x][y];
        board[x][y] = '*';
        for (int index = 0; index < deltaX.length; index++) {
            final int nextX = x + deltaX[index];
            final int nextY = y + deltaY[index];

            if (inBound(board, nextX, nextY)) {
                final char nextChar = board[nextX][nextY];
                if (nextChar != '*' && current.getByChar(nextChar) != null) {
                    dfs(board, nextX, nextY, current.getByChar(nextChar), str + nextChar);
                }
            }
        }
        board[x][y] = value;
    }

    public static class TriePrefixTree208 {
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
    }
}
