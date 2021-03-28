package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysandRooms841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final boolean[] openRoom = new boolean[rooms.size()];
        openRoom[0] = true;

        final Queue<Integer> queue = new LinkedList<>();
        for (int key : rooms.get(0)) {
            queue.offer(key);
        }

        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int current = queue.poll();
                openRoom[current] = true;
                for (int key : rooms.get(current)) {
                    if (!openRoom[key]) {
                        queue.offer(key);
                    }
                }
            }
        }

        for (boolean open : openRoom) {
            if (!open) {
                return false;
            }
        }
        return true;
    }
}
