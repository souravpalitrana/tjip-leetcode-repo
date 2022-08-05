/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subarraysumsdivisiblebyk;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class SubarraySumsDivisibleByK {

    // TC: O(n) SC: O(n)
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> seenPrefixSumModByK = new HashMap<>();
        seenPrefixSumModByK.put(0, 1); // Otherwise first value will not count if it is devisible by k
        int subArrayCount = 0;
        int prefixSum = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            if (prefixSum < 0) {        
                while (prefixSum < 0) {
                    prefixSum += k;
                }
            }
            
            prefixSum %= k; // To make it smaller
            int remaining = prefixSum - k;
            if (remaining < 0) {    
                remaining += k;
            }
            
            if (seenPrefixSumModByK.containsKey(remaining % k)) {  // critical
                subArrayCount += seenPrefixSumModByK.get(remaining);
            }
            seenPrefixSumModByK.put(prefixSum, seenPrefixSumModByK.getOrDefault(prefixSum, 0) + 1);
        }
        
        return subArrayCount;
    }
    
}
