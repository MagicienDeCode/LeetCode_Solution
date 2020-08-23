package tree;

public class StreamofCharacters1032 {

    final PrefixTree root = new PrefixTree();
    final StringBuilder stringBuilder = new StringBuilder();

    public StreamofCharacters1032(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        stringBuilder.append(letter);
        PrefixTree current = root;
        for (int index = stringBuilder.length() - 1; index >= 0; index--) {
            if (current.isEnd) {
                return true;
            }
            if (current.getByChar(stringBuilder.charAt(index)) != null) {
                current = current.getByChar(stringBuilder.charAt(index));
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    private void insert(String word) {
        PrefixTree current = root;
        for (int index = word.length() - 1; index >= 0; index--) {
            if (current.getByChar(word.charAt(index)) == null) {
                current.addChar(word.charAt(index), new PrefixTree());
            }
            current = current.getByChar(word.charAt(index));
        }
        current.isEnd = true;
    }

    static class PrefixTree {
        final PrefixTree[] links = new PrefixTree[26];
        boolean isEnd = false;

        public final void addChar(final char c, final PrefixTree prefixTree) {
            this.links[c - 'a'] = prefixTree;
        }

        public PrefixTree getByChar(char c) {
            return links[c - 'a'];
        }
    }

    public static void main(String[] args) {
        StreamofCharacters1032 streamChecker =
                new StreamofCharacters1032(new String[]{"cd", "f", "kl"}); // init the dictionary.
        System.out.println(streamChecker.query('a'));         // return false
        System.out.println(streamChecker.query('b'));        // return false
        System.out.println(streamChecker.query('c'));          // return false
        System.out.println(streamChecker.query('d'));           // return true
    }
}
