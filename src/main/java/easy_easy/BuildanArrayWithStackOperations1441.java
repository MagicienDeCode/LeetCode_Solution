package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class BuildanArrayWithStackOperations1441 {
    public List<String> buildArray(int[] target, int n) {
        final List<String> list = new LinkedList<>();
        final int end = Math.min(target[target.length - 1], n);
        int index = 0;
        for (int i = 1; i <= end; i++) {
            list.add("Push");
            if (target[index] == i) {
                ++index;
            } else {
                list.add("Pop");
            }
        }
        return list;
    }
}
