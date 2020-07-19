package string_integer;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            return addBinary(b, a);
        }
        final int diff = b.length() - a.length();
        int next = 0;
        final StringBuilder result = new StringBuilder();
        for (int index = a.length() - 1; index >= 0; index--) {
            final int currentA = Integer.parseInt(a.charAt(index) + "");
            final int currentB = Integer.parseInt(b.charAt(index + diff) + "");
            switch (currentA + currentB + next) {
                case 0:
                    result.append(0);
                    break;
                case 1:
                    result.append(1);
                    next = 0;
                    break;
                case 2:
                    result.append(0);
                    next = 1;
                    break;
                case 3:
                    result.append(1);
                    next = 1;
                    break;
            }
        }
        for (int index = diff - 1; index >= 0; index--) {
            final int currentB = Integer.parseInt(b.charAt(index) + "");
            switch (currentB + next) {
                case 0:
                    result.append(0);
                    break;
                case 1:
                    result.append(1);
                    next = 0;
                    break;
                case 2:
                    result.append(0);
                    next = 1;
                    break;
            }
        }
        if (next == 1) {
            result.append(next);
        }
        return result.reverse().toString();
    }
}
