package easy_easy;

public class ReverseWordsinaStringIII557 {
    public String reverseWords(String s) {
        final StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append(temp.reverse()).append(' ');
                temp = new StringBuilder();
            } else {
                temp.append(c);
            }
        }
        result.append(temp.reverse());
        return result.toString();
    }
}
