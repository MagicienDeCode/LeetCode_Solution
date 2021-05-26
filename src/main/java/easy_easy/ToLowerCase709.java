package easy_easy;

public class ToLowerCase709 {
    public String toLowerCase(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    /*
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
     */
}
