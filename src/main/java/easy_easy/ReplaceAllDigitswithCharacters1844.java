package easy_easy;

public class ReplaceAllDigitswithCharacters1844 {
    public String replaceDigits(String s) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 1; i < stringBuilder.length(); i += 2) {
            stringBuilder.setCharAt(i, (char) (stringBuilder.charAt(i - 1) + Integer.parseInt(String.valueOf(stringBuilder.charAt(i)))));
        }
        return stringBuilder.toString();
    }
}
