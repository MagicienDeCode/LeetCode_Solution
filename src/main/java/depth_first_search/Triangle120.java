package depth_first_search;

import java.util.Collections;
import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <= r; c++) {
                int value = triangle.get(r).get(c);
                if (c == 0) {
                    value += triangle.get(r - 1).get(c);
                } else if (c == r) {
                    value += triangle.get(r - 1).get(c - 1);
                } else {
                    value += Math.min(triangle.get(r - 1).get(c - 1), triangle.get(r - 1).get(c));
                }
                triangle.get(r).set(c, value);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
    /*
    private List<List<Integer>> triangle;
    private final Map<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        return dfsMemorisation(0, 0);
    }

    private int dfsMemorisation(int r, int c) {
        final String id = r + "&" + c;
        if (map.containsKey(id)) {
            return map.get(id);
        }
        int value = triangle.get(r).get(c);
        if (r < triangle.size() - 1) {
            value += Math.min(dfsMemorisation(r + 1, c), dfsMemorisation(r + 1, c + 1));
        }
        map.put(id, value);
        return value;
    }
     */
}
