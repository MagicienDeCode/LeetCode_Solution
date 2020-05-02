package notcategorized;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones771 {
    public int numJewelsInStones(String J, String S) {
        final Set<Character> jCharSet = new HashSet<>(J.length());
        for (int i = 0; i < J.length(); i++) {
            jCharSet.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jCharSet.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
