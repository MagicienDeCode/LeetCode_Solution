package string_integer;

public class FindtheDifference389 {
    public char findTheDifference(String s, String t) {
        final int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            --hash[s.charAt(i) - 'a'];
            ++hash[t.charAt(i) - 'a'];
        }
        ++hash[t.charAt(t.length() - 1) - 'a'];
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return '@';
    }
}
