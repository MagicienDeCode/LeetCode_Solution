package string_integer;

import java.util.LinkedList;
import java.util.List;

public class AmbiguousCoordinates816 {
    public List<String> ambiguousCoordinates(String s) {
        final List<String> results = new LinkedList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            for (String left : make(s, 1, i)) {
                for (String right : make(s, i, s.length() - 1)) {
                    results.add("(" + left + "," + right + ")");
                }
            }
        }
        return results;
    }

    private List<String> make(String s, int i, int j) {
        final List<String> results = new LinkedList<>();
        for (int k = 1; k <= j - i; k++) {
            final String left = s.substring(i, i + k);
            final String right = s.substring(i + k, j);
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                results.add(left + (k < j - 1 ? "." : "") + right);
            }
        }
        return results;
    }
}
