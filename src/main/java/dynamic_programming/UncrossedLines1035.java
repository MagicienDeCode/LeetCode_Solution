package dynamic_programming;

public class UncrossedLines1035 {
    public int maxUncrossedLines(int[] intsA, int[] intsB) {
        final int[][] dynamicProgramming = new int[intsA.length + 1][intsB.length + 1];
        for (int indexA = 0; indexA < intsA.length; indexA++) {
            for (int indexB = 0; indexB < intsB.length; indexB++) {
                dynamicProgramming[indexA + 1][indexB + 1] =
                        intsA[indexA] == intsB[indexB] ? 1 + dynamicProgramming[indexA][indexB] :
                                Math.max(
                                        dynamicProgramming[indexA + 1][indexB],
                                        dynamicProgramming[indexA][indexB + 1]
                                );
            }
        }
        return dynamicProgramming[intsA.length][intsB.length];
    }
}
