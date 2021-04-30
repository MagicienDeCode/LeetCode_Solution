package string_integer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        final Set<Integer> set = new HashSet<>();
        final List<Integer> results = new LinkedList<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                final int result = i + j;
                if (!set.contains(result)) {
                    results.add(result);
                    set.add(result);
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return results;
    }
}
