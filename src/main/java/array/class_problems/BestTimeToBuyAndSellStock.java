package array.class_problems;

import java.util.Arrays;

/**
 * Program: Best Time to Buy and Sell Stock
 * Week 4 — S4: Category C Practice Problems — L2
 * Concepts: Single pass array traversal, tracking a running minimum and maximum, basic comparison logic.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit that can be achieved by buying and selling a stock on different days.
     * 
     * @param prices Array of stock prices where prices[i] is the price on day i.
     * @return Maximum profit possible, or 0 if no profit can be made.
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - minPrice;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }

        return maxProfit;
    }

    /**
     * Helper method to compute profit and generate descriptive detail matching the sample output.
     */
    public static void displayStockAnalysis(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("Invalid input: Empty prices array.");
            return;
        }

        int minPrice = prices[0];
        int minDay = 1; // 1-based day
        int bestBuyDay = 1;
        int bestBuyPrice = minPrice;
        int bestSellDay = 1;
        int bestSellPrice = minPrice;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentDay = i + 1;
            int profit = currentPrice - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestBuyDay = minDay;
                bestBuyPrice = minPrice;
                bestSellDay = currentDay;
                bestSellPrice = currentPrice;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                minDay = currentDay;
            }
        }

        System.out.printf("prices = %s -> Output: %d ", Arrays.toString(prices), maxProfit);
        if (maxProfit > 0) {
            System.out.printf("(buy on day %d at price %d, sell on day %d at price %d)\n",
                    bestBuyDay, bestBuyPrice, bestSellDay, bestSellPrice);
        } else {
            System.out.println("(prices only fall, so no trade is profitable)");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== L2. Best Time to Buy and Sell Stock Demo ===");

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        displayStockAnalysis(prices1);

        int[] prices2 = {7, 6, 4, 3, 1};
        displayStockAnalysis(prices2);
    }
}
