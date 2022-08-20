/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumproductsubarray;

/**
 *
 * @author souravpalit
 */
public class MaximumProductSubarray {

    // TC: O(n) SC: O(1)
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(max * current, min * current));
            min = Math.min(current, Math.min(max * current, min * current));
            max = tempMax;
            result = Math.max(result, max);
        }
        
        return result;
    }
    
}
