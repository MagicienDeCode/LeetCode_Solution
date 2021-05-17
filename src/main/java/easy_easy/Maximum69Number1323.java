package easy_easy;

public class Maximum69Number1323 {
    public int maximum69Number(int num) {
        final StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '6') {
                stringBuilder.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
