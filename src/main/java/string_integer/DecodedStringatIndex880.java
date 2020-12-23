package string_integer;

public class DecodedStringatIndex880 {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            final char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }

        return "";
    }
}
