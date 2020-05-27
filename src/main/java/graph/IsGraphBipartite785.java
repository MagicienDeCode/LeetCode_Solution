package graph;

public class IsGraphBipartite785 {
    public boolean isBipartite(int[][] graph) {
        final int[] hashArray = new int[graph.length];
        for (int index = 0; index < hashArray.length; index++) {
            hashArray[index] = index;
        }
        for (int index = 0; index < hashArray.length; index++) {
            if (graph[index].length > 0) {
                final int currentHash = hash(hashArray, index);
                final int[] dislikeList = graph[index];
                final int firstHash = hash(hashArray, dislikeList[0]);
                if (currentHash == firstHash) {
                    return false;
                }
                for (int d = 1; d < dislikeList.length; d++) {
                    final int dHash = hash(hashArray, dislikeList[d]);
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
    public boolean isBipartite(int[][] graph) {
        final int[] nArray = new int[graph.length];
        Arrays.fill(nArray, 7);
        for (int index = 0; index < nArray.length; index++) {
            if (nArray[index] == 7) {
                final Queue<Integer> queue = new LinkedList<>();
                nArray[index] = 1;
                queue.offer(index);
                while (!queue.isEmpty()) {
                    final int current = queue.poll();
                    for (int it : graph[current]) {
                        if (nArray[it] == nArray[current]) {
                            return false;
                        }
                        if (nArray[it] == 7) {
                            nArray[it] = -nArray[current];
                            queue.offer(it);
                        }
                    }
                }
            }
        }
        return true;
    }
     */
    /*
    public boolean isBipartite(int[][] graph) {
        final int[] nArray = new int[graph.length];
        Arrays.fill(nArray, 7);
        for (int index = 0; index < nArray.length; index++) {
            if (
                    nArray[index] == 7 &&
                            canNotGroup(index, 1, nArray, graph)
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

        for (int index : dpDislikes[n]) {
            if (nArray[index] == group) {
                return false;
            }
            if (
                    nArray[index] == 7 &&
                            canNotGroup(index, -group, nArray, dpDislikes)
            ) {
                return false;
            }

        }
        return true;
    }
     */
}
