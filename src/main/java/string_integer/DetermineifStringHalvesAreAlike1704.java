package string_integer;

import java.util.Set;

public class DetermineifStringHalvesAreAlike1704 {
    public boolean halvesAreAlike(String s) {
        final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) {
                ++count1;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                ++count2;
            }
        }
        return count1 == count2;
    }
}
