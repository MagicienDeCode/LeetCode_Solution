package string_integer;

public class NumberofOperationstoMakeNetworkConnected1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        final int[] reference = new int[n];

        for (int index = 0; index < reference.length; index++) {
            reference[index] = index;
        }

        for (int[] it : connections) {
            final int c1 = unionFind(reference, it[0]);
            final int c2 = unionFind(reference, it[1]);
            reference[c1] = c2;
        }

        int result = 0;
        for (int index = 0; index < reference.length; index++) {
            if (reference[index] == index) {
                ++result;
            }
        }
        return result - 1;
    }

    private int unionFind(int[] reference, int i) {
        return reference[i] == i ? i : unionFind(reference, reference[i]);
    }
}
