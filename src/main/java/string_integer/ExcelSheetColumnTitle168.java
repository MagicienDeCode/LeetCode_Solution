package string_integer;

public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        final StringBuilder resultBuilder = new StringBuilder();
        while (n != 0) {
            resultBuilder.append((char) ((--n % 26) + 65));
            n /= 26;
        }
        return resultBuilder.reverse().toString();
    }
}
