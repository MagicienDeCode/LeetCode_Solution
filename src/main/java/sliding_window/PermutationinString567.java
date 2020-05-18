package sliding_window;

public class PermutationinString567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }
        final int[] hashArray = new int[26];
        for (int index = 0; index < s1.length(); index++) {
            ++hashArray[s1.charAt(index) - 'a'];
        }
        int count = 0;
        int left = 0;
        for (int index = 0; index < s2.length(); index++) {
            if (--hashArray[s2.charAt(index) - 'a'] >= 0) {
                ++count;
            }
            if (index >= s1.length() && hashArray[s2.charAt(left++) - 'a']++ >= 0) {
                --count;
            }
            if (count == s1.length()) {
                return true;
            }
        }
        return false;
    }

    /*
    public boolean checkInclusion(String s1, String s2) {
        if (s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }
        final int[] hashArray = new int[26];
        for (int index = 0; index < s1.length(); index++) {
            ++hashArray[s1.charAt(index) - 'a'];
            --hashArray[s2.charAt(index) - 'a'];
        }
        if (Arrays.stream(hashArray).filter(i -> i == 0).count() == 26) {
            return true;
        }
        for (int index = 1; index <= s2.length() - s1.length(); index++) {
            ++hashArray[s2.charAt(index - 1) - 'a'];
            --hashArray[s2.charAt(index + s1.length() - 1) - 'a'];
            if (Arrays.stream(hashArray).filter(i -> i == 0).count() == 26) {
                return true;
            }
        }
        return false;
    }
     */
}
