/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuyandsellstock.ii;

/**
 *
 * @author souravpalit
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int [] profits = new int [prices.length];
        
        // As if we buy first day and sell on the same day our profit will be
        // zero. That's why we are starting from the second day
        /*for (int sellingDayIdx = 1; sellingDayIdx < prices.length; sellingDayIdx++) {
            for (int buyingDayIdx = 0; buyingDayIdx < sellingDayIdx; buyingDayIdx++) {
                if (prices[buyingDayIdx] < prices[sellingDayIdx]) {
                    int profit = profits[buyingDayIdx] + (prices[sellingDayIdx] - prices[buyingDayIdx]);
                    profits[sellingDayIdx] = Math.max(profit, profits[sellingDayIdx]);
                }
                
                profits[sellingDayIdx] = Math.max(profits[buyingDayIdx], profits[sellingDayIdx]);
            }
        }*/
        
        // TC: O(N) SC: O(1)
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
    
}
