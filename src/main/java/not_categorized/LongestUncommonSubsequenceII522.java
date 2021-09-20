package not_categorized;

public class LongestUncommonSubsequenceII522 {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSub(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }


    private boolean isSub(String a, String b) {
        int i = 0;
        for (char c : b.toCharArray()) {
            if (c == a.charAt(i)) {
                i++;
            }
            if (i == a.length()) {
                break;
            }
        }
        return i == a.length();
    }
}
