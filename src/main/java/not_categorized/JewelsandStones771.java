package not_categorized;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones771 {
    public int numJewelsInStones(String strJ, String strS) {
        final Set<Character> jCharSet = new HashSet<>(strJ.length());
        for (int i = 0; i < strJ.length(); i++) {
            jCharSet.add(strJ.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < strS.length(); i++) {
            if (jCharSet.contains(strS.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
