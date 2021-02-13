package not_categorized_easy;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty()) {
            return t.isEmpty();
        }
        if (s.length() != t.length()) {
            return false;
        }
        final int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
