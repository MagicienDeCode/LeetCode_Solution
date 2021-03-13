package hash_map_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingofWords820 {
    public int minimumLengthEncoding(String[] words) {
        final Set<String> goods = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                goods.remove(w.substring(i));
            }
        }
        int result = 0;
        for (String w : goods) {
            result += 1 + w.length();
        }
        return result;
    }
}
