package binary_search;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII264 {
    /*
    (1) (1x2),  2x2, (2x2), (3x2), 3x2, (4x2), 5x2...
    (2) 1x3,  (1x3), 2x3, (2x3), 2x3, 3x3, (3x3)...
    (3) 1x5,  1x5, 1x5, (1x5), 2x5, 2x5, 2x5...
     */
    public int nthUglyNumber(int n) {
        final List<Integer> list = new ArrayList<>();
        int int1 = 0;
        int int2 = 0;
        int int3 = 0;
        list.add(1);
        while (list.size() < n) {
            final int new1 = list.get(int1) * 2;
            final int new2 = list.get(int2) * 3;
            final int new3 = list.get(int3) * 5;
            final int min = Math.min(new1, Math.min(new2, new3));
            if (min == new1) {
                ++int1;
            }
            if (min == new2) {
                ++int2;
            }
            if (min == new3) {
                ++int3;
            }
            list.add(min);
        }
        return list.get(n - 1);
    }
}
