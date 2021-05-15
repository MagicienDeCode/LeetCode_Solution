package string_integer;

public class ValidNumber65 {
    public boolean isNumber(String s) {
        int point = -1;
        int e = -1;
        // ensure that s has at most one . and one E/e
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);
            if (currentChar == '.') {
                if (point == -1) {
                    point = i;
                } else {
                    return false;
                }
            }
            if (currentChar == 'e' || currentChar == 'E') {
                if (e == -1) {
                    e = i;
                } else {
                    return false;
                }
            }
        }
        // full integer
        if (point == -1 && e == -1) {
            return isInteger(s);
        }
        // decimal + E/e + integer
        if (point != -1 && e != -1) {
            if (e < point) {
                return false;
            }
            return isDecimal(s.substring(0, e)) && isInteger(s.substring(e + 1));
        }
        // full decimal
        if (point != -1) {
            return isDecimal(s);
        }
        // integer + E/e + integer
        return isInteger(s.substring(0, e)) && isInteger(s.substring(e + 1));
    }

    private boolean isDecimal(String s) {
        // at least 2 chars, for example .7 or 7.
        if (s.length() < 2) {
            return false;
        }
        // if the first element is digit, count++ and it could be a point
        final boolean digit = Character.isDigit(s.charAt(0));
        int count = 0;
        if (!digit) {
            final int firstChar = s.charAt(0);
            if (!(firstChar == '+' || firstChar == '-' || firstChar == '.')) {
                return false;
            }
        } else {
            ++count;
        }
        // if given string has at least one digit ==> valid
        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            } else {
                if (s.charAt(i) != '.') {
                    return false;
                }
            }
        }
        return count > 0;
    }

    private boolean isInteger(String s) {
        // can NOT be empty
        if (s.length() < 1) {
            return false;
        }
        // first element could be + or -
        final boolean digit = Character.isDigit(s.charAt(0));
        if (s.length() == 1) {
            return digit;
        }
        if (!digit) {
            if (!(s.charAt(0) == '+' || s.charAt(0) == '-')) {
                return false;
            }
        }
        // from index 1, all element should be digit
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
