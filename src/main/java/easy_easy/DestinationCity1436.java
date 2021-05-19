package easy_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DestinationCity1436 {
    public String destCity(List<List<String>> paths) {
        final Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> path : paths) {
            map.computeIfAbsent(path.get(0), v -> new ArrayList<>()).add(0);
            map.computeIfAbsent(path.get(1), v -> new ArrayList<>()).add(1);
        }
        return map.entrySet().stream().filter(
                it -> it.getValue().size() == 1 && it.getValue().get(0) == 1
        ).map(Map.Entry::getKey).collect(Collectors.toList()).get(0);
    }
}
