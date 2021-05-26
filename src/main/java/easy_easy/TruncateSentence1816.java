package easy_easy;

public class TruncateSentence1816 {
    public String truncateSentence(String s, int k) {
        int count = 0;
        int index = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (++count == k) {
                    index = i;
                    break;
                }
            }
        }
        return s.substring(0, index);
    }
}
