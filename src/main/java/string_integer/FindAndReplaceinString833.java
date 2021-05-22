package string_integer;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceinString833 {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        // indexValue, index in indexes
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (s.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(s.charAt(i));
                ++i;
            }
        }
        return sb.toString();
    }
    /*
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        final StringBuilder sb = new StringBuilder();
        // sort indexes store as value => index 
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        final List<Integer> sortedIndexesValue = map.keySet().stream().sorted().collect(Collectors.toList());
        if (sortedIndexesValue.get(0) != 0) {
            sb.append(s, 0, sortedIndexesValue.get(0));
        }
        for (int i = 0; i < sortedIndexesValue.size(); i++) {
            final int startIndex = sortedIndexesValue.get(i);
            final int relatedIndex = map.get(startIndex);
            int endIndex = 0;
            while (endIndex < sources[relatedIndex].length() && sources[relatedIndex].charAt(endIndex) == s.charAt(startIndex + endIndex)) {
                endIndex++;
            }
            // source string must be fully matched, or we should NOT replace string
            if (endIndex != sources[relatedIndex].length()){
                endIndex = 0;
            }
            endIndex += startIndex;
            final int nextIndex = i == indexes.length - 1 ? s.length() : sortedIndexesValue.get(i + 1);
            // case 1 no match
            if (startIndex == endIndex) {
                sb.append(s, startIndex, nextIndex);
            } else {
                // full matched
                sb.append(targets[relatedIndex]);
                // partially matched
                if (endIndex < nextIndex) {
                    sb.append(s, endIndex, nextIndex);
                }
            }
        }
        return sb.toString();
    }
     */
}