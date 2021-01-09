package depth_first_search;

import java.util.*;

public class AccountsMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final Map<String, List<String>> graph = new HashMap<>();
        final Map<String, String> mailToName = new HashMap<>();
        // build Graph
        for (List<String> nameAccounts : accounts) {
            final String firstEmail = nameAccounts.get(1);
            final String name = nameAccounts.get(0);
            mailToName.put(firstEmail, name);
            for (int i = 2; i < nameAccounts.size(); i++) {
                final String mail = nameAccounts.get(i);
                graph.computeIfAbsent(firstEmail, v -> new ArrayList<>()).add(mail);
                graph.computeIfAbsent(mail, v -> new ArrayList<>()).add(firstEmail);
            }
        }
        // dfs
        final List<List<String>> results = new LinkedList<>();
        final Set<String> visited = new HashSet<>();
        for (Map.Entry<String, String> mailNameEntry : mailToName.entrySet()) {
            if (visited.contains(mailNameEntry.getKey())) {
                continue;
            }
            final List<String> currentResult = new LinkedList<>();
            dfs(currentResult, mailNameEntry.getKey(), graph, visited);
            // sort email
            Collections.sort(currentResult);
            currentResult.add(0, mailNameEntry.getValue());
            results.add(currentResult);
        }
        return results;
    }

    private void dfs(
            List<String> currentResult,
            String mail,
            Map<String, List<String>> graph,
            Set<String> visited
    ) {
        currentResult.add(mail);
        visited.add(mail);
        if (graph.containsKey(mail)) {
            for (String neighbor : graph.get(mail)) {
                if (!visited.contains(neighbor)) {
                    dfs(currentResult, neighbor, graph, visited);
                }
            }
        }
    }
}
