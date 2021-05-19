package hash_map_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateFileinSystem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            final String[] rootContents = path.split("\\s");
            for (int i = 1; i < rootContents.length; i++) {
                final int firstIndex = rootContents[i].indexOf("(");
                map.computeIfAbsent(
                        rootContents[i].substring(firstIndex + 1,
                                rootContents[i].length() - 1), v -> new ArrayList<>()
                ).add(rootContents[0] + "/" + rootContents[i].substring(0, firstIndex));
            }
        }
        return map.values().stream().filter(it -> it.size() > 1).collect(Collectors.toList());
    }
}
