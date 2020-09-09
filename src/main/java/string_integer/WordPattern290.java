package string_integer;

import java.util.HashMap;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        final String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        final HashMap<Character, String> csMap = new HashMap<>();
        final HashMap<String, Character> scMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            final Character c = pattern.charAt(i);
            final String s = strings[i];
            if (!csMap.containsKey(c)) {
                if (scMap.containsKey(s)) {
                    return false;
                } else {
                    csMap.put(c, s);
                    scMap.put(s, c);
                }
            } else {
                if (!csMap.get(c).equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}
