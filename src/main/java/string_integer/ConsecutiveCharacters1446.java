package string_integer;

public class ConsecutiveCharacters1446 {
    public int maxPower(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 1;
        char currentChar = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == currentChar) {
                ++count;
                max = Math.max(max, count);
            } else {
                count = 1;
                currentChar = c;
            }
        }
        return max;
    }
}
