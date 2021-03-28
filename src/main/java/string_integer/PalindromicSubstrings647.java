package string_integer;

public class PalindromicSubstrings647 {
    public int countSubstrings(String s) {
        // 1 for char at index 0
        int result = 1;
        final char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            result += countOdd(chars, i) + countEven(chars, i - 1, i);
        }
        return result;
    }

    private int countEven(char[] chars, int l, int r) {
        int result = 0;
        while (l >= 0 && r <= chars.length - 1) {
            if (chars[l] != chars[r]) {
                return result;
            }
            ++result;
            --l;
            ++r;
        }
        return result;
    }

    private int countOdd(char[] chars, int i) {
        int result = 0;
        int l = i;
        int r = i;
        while (l >= 0 && r <= chars.length - 1) {
            if (chars[l] != chars[r]) {
                return result;
            }
            ++result;
            --l;
            ++r;
        }
        return result;
    }
}
