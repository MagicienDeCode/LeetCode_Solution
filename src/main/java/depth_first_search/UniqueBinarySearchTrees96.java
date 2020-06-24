package depth_first_search;

public class UniqueBinarySearchTrees96 {
    // https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0
    // https://en.wikipedia.org/wiki/Catalan_number
    public int numTrees(int n) {
        long result = 1L;
        for (int index = n + 1; index < n * 2; index++) {
            result = result * index / (index - n);
        }
        return (int) (result / (n + 1));
    }
}
