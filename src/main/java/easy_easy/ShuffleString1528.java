package easy_easy;

public class ShuffleString1528 {
    public String restoreString(String s, int[] indices) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.setCharAt(indices[i], s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
