package not_categorized;

public class MaximumProductofWordLengths318 {
    public int maxProduct(String[] words) {
        final int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            final String currentStr = words[i];
            int bit = 0;
            for (char c : currentStr.toCharArray()) {
                bit |= 1 << (c - 'a');
            }
            bits[i] = bit;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    /*
    public int maxProduct(String[] words) {
        final boolean[][] hash26 = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            hash26[i] = count(words[i]);
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (doNotShareCommonChars(hash26, i, j)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean doNotShareCommonChars(boolean[][] hash26, int i, int j) {
        final boolean[] iHash = hash26[i];
        final boolean[] jHash = hash26[j];
        for (int k = 0; k < 26; k++) {
            if (iHash[k] && jHash[k]) {
                return false;
            }
        }
        return true;
    }

    private boolean[] count(String word) {
        final boolean[] hash = new boolean[26];
        for (char c : word.toCharArray()) {
            hash[c - 'a'] = true;
        }
        return hash;
    }
     */
}
