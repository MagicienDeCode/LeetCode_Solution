package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        final Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(
            List<Integer> price,
            List<List<Integer>> special,
            List<Integer> needs,
            Map<List<Integer>, Integer> memo
    ) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int result = withoutSpecial(price, needs);
        for (List<Integer> sp : special) {
            final List<Integer> cloneNeed = new ArrayList<>(needs);
            boolean canBenefitFrom = true;
            for (int i = 0; i < cloneNeed.size(); i++) {
                final int diff = cloneNeed.get(i) - sp.get(i);
                if (diff < 0) {
                    canBenefitFrom = false;
                    break;
                }
                cloneNeed.set(i, diff);
            }
            if (canBenefitFrom) {
                result = Math.min(result, sp.get(sp.size() - 1) + dfs(price, special, cloneNeed, memo));
            }
        }
        memo.put(needs, result);
        return result;
    }

    private int withoutSpecial(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
