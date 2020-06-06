package not_categorized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            }
            return Integer.compare(p2[0], p1[0]);
        });
        final List<int[]> arrayList = new ArrayList<>();
        for (int[] p : people) {
            arrayList.add(p[1], p);
        }
        for (int index = 0; index < people.length; index++) {
            people[index] = arrayList.get(index);
        }
        return people;
    }
}
