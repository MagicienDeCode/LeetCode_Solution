package notcategorized;

public class FindtheTownJudge997 {
    public int findJudge(int N, int[][] trust) {
        final int[] arrayN = new int[N];
        for (int[] ints : trust) {
            arrayN[ints[0] - 1]--;
            arrayN[ints[1] - 1]++;
        }
        for (int index = 0; index < arrayN.length; index++) {
            if (arrayN[index] == N - 1) {
                return index + 1;
            }
        }
        return -1;
    }

    /*
    public int findJudge(int N, int[][] trust) {
        final int[][] matrixN = new int[N][2];
        for (int[] ints : trust) {
            matrixN[ints[0] - 1][0]++;
            matrixN[ints[1] - 1][1]++;
        }
        for (int index = 0; index < matrixN.length; index++) {
            if (matrixN[index][0] == 0 && matrixN[index][1] == N - 1) {
                return index + 1;
            }
        }
        return -1;
    }
     */
}
