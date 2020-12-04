package not_categorized;

public class ThekthFactorofn1429 {
    public int kthFactor(int n, int k) {
        if (k > n) {
            return -1;
        }
        int index = 0;
        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                if (++index == k) {
                    return n / i;
                }
            }
        }
        return -1;
    }
}
