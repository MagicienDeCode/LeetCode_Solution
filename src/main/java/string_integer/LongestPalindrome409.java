package string_integer;

class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        final int[] count = new int[128];
        for (char c : s.toCharArray()) {
            ++count[c];
        }
        int result = 0;
        for (int it : count) {
            result += (it >> 1) << 1;
            if (result % 2 == 0 && it % 2 == 1) {
                ++result;
            }
        }
        return result;
    }
}