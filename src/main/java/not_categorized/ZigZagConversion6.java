package not_categorized;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        final StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if (index == 0 || index == numRows - 1) {
                flag = !flag;
            }
            index += flag ? 1 : -1;
        }
        final StringBuilder result = sbs[0];
        for (int i = 1; i < sbs.length; i++) {
            result.append(sbs[i]);
        }
        return result.toString();
    }
}
