package string_integer;

import java.util.Set;

public class GoatLatin824 {
    public String toGoatLatin(String s) {
        final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        final StringBuilder maBuilder = new StringBuilder("ma");
        final StringBuilder result = new StringBuilder();
        for (String each : s.split(" ")) {
            maBuilder.append('a');

            if (!set.contains(each.charAt(0))) {
                each = each.substring(1) + each.charAt(0);
            }

            result.append(each).append(maBuilder.toString()).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
