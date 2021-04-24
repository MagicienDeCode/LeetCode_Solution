package string_integer;

public class CountBinarySubstrings696 {
    public int countBinarySubstrings(String s) {
        final char[] chars = s.toCharArray();
        int current = 1;
        int previous = 0;
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                ++current;
            } else {
                count += Math.min(current, previous);
                previous = current;
                current = 1;
            }
        }
        return Math.min(current, previous) + count;
    }
}
