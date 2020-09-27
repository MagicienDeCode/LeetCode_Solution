package graph;

import javafx.util.Pair;

import java.util.*;

public class EvaluateDivision399 {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {
        final HashMap<String, List<String>> graph = new HashMap<>();
        final HashMap<String, Double> sideValues = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            graph.computeIfAbsent(equations.get(i).get(0), v -> new ArrayList<>()).add(equations.get(i).get(1));
            graph.computeIfAbsent(equations.get(i).get(1), v -> new ArrayList<>()).add(equations.get(i).get(0));
            sideValues.put(equations.get(i).get(0) + equations.get(i).get(1), values[i]);
            sideValues.put(equations.get(i).get(1) + equations.get(i).get(0), 1.0 / values[i]);
        }

        final double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = bfs(graph, sideValues, queries.get(i));
        }
        return results;
    }

    private double bfs(
            HashMap<String, List<String>> graph,
            HashMap<String, Double> sideValues,
            List<String> query
    ) {
        final String start = query.get(0);
        final String end = query.get(1);
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        final Queue<Pair<String, Double>> queue = new LinkedList<>();
        final HashSet<String> visited = new HashSet<>();
        queue.offer(new Pair<>(start, 1.0));
        visited.add(start);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final Pair<String, Double> current = queue.poll();
                final String currentString = current.getKey();
                final Double currentValue = current.getValue();
                if (currentString.equals(end)) {
                    return currentValue;
                }
                if (graph.containsKey(currentString)) {
                    for (String next : graph.get(currentString)) {
                        if (!visited.contains(next)) {
                            queue.offer(new Pair<>(next, currentValue * sideValues.get(currentString + next)));
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return -1.0;
    }
}
