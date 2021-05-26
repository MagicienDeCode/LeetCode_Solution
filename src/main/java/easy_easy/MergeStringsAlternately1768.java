package easy_easy;

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        final int minLength = Math.min(word1.length(), word2.length());
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() != minLength) {
            for (int i = minLength; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
            }
        }
        if (word2.length() != minLength) {
            for (int i = minLength; i < word2.length(); i++) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
