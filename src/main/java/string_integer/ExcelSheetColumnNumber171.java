package string_integer;

public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        int base = 26;
        if (s.length() == 1) {
            return s.charAt(0) - '@';
        }
        int result = s.charAt(s.length() - 1) - '@';
        for (int index = s.length() - 2; index >= 0; index--) {
            result += (s.charAt(index) - '@') * base;
            base *= 26;
        }
        return result;
    }
}
