package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] coursesArray = new int[numCourses];
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], v -> new ArrayList<>()).add(pre[0]);
        }
        for (int index = 0; index < numCourses; index++) {
            if (!dfs(index, coursesArray, graph)) {
                return false;
            }
        }
        return true;
    }

    // true -> can finish
    private boolean dfs(
            final int current,
            final int[] coursesArray,
            final Map<Integer, List<Integer>> graph
    ) {
        if (coursesArray[current] == -1) {
            return false;
        }
        if (coursesArray[current] == 1) {
            return true;
        }
        coursesArray[current] = -1;
        final List<Integer> preCourses = graph.get(current);
        if (preCourses != null) {
            for (int preCourse : preCourses) {
                if (!dfs(preCourse, coursesArray, graph)) {
                    return false;
                }
            }
        }
        coursesArray[current] = 1;
        return true;
    }
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] coursesArray = new int[numCourses];
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], v -> new ArrayList<>()).add(pre[0]);
            ++coursesArray[pre[0]];
        }
        final Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (coursesArray[index] == 0) {
                queue.offer(index);
            }
        }
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            final List<Integer> preCourses = graph.get(current);
            if (preCourses != null) {
                preCourses.forEach(it -> {
                    if (--coursesArray[it] == 0) {
                        queue.offer(it);
                    }
                });
            }
        }

        for (int c : coursesArray) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
     */
}
