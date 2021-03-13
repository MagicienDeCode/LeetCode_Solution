package bit_operation;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK1461 {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k;
        final Set<String> set = new HashSet<>();
        for (int i = k; i < s.length(); i++) {
            final String current = s.substring(i - k, i);
            if (!set.contains(current)) {
                set.add(current);
                if (--total == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
