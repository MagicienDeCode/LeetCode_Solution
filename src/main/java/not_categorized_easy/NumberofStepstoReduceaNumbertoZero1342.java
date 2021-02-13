package not_categorized_easy;

public class NumberofStepstoReduceaNumbertoZero1342 {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            result++;
        }
        return result;
    }
}
