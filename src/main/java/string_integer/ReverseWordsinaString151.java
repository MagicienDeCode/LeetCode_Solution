package string_integer;

import java.util.LinkedList;
import java.util.List;

public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
        final List<String> list = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                ++index;
            } else {
                final StringBuilder sb = new StringBuilder();
                while (index < s.length() && s.charAt(index) != ' ') {
                    sb.append(s.charAt(index));
                    ++index;
                }
                list.add(sb.toString());
            }
        }
        final StringBuilder result = new StringBuilder();
        final int currentSize = list.size();
        for (int i = currentSize - 1; i >= 0; i--) {
            result.append(list.get(i));
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
