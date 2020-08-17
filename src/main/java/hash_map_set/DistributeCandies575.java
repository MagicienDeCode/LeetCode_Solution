package hash_map_set;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        final Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
