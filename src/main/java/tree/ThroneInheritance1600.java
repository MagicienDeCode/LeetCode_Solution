package tree;

import java.util.*;

public class ThroneInheritance1600 {

    private final Map<String, List<String>> graph = new HashMap<>();
    private final HashSet<String> deaths = new HashSet<>();
    private final String king;

    public ThroneInheritance1600(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        graph.computeIfAbsent(parentName, v -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        deaths.add(name);
    }

    public List<String> getInheritanceOrder() {
        final List<String> results = new LinkedList<>();
        dfs(king, results);
        return results;
    }

    private void dfs(String current, List<String> results) {
        if (!deaths.contains(current)) {
            results.add(current);
        }
        if (graph.containsKey(current)) {
            for (String child : graph.get(current)) {
                dfs(child, results);
            }
        }
    }
}
