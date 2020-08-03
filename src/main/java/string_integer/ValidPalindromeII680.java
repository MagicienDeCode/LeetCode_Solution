package string_integer;

public class ValidPalindromeII680 {
    public boolean validPalindrome(String s) {
        for (int index = 0; index <= s.length() / 2; index++) {
            if (s.charAt(index) != s.charAt(s.length() - 1 - index)) {
                return isPalindrome(s, index + 1, s.length() - 1 - index) ||
                        isPalindrome(s, index, s.length() - 2 - index);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        final int mid = start + (end - start) / 2;
        for (int index = start; index <= mid; index++) {
            if (s.charAt(index) != s.charAt(end - index + start)) {
                return false;
            }
        }
        return true;
    }
}
