package list_array;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            final int singleCenter = expandAroundCenter(s, i, i);
            final int doubleCenter = expandAroundCenter(s, i, i + 1);
            final int len = Math.max(singleCenter, doubleCenter);
            if (len > end - begin) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
