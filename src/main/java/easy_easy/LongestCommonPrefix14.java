package easy_easy;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = commonPrefix(result, strs[i]);
        }
        return result;
    }

    private String commonPrefix(String s1, String s2) {
        final int minLen = Math.min(s1.length(), s2.length());
        int common = 0;
        for (int i = 0; i < minLen; i++) {
            common = i;
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            common = ((common + 1) == minLen) ? minLen : common;
        }
        return s1.substring(0, common);
    }
}
