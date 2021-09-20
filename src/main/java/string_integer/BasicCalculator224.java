package string_integer;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        final char[] chars = s.replaceAll(" ", "").toCharArray();
        final Stack<Boolean> stack = new Stack<>();
        boolean globalOperation = true;
        int result = 0;
        int i = 0;
        while (i < chars.length) {
            boolean current = true;
            char c = chars[i];
            final StringBuilder sb = new StringBuilder();
            while (!Character.isDigit(c)) {
                // take operation type   +5 -6
                if (c == '+' || c == '-') {
                    current = c == '+';
                    c = chars[++i];
                }
                // if ) or (      ))+((+5
                while (c == '(' || c == ')') {
                    if (c == '(') {
                        stack.push(current);
                        globalOperation = (globalOperation && current) || (!globalOperation && !current);
                    } else {
                        final boolean previous = stack.pop();
                        globalOperation = (globalOperation && previous) || (!globalOperation && !previous);
                    }
                    c = chars[++i];
                }
                // take operation type   +(-5   -(-6
                if (c == '+' || c == '-') {
                    current = c == '+';
                    c = chars[++i];
                }
            }
            if (Character.isDigit(c)) {
                sb.append(c);
                while (i < chars.length - 1 && Character.isDigit(chars[i + 1])) {
                    sb.append(chars[++i]);
                }
            }
            // calculate & update final result
            final boolean operation = (globalOperation && current) || (!globalOperation && !current);
            if (sb.length() != 0) {
                final int number = Integer.parseInt(sb.toString());
                result += operation ? number : -number;
            }
            i++;
        }

        return result;
    }
}
