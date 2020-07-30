package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    private List<String> dfs(
            String s,
            List<String> wordDict,
            Map<String, List<String>> map
    ) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        final List<String> results = new ArrayList<>();
        if (s.length() == 0) {
            results.add("");
            return results;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                dfs(s.substring(word.length()), wordDict, map)
                        .forEach(
                                it -> {
                                    if (it.isEmpty()) {
                                        results.add(word);
                                    } else {
                                        results.add(word + " " + it);
                                    }
                                }
                        );
            }
        }

        map.put(s, results);
        return results;
    }
}
