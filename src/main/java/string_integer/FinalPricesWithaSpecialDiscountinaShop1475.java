package string_integer;

public class FinalPricesWithaSpecialDiscountinaShop1475 {
    public int[] finalPrices(int[] prices) {
        final int[] results = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            final int initialPrice = prices[i];
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= initialPrice) {
                    discount = prices[j];
                    break;
                }
            }
            results[i] = initialPrice - discount;
        }
        return results;
    }
}
