package algorithms.arrays;

public class BuySellStock1 {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Best buying price seen so far
            minPrice = Math.min(minPrice, price);

            // Profit if we sell today
            int profit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}

