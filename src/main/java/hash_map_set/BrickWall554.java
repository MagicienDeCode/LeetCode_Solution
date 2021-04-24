package hash_map_set;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {
    public int leastBricks(List<List<Integer>> wall) {
        final Map<Integer, Integer> map = new HashMap<>();
        int edge = 0;
        for (final List<Integer> currentWall : wall) {
            int currentSum = 0;
            for (int i = 0; i < currentWall.size() - 1; i++) {
                final int cw = currentWall.get(i);
                currentSum += cw;
                map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
                edge = Math.max(edge, map.get(currentSum));
            }
        }
        return wall.size() - edge;
    }
}
