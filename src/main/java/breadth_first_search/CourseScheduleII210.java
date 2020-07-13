package breadth_first_search;

import java.util.*;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<Integer> result = new LinkedList<>();
        final int[] indegrees = new int[numCourses];
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], v -> new ArrayList<>()).add(pre[0]);
            ++indegrees[pre[0]];
        }
        final Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (indegrees[index] == 0) {
                queue.offer(index);
            }
        }
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            result.add(current);
            final List<Integer> preCourses = graph.get(current);
            if (preCourses != null) {
                preCourses.forEach(it -> {
                    if (--indegrees[it] == 0) {
                        queue.offer(it);
                    }
                });
            }
        }
        if (result.size() == numCourses) {
            final int[] resultArray = new int[numCourses];
            for (int index = 0; index < numCourses; index++) {
                resultArray[index] = result.get(index);
            }
            return resultArray;
        }
        return new int[0];
    }
}
