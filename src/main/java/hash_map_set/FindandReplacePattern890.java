package hash_map_set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindandReplacePattern890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        final List<String> results = new LinkedList<>();
        for (String w : words) {
            // abb -> ccc && ccc -> abb
            if (canReplace(w, pattern) && canReplace(pattern, w)) {
                results.add(w);
            }
        }
        return results;
    }

    private boolean canReplace(String word, String pattern) {
        final char[] map = new char[26];
        Arrays.fill(map, '&');
        map[pattern.charAt(0) - 'a'] = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            final char w = word.charAt(i);
            final char p = pattern.charAt(i);
            final char mapPtoWChar = map[p - 'a'];
            if (mapPtoWChar == '&') {
                // if not find corresponded char, add it to map
                map[p - 'a'] = w;
            } else {
                // else compare to word
                if (mapPtoWChar != w) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    private boolean canReplace(String word, String pattern) {
        final Map<Character, Character> mapPtoW = new HashMap<>();
        mapPtoW.put(pattern.charAt(0), word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            final char w = word.charAt(i);
            final char p = pattern.charAt(i);
            if (mapPtoW.containsKey(p)) {
                final char mapPtoWChar = mapPtoW.get(p);
                if (mapPtoWChar != w) {
                    return false;
                }
            } else {
                mapPtoW.put(p, w);
            }
        }
        return true;
    }
     */
}
