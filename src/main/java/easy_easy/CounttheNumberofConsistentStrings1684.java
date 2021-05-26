package easy_easy;

public class CounttheNumberofConsistentStrings1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        final boolean[] chars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            chars[c - 'a'] = true;
        }
        int count = 0;
        for (String w : words) {
            if (isValid(w, chars)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isValid(String w, boolean[] chars) {
        for (char c : w.toCharArray()) {
            if (!chars[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
