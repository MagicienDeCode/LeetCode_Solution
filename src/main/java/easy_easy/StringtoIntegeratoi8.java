package easy_easy;

import java.util.Set;

public class StringtoIntegeratoi8 {
    public int myAtoi(String s) {
        final String str = s.trim();
        if (str.length() == 0) {
            return 0;
        }
        final Set<Character> set = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        boolean negative = str.charAt(0) == '-';
        int index = 0;
        int result = 0;
        int previous;
        if (negative || str.charAt(0) == '+') {
            ++index;
        }
        while (index < str.length() && set.contains(str.charAt(index))) {
            previous = result;
            result = result * 10 + (str.charAt(index) - '0');
            ++index;
            if (result / 10 != previous) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return negative ? -result : result;
    }
}
