package bit_operation;

import java.util.*;

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        final HashSet<String> results = new HashSet<>();
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        final HashSet<Integer> set = new HashSet<>();
        final Map<Character, Integer> map = Map.of(
                'A', 0,
                'T', 1,
                'C', 2,
                'G', 3
        );
        int current = 0;
        for (int i = 0; i < 9; i++) {
            current = (current << 2) | map.get(s.charAt(i));
        }
        /*
        TTTTT TTTTT  + C
        0(*12) 0101010101 0101010101
        if (current << 2) | map.get(s.charAt(i));
        TTTTT TTTTT C
        0(*10) 0101010101 0101010101 11

        we should remove the first 01
        TTTTT TTTTC
        0(*12) 0101010101 01010101 11

        the mask is 0(*14)1(*18)
         */
        final int mask = 262143;
        for (int i = 9; i < s.length(); i++) {
            current = ((current & mask) << 2) | map.get(s.charAt(i));
            if (set.contains(current)) {
                results.add(s.substring(i - 9, i + 1));
            } else {
                set.add(current);
            }
        }

        return new ArrayList<>(results);
    }
    /*
    public List<String> findRepeatedDnaSequences(String s) {
        final HashSet<String> results = new HashSet<>();
        final HashSet<String> set = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            final String current = s.substring(i, i + 10);
            if (set.contains(current)) {
                results.add(current);
            } else {
                set.add(current);
            }
        }
        return new ArrayList<>(results);
    }
     */
}
