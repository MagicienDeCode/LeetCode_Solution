package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        final Map<Integer, List<Integer>> dislikesMap =
                new HashMap<>();
        for (int[] dislike : dislikes) {
            dislikesMap.computeIfAbsent(dislike[0], v -> new ArrayList<>()).add(dislike[1]);
            dislikesMap.computeIfAbsent(dislike[1], v -> new ArrayList<>()).add(dislike[0]);
        }
        final int[] hashArray = new int[n + 1];
        for (int index = 0; index < hashArray.length; index++) {
            hashArray[index] = index;
        }
        for (int index = 1; index < hashArray.length; index++) {
            if (dislikesMap.containsKey(index)) {
                final int currentHash = hash(hashArray, index);
                final List<Integer> dislikeList = dislikesMap.get(index);
                final int firstHash = hash(hashArray, dislikeList.get(0));
                if (currentHash == firstHash) {
                    return false;
                }
                for (int d = 1; d < dislikeList.size(); d++) {
                    final int dHash = hash(hashArray, dislikeList.get(d));
                    if (currentHash == dHash) {
                        return false;
                    }
                    hashArray[dHash] = firstHash;
                }
            }
        }
        return true;
    }

    private int hash(int[] hashArray, int target) {
        return target == hashArray[target] ? target : hash(hashArray, hashArray[target]);
    }
    /*
    public boolean possibleBipartition(int N, int[][] dislikes) {
        final Map<Integer, List<Integer>> dislikesMap =
                new HashMap<>();
        for (int[] dislike : dislikes) {
            dislikesMap.computeIfAbsent(dislike[0], v -> new ArrayList<>()).add(dislike[1]);
            dislikesMap.computeIfAbsent(dislike[1], v -> new ArrayList<>()).add(dislike[0]);
        }
        final int[] nArray = new int[N + 1];
        for (int index = 1; index < nArray.length; index++) {
            if (nArray[index] == 0) {
                final Queue<Integer> queue = new LinkedList<>();
                nArray[index] = 1;
                queue.offer(index);
                while (!queue.isEmpty()) {
                    final int current = queue.poll();
                    if (dislikesMap.containsKey(current)) {
                        for (int it : dislikesMap.get(current)) {
                            if (nArray[it] == nArray[current]) {
                                return false;
                            }
                            if (nArray[it] == 0) {
                                nArray[it] = -nArray[current];
                                queue.offer(it);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
     */
    /*
    public boolean possibleBipartition(int N, int[][] dislikes) {
        final int[][] dpDislikes = new int[N + 1][N + 1];
        for (int[] dislike : dislikes) {
            dpDislikes[dislike[0]][dislike[1]] = 1;
            dpDislikes[dislike[1]][dislike[0]] = 1;
        }
        final int[] nArray = new int[N + 1];
        for (int index = 1; index < nArray.length; index++) {
            if (
                    nArray[index] == 0 &&
                            canNotGroup(index, 1, nArray, dpDislikes)
            ) {
                return false;
            }
        }
        return true;
    }

    private boolean canNotGroup(
            int n,
            int group,
            int[] nArray,
            int[][] dpDislikes
    ) {
        return !canGroup(n, group, nArray, dpDislikes);
    }

    private boolean canGroup(
            int n,
            int group,
            int[] nArray,
            int[][] dpDislikes
    ) {
        nArray[n] = group;
        for (int index = 1; index < dpDislikes.length; index++) {
            if (dpDislikes[n][index] == 1) {
                if (nArray[index] == group) {
                    return false;
                }
                if (
                        nArray[index] == 0 &&
                                canNotGroup(index, -group, nArray, dpDislikes)
                ) {
                    return false;
                }
            }
        }
        return true;
    }
     */
}
