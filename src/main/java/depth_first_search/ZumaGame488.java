package depth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ZumaGame488 {
    // end flag
    private static final String END = "$";

    public int findMinStep(String board, String hand) {
        // basic data structure for bfs
        final Set<String> visited = new HashSet<>();
        final Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{board + END, hand});
        int level = 0;
        // breadth first search start
        while (!queue.isEmpty()) {
            // iterate by level
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String[] currentPair = queue.poll();
                final String nowBoard = removeSame(currentPair[0]);
                // end condition
                if (nowBoard.equals(END)) {
                    return level;
                }
                final String nowHand = currentPair[1];
                // algo, for each position, for each hand, make new board and new hand,
                // if not visited new board, add it into visited and queue.
                for (int i = 0; i < nowBoard.length(); i++) {
                    for (char h : nowHand.toCharArray()) {
                        final String newString = nowBoard.substring(0, i) + h + nowBoard.substring(i);
                        if (!visited.contains(newString)) {
                            final String newHand = removeCharFromHand(nowHand, h);
                            visited.add(newString);
                            queue.offer(new String[]{newString, newHand});
                        }
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private String removeCharFromHand(String hand, char c) {
        final StringBuilder handBuild = new StringBuilder(hand);
        for (int i = 0; i < handBuild.length(); i++) {
            if (handBuild.charAt(i) == c) {
                handBuild.deleteCharAt(i);
                break;
            }
        }
        return handBuild.toString();
    }

    private String removeSame(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                continue;
            }
            if (i - start >= 3) {
                return removeSame(s.substring(0, start) + s.substring(i));
            } else {
                start = i;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        final ZumaGame488 java = new ZumaGame488();
        // "W", "W", -1
        System.out.println(java.findMinStep("W", "W"));
        // "RRWWRRBBRR"
        //"WB" 2
        System.out.println(java.findMinStep("RRWWRRBBRR", "WB"));
        // 2
        System.out.println(java.findMinStep("G", "GGGGG"));
        //"WWRRBBWW"
        //"WRBRW"  2
        System.out.println(java.findMinStep("WWRRBBWW", "WRBRW"));
        // -1
        System.out.println(java.findMinStep("WRRBBW", "RB"));

        // "WWBBWBBWW","BB", -1
        System.out.println(java.findMinStep("WWBBWBBWW", "BB"));
    }

    /*
    private final int MAX = 6;
    private final String END = "$";

    // 'R','Y','B','G','W'
    public int findMinStep(String board, String hand) {
        final Map<Character, Integer> handMap = new HashMap<>();
        handMap.put('R', 0);
        handMap.put('Y', 0);
        handMap.put('B', 0);
        handMap.put('G', 0);
        handMap.put('W', 0);
        for (char c : hand.toCharArray()) {
            handMap.put(c, 1 + handMap.get(c));
        }
        final Set<String> visited = new HashSet<>();
        visited.add(board + END);
        final int result = dfs(board + END, handMap, visited);
        return result == MAX ? -1 : result;
    }

    private int dfs(String s, Map<Character, Integer> handMap, Set<String> visited) {
        final String current = remove3Same(s);
        if (current.equals(END)) {
            return 0;
        }
        int result = MAX;
        for (int i = 0; i < current.length(); i++) {
            for (Character eachHand : handMap.keySet()) {
                if (handMap.get(eachHand) > 0) {
                    handMap.put(eachHand, handMap.get(eachHand) - 1);
                    final String newString = s.substring(0, i) + eachHand + s.substring(i);
                    if (!visited.contains(newString)) {
                        visited.add(newString);
                        result = Math.min(result,
                                1 + dfs(newString, handMap, visited));
                    }
                    handMap.put(eachHand, handMap.get(eachHand) + 1);
                }
            }
        }
        return result;
    }

    private String remove3Same(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                continue;
            }
            if (i - start >= 3) {
                return remove3Same(s.substring(0, start) + s.substring(i));
            } else {
                start = i;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        final ZumaGame488 java = new ZumaGame488();
        // "RRWWRRBBRR"
        //"WB" 2
        System.out.println(java.findMinStep("RRWWRRBBRR", "WB"));
        // 2
        System.out.println(java.findMinStep("G", "GGGGG"));
        //"WWRRBBWW"
        //"WRBRW"  2
        System.out.println(java.findMinStep("WWRRBBWW", "WRBRW"));
        // -1
        System.out.println(java.findMinStep("WRRBBW", "RB"));
    }
     */
}
