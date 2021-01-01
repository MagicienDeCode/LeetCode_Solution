package not_categorized_easy;

public class CheckArrayFormationThroughConcatenation1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            int startIndex = 0;
            while (startIndex < arr.length && arr[startIndex] != piece[0]) {
                ++startIndex;
            }
            if (startIndex == arr.length) {
                return false;
            }
            int pIndex = 1;
            startIndex++;
            while (pIndex < piece.length && startIndex < arr.length && arr[startIndex] == piece[pIndex]) {
                ++startIndex;
                ++pIndex;
            }
            if (pIndex != piece.length) {
                return false;
            }
        }
        return true;
    }
}
