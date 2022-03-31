/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuysellstockii;

/**
 *
 * @author souravpalit
 */
public class BestTimeToBuySellStockIISolution {
    
    // Time complexity: O(n^2) Space Complexity:O(n)
    public int maxProfit(int[] prices) {
        int [] profits = new int [prices.length];
        
        // As if we buy first day and sell on the same day our profit will be
        // zero. That's why we are starting from the second day
        for (int sellingDayIdx = 1; sellingDayIdx < prices.length; sellingDayIdx++) {
            for (int buyingDayIdx = 0; buyingDayIdx < sellingDayIdx; buyingDayIdx++) {
                if (prices[buyingDayIdx] < prices[sellingDayIdx]) {
                    int profit = profits[buyingDayIdx] + (prices[sellingDayIdx] - prices[buyingDayIdx]);
                    profits[sellingDayIdx] = Math.max(profit, profits[sellingDayIdx]);
                }
                
                profits[sellingDayIdx] = Math.max(profits[buyingDayIdx], profits[sellingDayIdx]);
            }
        }
        
        return profits[prices.length - 1];
    }
    
}
