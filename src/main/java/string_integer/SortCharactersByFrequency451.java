package string_integer;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        final Map<Character, Integer> charCountsMap = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            final Character c = s.charAt(index);
            charCountsMap.put(c, 1 + charCountsMap.getOrDefault(c, 0));
        }
        final StringBuilder result = new StringBuilder(s.length());
        final List<Pair<Integer, Character>> countsCharList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCountsMap.entrySet()) {
            countsCharList.add(new Pair<>(entry.getValue(), entry.getKey()));
        }
        countsCharList.sort((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey()));
        countsCharList.forEach(pair ->
                result.append(pair.getValue().toString().repeat(pair.getKey()))
        );
        return result.toString();
    }
}
