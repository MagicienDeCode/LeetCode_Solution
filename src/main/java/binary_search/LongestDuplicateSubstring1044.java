package binary_search;

public class LongestDuplicateSubstring1044 {

    private String str;

    private static class TrieNode {
        private TrieNode[] links;
        private final int position;
        private final int depth;

        public TrieNode(int position, int depth) {
            this.position = position;
            this.depth = depth;
        }
    }

    public String longestDupSubstring(String s) {
        this.str = s;
        int maxStart = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < s.length(); i++) {
            final int length = addNew(root, i);
            if (length > maxLength) {
                maxLength = length;
                maxStart = i;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    private int addNew(final TrieNode node, final int length) {
        final int depth = node.depth;
        if (length + depth == str.length()) return depth;
        if (node.links == null) {
            node.links = new TrieNode[26];
            node.links[str.charAt(node.position + node.depth) - 'a'] = new TrieNode(node.position, depth + 1);
        }
        final int nextNodeIndex = str.charAt(length + node.depth) - 'a';
        TrieNode nextNode = node.links[nextNodeIndex];
        if (nextNode == null) {
            node.links[nextNodeIndex] = new TrieNode(length, depth + 1);
            return depth;
        }
        return addNew(nextNode, length);
    }
    /*
    private static final int MODULO = 1000000007;

    public String longestDupSubstring(String str) {
        int left = 1;
        int right = str.length() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (rabinKarp(str, mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        final int rightIndex = rabinKarp(str, right);
        final int leftIndex = rabinKarp(str, left);
        if (rightIndex != -1) {
            return str.substring(rightIndex, rightIndex + right);
        }
        if (leftIndex != -1) {
            return str.substring(leftIndex, leftIndex + left);
        }
        return "";
    }

    // given a string and a target length, return index of duplicate substring
    private int rabinKarp(String source, int target) {
        long pow = 1L;
        for (int time = 0; time < target; time++) {
            pow = (pow * 31) % MODULO;
        }

        // hashcode, index
        final Map<Long, Integer> map = new HashMap<>();
        long currentCode = 0L;
        for (int index = 0; index < source.length(); index++) {
            currentCode = (currentCode * 31 + source.charAt(index)) % MODULO;
            if (index < target - 1) {
                continue;
            }
            //    i
            // abab - a
            if (index >= target) {
                currentCode -= (pow * source.charAt(index - target)) % MODULO;
                currentCode += currentCode < 0 ? MODULO : 0;
            }
            if (map.containsKey(currentCode)) {
                final int result = map.get(currentCode);
                final String str1 = source.substring(result, result + target);
                final String str2 = source.substring(index - target + 1, index + 1);
                if (str1.equals(str2)) {
                    return result;
                }
            }
            map.put(currentCode, index - target + 1);
        }
        return -1;
    }
     */
}
