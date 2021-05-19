package easy_easy;

public class DecryptStringfromAlphabettoIntegerMapping1309 {
    public String freqAlphabets(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                final int before = (sb.charAt(sb.length() - 2) - 'a' + 1) * 10 + (sb.charAt(sb.length() - 1) - 'a' + 1);
                sb.setCharAt(sb.length() - 2, (char) ('a' + before - 1));
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append((char) ('a' + Integer.parseInt(String.valueOf(c)) - 1));
            }
        }
        return sb.toString();
    }
}
