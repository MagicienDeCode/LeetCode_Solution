package not_categorized_easy;

public class RemovePalindromicSubsequences1332 {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return isPalindromic(s) ? 1 : 2;
    }

    private boolean isPalindromic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
