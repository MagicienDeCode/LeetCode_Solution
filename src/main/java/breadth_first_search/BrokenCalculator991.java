package breadth_first_search;

public class BrokenCalculator991 {
    public int brokenCalc(int start, int end) {
        int result = 0;
        while (end > start) {
            ++result;
            if (end % 2 == 1) {
                end++;
            } else {
                end >>= 1;
            }
        }
        return result + start - end;
    }
}
