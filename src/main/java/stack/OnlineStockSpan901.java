package stack;

import java.util.Stack;

public class OnlineStockSpan901 {

    private final Stack<int[]> priceCount;

    public OnlineStockSpan901() {
        priceCount = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!priceCount.isEmpty() && priceCount.peek()[0] <= price) {
            count += priceCount.pop()[1];
        }
        priceCount.push(new int[]{price, count});
        return count;
    }
}
