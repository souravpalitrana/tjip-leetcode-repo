/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class Solution {

    // Time Complexity: O(n) and Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenNums  = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (seenNums.containsKey(remaining)) {
                return new int [] {seenNums.get(remaining), i};
            }
            seenNums.put(nums[i], i);
        }
        
        return new int [0];
    }
}
