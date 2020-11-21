package string_integer;

public class DecodeString394 {
    int i = 0;

    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        final StringBuilder result = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            final char c = s.charAt(i);
            if (c < '0' || c > '9') {
                result.append(c);
                ++i;
            } else {
                int count = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count = count * 10 + Integer.parseInt(String.valueOf(s.charAt(i++)));
                }
                i++;
                final String repeated = decode(s);
                i++;
                while (count > 0) {
                    result.append(repeated);
                    --count;
                }
            }
        }
        return result.toString();
    }
}
