package breadth_first_search;

import java.util.*;

public class EmployeeImportance960 {
    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        final Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int result = 0;
        while (!queue.isEmpty()) {
            final Employee current = queue.poll();
            result += current.importance;
            for (int i : current.subordinates) {
                queue.offer(map.get(i));
            }
        }
        return result;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
