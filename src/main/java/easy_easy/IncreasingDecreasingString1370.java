package easy_easy;

public class IncreasingDecreasingString1370 {
    public String sortString(String s) {
        final int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            sb.append(operation1(chars));
            if (sb.length() == s.length()) {
                break;
            }
            sb.append(operation2(chars));
        }
        return sb.toString();
    }

    private String operation2(int[] chars) {
        final StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > 0) {
                sb.append((char) ('a' + i));
                chars[i]--;
            }
        }
        return sb.toString();
    }

    private String operation1(int[] chars) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                sb.append((char) ('a' + i));
                chars[i]--;
            }
        }
        return sb.toString();
    }
}
