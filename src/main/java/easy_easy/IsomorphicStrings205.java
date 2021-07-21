package easy_easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        return biDirectionalCheck(s, t) && biDirectionalCheck(t, s);
    }

    public boolean biDirectionalCheck(String s, String t) {
        final Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char sChar = s.charAt(i);
            final char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}
