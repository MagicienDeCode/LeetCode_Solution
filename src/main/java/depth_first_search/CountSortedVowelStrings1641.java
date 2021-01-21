package depth_first_search;

public class CountSortedVowelStrings1641 {
    private int result;

    public int countVowelStrings(int n) {
        result = 0;
        dfs(0, n);
        return result;
    }

    private void dfs(int startIndex, int n) {
        if (n == 0) {
            ++result;
        } else {
            for (int i = startIndex; i < 5; i++) {
                dfs(i, n - 1);
            }
        }
    }
}
