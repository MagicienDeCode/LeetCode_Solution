package string_integer;

public class BuddyStrings859 {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        final int[] hash = new int[26];
        if (a.equals(b)) {
            // if a == b, the only case return true is that a has two identical letters
            for (int i = 0; i < a.length(); i++) {
                final char ai = a.charAt(i);
                // if found two same letters, return true
                if (hash[ai - 'a'] > 0) {
                    return true;
                }
                ++hash[ai - 'a'];
            }
            return false;
        } else {
            // a != b, the only case is we have two index that a[i] != b[i],
            // but ignore the order, all lettres in a and b should be the same.
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                final char ai = a.charAt(i);
                final char bi = b.charAt(i);
                if (ai != bi) {
                    ++hash[ai - 'a'];
                    --hash[bi - 'a'];
                    ++count;
                }
            }
            // count must be 2 so that we could swap index i and index j
            if (count != 2) {
                return false;
            }
            // a and b should have the same letters
            for (int h : hash) {
                if (h != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
