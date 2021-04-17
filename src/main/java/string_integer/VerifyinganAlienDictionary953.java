package string_integer;

public class VerifyinganAlienDictionary953 {
    public boolean isAlienSorted(String[] words, String order) {
        final int[] hash = new int[26];
        for (int i = 0; i < order.length(); i++) {
            hash[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            final String w1 = words[i - 1];
            final String w2 = words[i];
            if (!compare(w1, w2, hash)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String w1, String w2, int[] hash) {
        final int min = Math.min(w1.length(), w2.length());
        for (int j = 0; j < min; j++) {
            final int hash1 = hash[w1.charAt(j) - 'a'];
            final int hash2 = hash[w2.charAt(j) - 'a'];
            if (hash1 > hash2) {
                return false;
            }
            if (hash1 < hash2) {
                return true;
            }
        }
        return w1.length() <= min;
    }
}
