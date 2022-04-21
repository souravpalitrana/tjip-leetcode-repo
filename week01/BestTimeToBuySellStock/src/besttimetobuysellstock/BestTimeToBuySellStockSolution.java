/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuysellstock;

/**
 *
 * @author souravpalit
 */
public class BestTimeToBuySellStockSolution {

    // Time Complexity: O(n) and Space Complexity: O(1)
    public int maxProfit(int[] prices) { 
        // As we could not sell without buying it so we can start checking from
        // the second day
        int prevMinPrice = prices[0];
        int maxProfit = 0;
        for (int dayIdx = 1; dayIdx < prices.length; dayIdx++) {
            if (prices[dayIdx] > prevMinPrice) {
                maxProfit = Math.max(maxProfit, prices[dayIdx] - prevMinPrice);
            } else {
                prevMinPrice = prices[dayIdx]; 
            }
        }
        
        return maxProfit;
    }
}
