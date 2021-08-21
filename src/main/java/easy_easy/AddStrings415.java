package easy_easy;

import java.util.Arrays;

public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return addStrings(num2, num1);
        }
        final char[] chars = new char[num2.length() + 1];
        Arrays.fill(chars, '0');
        final StringBuilder sb = new StringBuilder();
        final char[] num1Chars = new StringBuilder(num1).reverse().toString().toCharArray();
        final char[] num2Chars = new StringBuilder(num2).reverse().toString().toCharArray();
        for (int i = 0; i < num1.length(); i++) {
            final boolean flag = verify(num1Chars[i], num2Chars[i], chars[i]);
            final char current = add(num1Chars[i], num2Chars[i], chars[i]);
            chars[i] = current;
            if (flag) {
                chars[i + 1] = '1';
            }
        }
        for (int i = num1.length(); i < num2.length(); i++) {
            final boolean flag = verify('0', num2Chars[i], chars[i]);
            final char current = add('0', num2Chars[i], chars[i]);
            chars[i] = current;
            if (flag) {
                chars[i + 1] = '1';
            }
        }
        if (chars[chars.length - 1] != '0') {
            sb.append(chars[chars.length - 1]);
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private char add(char num1Char, char num2Char, char aChar) {
        final int result = ((num1Char - '0') + (num2Char - '0') + (aChar - '0')) % 10;
        return (char) ('0' + result);
    }

    private boolean verify(char num1Char, char num2Char, char aChar) {
        final int result = ((num1Char - '0') + (num2Char - '0') + (aChar - '0'));
        return result > 9;
    }
}
