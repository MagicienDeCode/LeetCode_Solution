package string_integer;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            final String sorted = sort(s);
            map.computeIfAbsent(sorted, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
